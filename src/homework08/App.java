package homework08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws MyException, IOException {
        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        List<String> output = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);
        MyFileReader in = new MyFileReader();
        MyFileWriter out = new MyFileWriter();

        String line = " ";
        List<String> lines = in.readFromLine();
        int count = 0;

        for (String l : lines) {

            if (l.equals("")) {
                count++;
            }

            if (count == 0 && !l.equals("")) {

                String[] person = l.split(" = ");

                String name = person[0];
                if (name.isEmpty()) {
                    throw new MyException("Имя не может быть пустым");
                }
                String total = person[1];
                int sum = Integer.parseInt(total.trim());
                if (sum < 0) {
                    throw new MyException("Деньги немогут   быть   отрицательными");
                }


                personList.add(Person.createPerson(name, sum));

            }

            if (count == 1 && !l.equals("")) {


                String[] product = l.split(" = ");
                String name = product[0];
                if (name.isEmpty()) {
                    throw new MyException("Имя не может быть пустым");
                }
                String total = product[1];
                int sum = Integer.parseInt(total.trim());
                if (sum < 0) {
                    throw new MyException("Деньги немогут   быть   отрицательными");
                }
                productList.add(Product.createProduct(name, sum));


            }


            if (count == 2 && !l.equals("")) {


                if (l.equals("END")) {
                    for (Person person : personList) {
                        output.addAll(person.getProducts());

                    }

                    break;
                }
                String[] data = l.split(" ");


                Person currPerson = Person.getPerson(data[0], personList);
                Product currProduct = Product.getProduct(data[1], productList);


                if (currPerson != null && currProduct != null) {
                    output.add(currPerson.buy(currProduct));

                }

            }

        }

        out.writeFromLine(output);
    }
}