package utils;

import java.io.*;

public class FileHelper {

    final static String PATH = "src/resources/input.txt";

    public String readFromFile(){

        StringBuilder resultString = new StringBuilder();

        try (BufferedReader bufferReader = new BufferedReader(new FileReader(PATH))) {
            String line;
            while((line = bufferReader.readLine()) != null) {
                resultString.append(line);
                resultString.append("\n");
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        return resultString.toString();

    }


    public void writeToFile(String usersInfoString, boolean flag) {
        try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(PATH, flag))) {
            bufferWriter.append(usersInfoString);
            bufferWriter.append("\n");
        } catch (IOException e) {
            System.out.println("Во время записи в файл возникла проблема: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }
}
