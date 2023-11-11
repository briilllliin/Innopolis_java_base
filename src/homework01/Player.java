package homework_1;

import java.util.Random;


public class Player {
    Random rnd = new Random();

    private enum Move {
        ROCK, PAPER, SCISSORS
    }

    private Move name_move;
    private String name;

    public Player(String name) {
        this.name = name;
        get_number(move);
    }

    public int getMove() {
        return move;
    }

    private final int move = rnd.nextInt(0, 3);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "move=" + name_move +
                ", name='" + name + '\'' +
                '}';
    }

    private void get_number(int move) {

        switch (move) {
            case 0:
                name_move = Move.ROCK;
                break;
            case 2:
                name_move = Move.PAPER;
                break;
            case 1:
                name_move = Move.SCISSORS;
                break;
        }

    }
}
