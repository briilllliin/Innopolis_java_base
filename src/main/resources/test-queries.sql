-- 1 Получить список доступных товаров (одежда) с их описанием, и ценой
SELECT
    id AS "Идентификатор товара",
    description AS "Описание товара",
    price AS "Цена за единицу"
FROM Product;

-- 2 Вывести список покупок для выбранного клиента с указанием даты заказа, описания товара, количества купленного товара
SELECT
    c.name AS "Имя клиента",
    p.description AS "Описание товара",
    o.order_date AS "Дата заказа",
    o.product_count AS "Количество товара"
FROM Customer c
         JOIN Purchase o ON c.id = o.customer_id
         JOIN Product p ON o.product_id = p.id;

-- 3 Изменить цену товара (например, для всех джинс)
UPDATE Product
SET price = 69.99
WHERE description = 'Джинсы';

-- 4 Удалить устаревшие покупки (старше 60 дней)
DELETE FROM Purchase
WHERE (CURRENT_DATE - order_date) > 60;

-- 5 Удалить клиентов без покупок
DELETE FROM Customer
WHERE id NOT IN (
    SELECT DISTINCT customer_id
    FROM Purchase
);

-- 6 Получить список товаров, которые были куплены более чем одним клиентом
SELECT
    p.description AS "Описание товара",
    COUNT(o.customer_id) AS "Количество покупок"
FROM Product p
         JOIN Purchase o ON p.id = o.product_id
GROUP BY p.id
HAVING COUNT(o.customer_id) > 1;

-- 7 К товарам, которые не покупались больше месяца, добавить пометку "Низкий спрос"
UPDATE Product
SET description = description || ' (Низкий спрос)'
WHERE id IN (
    SELECT DISTINCT product_id
    FROM Purchase
    GROUP BY product_id
    HAVING (CURRENT_DATE - MAX(order_date)) > 30
) OR id NOT IN (
    SELECT DISTINCT product_id
    FROM Purchase
);
