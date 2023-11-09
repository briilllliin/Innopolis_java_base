package homework_1;

import java.util.Random;

public class Main {
    static Random rnd = new Random();

    public static void get_numbers() {
        int random;
        for (int i = 0; i < 4; i++) {
            random = rnd.nextInt(0, 100);
            System.out.printf("%d   ", random);
        }
    }

    public static void get_winner() {
        Player player_1 = new Player("Вася");
        Player player_2 = new Player("Петя");

        if (Math.abs(player_1.getMove() - player_2.getMove()) == 1) {
            if (player_1.getMove() > player_2.getMove()) {
                System.out.println("ПОБЕДИЛ:" + "\n" + player_2 + "\n" + "ПРОИГРАЛ: " + "\n" + player_1);
            } else {
                System.out.println("ПОБЕДИЛ:" + "\n" + player_1 + "\n" + "ПРОИГРАЛ: " + "\n" + player_2);
            }
        } else if (player_1.getMove() == player_2.getMove()) {
            System.out.println("НИЧЬЯ" + "\n" + player_1 + "\n" + player_2);
        } else if (player_1.getMove() > player_2.getMove()) {
            System.out.println("ПОБЕДИЛ:" + "\n" + player_1 + "\n" + "ПРОИГРАЛ: " + "\n" + player_2);
        } else {
            System.out.println("ПОБЕДИЛ:" + "\n" + player_2 + "\n" + "ПРОИГРАЛ: " + "\n" + player_1);
        }
    }


    public static void main(String[] args) {

        get_numbers();
        System.out.println();
        System.out.println("--------------------------------------");
        get_winner();


    }
}







