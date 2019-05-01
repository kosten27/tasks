package task4.services;

import util.StringParser;

import java.io.IOException;

public class FileParserService {
    private final FileWorkerService fileWorkerService;

    public FileParserService(FileWorkerService fileWorkerService) {
        this.fileWorkerService = fileWorkerService;
    }

    public int getNumberOfLineEntriesInTextFile(String filePath, String searchString) throws IOException {
        String fileContents = fileWorkerService.getFileContents(filePath);
        return StringParser.getNumberOfSubstring(fileContents, searchString);
    }

    public void replaceLineInFile(String filePath, String searchString, String replacementString) throws IOException {
        String fileContents = fileWorkerService.getFileContents(filePath);
        String newFileContents = fileContents.replaceAll(searchString, replacementString);
        fileWorkerService.putFileContents(filePath, newFileContents);
    }
}
