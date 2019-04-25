package services;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileParserService {
    public int getNumberOfLineEntriesInTextFile(String filePath, String searchString) throws IOException {
        Path path = Paths.get(filePath);
        String fileContents = new String(Files.readAllBytes(path));
        return fileContents.split(searchString).length - 1;
    }

    public void replaceLineInFile(String filePath, String searchString, String replacementString) throws IOException {
        Path path = Paths.get(filePath);
        String fileContents = new String(Files.readAllBytes(path));
        String newFileContents = fileContents.replaceAll(searchString, replacementString);
        Files.write(path, newFileContents.getBytes());
    }
}
