package homework_4;

import java.io.*;
import java.util.*;

public class App {

    public static String readFromTxt(String inputName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputName));
        String line = reader.readLine();
        reader.close();
        return line;
    }

    public static char get_letter(char letter) {
        char result = ' ';
        char[] letters = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a',
                's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b',
                'n', 'm'};
        for (int i = 0; i < letters.length; i++) {
            if (letter == letters[i]) {
                if (i != 0) {
                    result = letters[i - 1];
                } else {
                    result = letters[letters.length - 1];
                }
            }
        }
        return result;
    }

    public static int get_arrow(String text) {
        ArrayList<Integer> foundPositions = new ArrayList<>();

        String arrowLeft = "<--<<";
        String arrowRight = ">>-->";

        for (int i = 0; i < text.length(); i++) {
            int j = 0;
            int k = 0;
            while (k < arrowRight.length() && i + k < text.length() && arrowRight.charAt(k) == text.charAt(k + i)) {
                k++;
            }
            if (k == arrowRight.length()) {
                foundPositions.add(i);
            }

            while (j < arrowLeft.length() && i + j < text.length() && arrowLeft.charAt(j) == text.charAt(j + i)) {
                j++;
            }
            if (j == arrowLeft.length()) {
                foundPositions.add(i);
            }
        }
        return foundPositions.size();


    }


    public static String get_solve(String text) {
        String result = " ";
        List<String> myList = new ArrayList<>(Arrays.asList(text.split("")));
        List<String> listLowerCase = new ArrayList<>();

        for (String s : myList) {
            String lowerCase = s.toLowerCase();
            listLowerCase.add(lowerCase);
            if (Objects.equals(s, " ")) {
                listLowerCase.remove(s);
            }
        }

        Collections.sort(listLowerCase);
        for (String s : listLowerCase) {
            System.out.print(s);
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите маленькую букву английского алфавита: ");
        char letter = scanner.next().charAt(0);
        System.out.println("Буква, стоящая слева от заданной буквы,с учетом замкнутости клавиатуры: ");
        System.out.println(get_letter(letter));
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Введите последовательность из < > -, стрелы имеют вид <--<<, >>->");
        //>>--><--<<<--<<<--<<
        String input = scanner.next();
        System.out.println(get_arrow(input));

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Читаем из файла последовательность букв");
        input = readFromTxt("C:\\Users\\briil\\IdeaProjects\\lab1\\src\\homework_4\\input01.txt");
        get_solve(input);
    }
}
