package controllers;

import exceptions.ValidationException;
import services.FileParserService;
import validators.FileParserValidator;

import java.io.IOException;

public class FileParserController {
    private final FileParserService fileParserService;
    private final FileParserValidator fileParserValidator;

    public FileParserController() {
        fileParserService = new FileParserService();
        fileParserValidator = new FileParserValidator();
    }

    public String countNumberOfLineEntriesInTextFile(String[] args) {
        int numberOfLineEntries = 0;
        try {
            fileParserValidator.validateParameters(args);
            String filePath = args[0];
            String s = args[1];
            numberOfLineEntries = fileParserService.getNumberOfLineEntriesInTextFile(filePath, s);
        } catch (IOException | ValidationException e) {
            return e.getMessage();
        }
        return "The number of line entries in the text file is " + numberOfLineEntries;
    }

    public String replaceLineInFile(String[] args) {
        String filePath = args[0];
        String searchString = args[1];
        String replacementString = args[2];
        try {
            fileParserService.replaceLineInFile(filePath, searchString, replacementString);
        } catch (IOException e) {
            return e.getMessage();
        }
        return "Replacing lines in the file is completed.";
    }
}
