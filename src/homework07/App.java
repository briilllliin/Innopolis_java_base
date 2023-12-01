package homework07;

import java.util.*;

public class App {

    public static Person createPerson(String name, int sum) {
        return new Person(name, sum);
    }

    public static DiscountProduct createProduct(String name, int cost, int discount) {
        return new DiscountProduct(name, cost, discount);
    }

    public static Person getPerson(String name, List<Person> personList) {

        Iterator<Person> iter = personList.iterator();

        while (iter.hasNext()) {
            Person person = iter.next();
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public static DiscountProduct getProduct(String name, List<DiscountProduct> productList) {

        Iterator<DiscountProduct> iter = productList.iterator();

        while (iter.hasNext()) {
            DiscountProduct product = iter.next();
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public static void main(String[] args) throws MyException {
        List<Person> personList = new ArrayList<>();
        List<DiscountProduct> productList = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);
        String line = " ";
        while (true) {
            System.out.println("Введите покупателей формата <Имя покупателя>" +
                    " = <Сумма, которая у него имеется>");
            line = scanner.nextLine();
            line = line.replaceAll("\\s", "");

            if (line.isEmpty()) {
                break;
            }
            StringBuilder stringBuilder = new StringBuilder(line);
            int equally = stringBuilder.indexOf("=");
            int price = Integer.parseInt(stringBuilder.substring(equally + 1, stringBuilder.length()));


            String name = stringBuilder.substring(0, equally);
            if (name.isEmpty()) {
                throw new MyException("Имя не может быть пустым");
            }
            if (price < 0) {
                throw new MyException("Деньги немогут   быть   отрицательными");
            }
            personList.add(createPerson(name, price));
        }


        while (true) {
            System.out.println("Введите продукт формата <Название продукта>" +
                    " = <Стоимость продукта>, <Скиждка%>");
            Date date = new Date();
            line = scanner.nextLine();
            line = line.replaceAll("\\s", "");
            if (line.isEmpty()) {
                break;
            }
            StringBuilder stringBuilder = new StringBuilder(line);
            int comma = stringBuilder.indexOf(",");
            int equally = stringBuilder.indexOf("=");
            int price = 0, discount = 0;

            if (comma != -1) {
                discount = Integer.parseInt(stringBuilder.substring(comma + 1, stringBuilder.length() - 1));
                if (discount <= 0) {
                    throw new MyException("Скидка не может быть равной нулю");
                }
                price = Integer.parseInt(stringBuilder.substring(equally + 1, comma));
            } else {
                price = Integer.parseInt(stringBuilder.substring(equally + 1, stringBuilder.length()));
            }
            String name = stringBuilder.substring(0, equally);
            if (name.isEmpty()) {
                throw new MyException("Имя не может быть пустым");
            }
            if (price < 0) {
                throw new MyException("Деньги не могут  быть   отрицательными");
            }
            productList.add(createProduct(name, price, discount));
            if (!productList.getLast().checkDiscount(date)) {
                System.out.println("Скидка закончилась в этот день " + productList.getLast().getDate());
            } else {
                System.out.println("Стоимость товара с учетом скидки: " + productList.getLast().getCost());
            }


        }


        while (true) {
            String answer = scanner.nextLine();

            if (answer.equals("END")) {
                for (Person person : personList) {
                    person.getProducts();
                }
                break;
            }
            String[] data = answer.split(" ");

            Person currPerson = getPerson(data[0], personList);
            Product currProduct = getProduct(data[1], productList);


            if (currPerson != null && currProduct != null) {
                currPerson.buy(currProduct);

            }

        }

    }
}

