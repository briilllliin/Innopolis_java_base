package homework06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App {

    public static Person createPerson(String name, int sum) {
        return new Person(name, sum);
    }

    public static Product createProduct(String name, int cost) {
        return new Product(name, cost);
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

    public static Product getProduct(String name, List<Product> productList) {

        Iterator<Product> iter = productList.iterator();

        while (iter.hasNext()) {
            Product product = iter.next();
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public static void main(String[] args) throws MyException {
        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);
        String line = " ";
        while (true) {
            System.out.println("Введите покупателей формата <Имя покупателя>" +
                    " = <Сумма, которая у него имеется>, если хотите приступить к вводу продуктов  - введите 1");
            line = scanner.nextLine();

            if (line.isEmpty()) {
                break;
            }
            String[] person = line.split(" = ");

            String name = person[0];
            if (name.isEmpty()) {
                throw new MyException("Имя не может быть пустым");
            }
            String total = person[1];
            int sum = Integer.parseInt(total.trim());
            if (sum < 0) {
                throw new MyException("Деньги немогут   быть   отрицательными");
            }


            personList.add(createPerson(name, sum));

        }


        while (true) {
            System.out.println("Введите продукт формата <Название продукта>" +
                    " = <Стоимость продукта>");
            line = scanner.nextLine();

            if (line.isEmpty()) {
                break;
            }
            String[] product = line.split(" = ");
            String name = product[0];
            if (name.isEmpty()) {
                throw new MyException("Имя не может быть пустым");
            }
            String total = product[1];
            int sum = Integer.parseInt(total.trim());
            if (sum < 0) {
                throw new MyException("Деньги немогут   быть   отрицательными");
            }
            productList.add(createProduct(name, sum));


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

