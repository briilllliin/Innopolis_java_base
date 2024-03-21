-- Создание таблицы товаров
CREATE TABLE IF NOT EXISTS Product (
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    product_count FLOAT NOT NULL
);

COMMENT ON TABLE Product IS 'Таблица товаров';
COMMENT ON COLUMN Product.id IS 'Идентификатор товара';
COMMENT ON COLUMN Product.description IS 'Описание товара';
COMMENT ON COLUMN Product.price IS 'Цена товара';
COMMENT ON COLUMN Product.product_count IS 'Количество товара';

-- Заполнение таблицы товаров (одежда)
INSERT INTO Product (description, price, product_count)
VALUES
    ('Футболка', 25.99, 50),
    ('Джинсы', 59.99, 30),
    ('Платье', 79.99, 20),
    ('Куртка', 99.99, 15),
    ('Рубашка', 35.99, 40),
    ('Брюки', 45.99, 35),
    ('Шапка', 15.99, 100),
    ('Шарф', 10.99, 80),
    ('Перчатки', 8.99, 120),
    ('Носки', 5.99, 150),
    ('Пиджак', 129.99, 10);

-- Создание таблицы клиентов
CREATE TABLE IF NOT EXISTS Customer (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

COMMENT ON TABLE Customer IS 'Таблица клиентов';
COMMENT ON COLUMN Customer.id IS 'Идентификатор клиента';
COMMENT ON COLUMN Customer.name IS 'Имя/Фамилия клиента';

-- Заполнение таблицы клиентов
INSERT INTO Customer (name)
VALUES
    ('Иван Иванов'),
    ('Петр Петров'),
    ('Мария Сидорова'),
    ('Анна Иванова'),
    ('Василий Пупкин'),
    ('Ольга Новикова'),
    ('Дмитрий Кузнецов'),
    ('Екатерина Петрова'),
    ('Алексей Смирнов'),
    ('Наталья Васильева'),
    ('Сергей Иванов'),
    ('Татьяна Козлова'),
    ('Максим Михайлов'),
    ('Ангелина Ильина'),
    ('Роман Павлов');

-- Создание таблицы заказов
CREATE TABLE IF NOT EXISTS Purchase (
    id SERIAL PRIMARY KEY,
    product_id SERIAL REFERENCES Product(id) NOT NULL,
    customer_id SERIAL REFERENCES Customer(id) NOT NULL,
    order_date DATE DEFAULT CURRENT_DATE,
    product_count INT DEFAULT 1
);

COMMENT ON TABLE Purchase IS 'Таблица покупок';
COMMENT ON COLUMN Purchase.product_id IS 'Идентификатор товара';
COMMENT ON COLUMN Purchase.customer_id IS 'Идентификатор клиента';
COMMENT ON COLUMN Purchase.order_date IS 'Дата заказа';
COMMENT ON COLUMN Purchase.product_count IS 'Количество товара в заказе';


INSERT INTO Purchase (product_id, customer_id, product_count)
VALUES
    (1, 1, 2),
    (3, 3, 1),
    (4, 5, 3),
    (7, 6, 1),
    (2, 8, 2),
    (5, 10, 1),
    (6, 11, 2),
    (9, 12, 3),
    (10, 13, 4),
    (11, 14, 1);





