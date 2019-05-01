package task3.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWorkerService {
    public String getFileContents(String filePath) throws IOException {
        String contents = "";
        Path path = Paths.get(filePath);
        try {
            contents = new String(Files.readAllBytes(path));
        } catch (IOException e) {
            throw new IOException("Error reading file");
        }
        return contents;
    }

    public void putFileContents(String filePath, String contents) throws IOException {
        Path path = Paths.get(filePath);
        try {
            Files.write(path, contents.getBytes());
        } catch (IOException e) {
            throw new IOException("Error writing file");
        }
    }
}
