package homework08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MyFileReader {

    public final String path = "C:\\Users\\briil\\IdeaProjects\\lab1\\src\\homework08\\input.txt";
    public MyFileReader() {
    }

    public List<String> readFromLine() throws IOException {
        Path inPath = Paths.get(path);
        return Files.readAllLines(inPath);
    }

}
