package homework08;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MyFileWriter {

    public final String path = "C:\\Users\\briil\\IdeaProjects\\lab1\\src\\homework08\\output.txt";
    public MyFileWriter() {
    }

    public String readFromFile() throws IOException {

        String text = "";
        StringBuilder stringBuilder = new StringBuilder();


        FileInputStream fileInputStream = new FileInputStream(path);
        int read = fileInputStream.read();
        while (read >= 0) {
            char currentChar = (char) read;
            stringBuilder.append(currentChar);
            read = fileInputStream.read();
        }
        text = stringBuilder.toString();
        return text;

    }

    public void writeFromLine(List<String> line) throws IOException {
        Path outPath = Paths.get(path);
        Files.write(outPath, line);
    }
}


