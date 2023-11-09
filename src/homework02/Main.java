package homework02;

import java.util.Scanner;

public class Main {


    public static double converterFtoC(int fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9;
    }

    public static void operation(int a, int b) {

        System.out.printf("Сумма двух целых чисел: %d \n", a + b);
        System.out.printf("Разница двух целых чисел: %d \n", a - b);
        System.out.printf("Произведение из двух целых чисел: %d \n", a * b);
        System.out.printf("Среднее из двух целых чисел: %.2f \n", (double) (a + b) / 2);
        System.out.printf("Расстояние двух целых чисел: %d \n", Math.abs(a - b));
        System.out.printf("Максимальное целое число: %d \n", Math.max(a, b));
        System.out.printf("Минимальное целое число: %d \n", Math.min(a, b));


    }

    public static void generate_str(String str, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(str);
            }
            System.out.println();

        }
    }

    public static StringBuilder generate(String str, int n) {
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (i < n) {
            result.append(str);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите степень в градусах Фаренгейта: ");
        int fahrenheit = scanner.nextInt();
        Double fahrenheitD = (double) fahrenheit;
        System.out.printf("%.1f градусов по Фаренгейту равна %.1f по Цельсию \n", fahrenheitD, converterFtoC(fahrenheit));
        System.out.println("-------------------------------------------------------------");

        System.out.println("Введите 1-е целое число:");
        int a = scanner.nextInt();
        System.out.println("Введите 2-ое целое число:");
        int b = scanner.nextInt();
        operation(a, b);
        System.out.println("-------------------------------------------------------------");

        System.out.println("Исходная строка:");
        String str = scanner.next();

        System.out.println("Сколько раз вывести строку?");
        int n = scanner.nextInt();
        System.out.printf("После повторения %d раз: %s \n", n, generate(str, n));
        System.out.println("---------------------------------------------------------------------------------------------- \n");

        System.out.println("Введите число строк и столбцов сетки:");
        n = scanner.nextInt();
        System.out.println("Введите повторяемый элемент сетки:");
        str = scanner.next();

        generate_str(str, n);


    }
}
