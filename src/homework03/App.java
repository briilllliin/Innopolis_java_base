package homework_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static TV create_tv(String model, int diagonal, int price) {
        return new TV(model, diagonal, price);
    }

    public static void main(String[] args) {

        String model;
        int diagonal, price;
        TV tv1 = new TV("Samsung", 65, 50000);
        TV tv2 = new TV("LG", 45, 30000);
        List<TV> listTV = new ArrayList<>();
        listTV.add(tv1);
        listTV.add(tv2);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Выберите что хотите сделать: 1 - Создать новый телевизор, " + "2 - Вывести список имеющихся телевизоров,\n3 - Включить все телевизоры, 4 - выключить все телевизоры, 5 - Выйти");
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    System.out.println("Введите модель ТВ, диагональ, стоимость");
                    model = scanner.next();
                    diagonal = scanner.nextInt();
                    price = scanner.nextInt();
                    listTV.add(create_tv(model, diagonal, price));
                    break;
                case 2:
                    for (TV tv : listTV) {
                        System.out.println(tv);
                    }
                    break;
                case 3:
                    for (TV tv : listTV) {
                        tv.turn_on();
                    }
                    break;
                case 4:
                    for (TV tv : listTV) {
                        tv.turn_off();
                    }
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("Вы ввели что-то неправильно :(");

            }
        }


    }
}
