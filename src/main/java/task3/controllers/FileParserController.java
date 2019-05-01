package task3.controllers;

import exceptions.ValidationException;
import task3.services.FileParserService;
import task3.services.FileWorkerService;
import task3.validators.FileParserValidator;
import views.ConsoleHelper;

import java.io.IOException;

public class FileParserController {
    private final String[] args;
    private final ConsoleHelper consoleHelper;
    private final FileWorkerService fileWorkerService;
    private final FileParserService fileParserService;
    private final FileParserValidator fileParserValidator;

    public FileParserController(String[] args, ConsoleHelper consoleHelper) {
        this.args = args;
        this.consoleHelper = consoleHelper;
        fileWorkerService = new FileWorkerService();
        fileParserService = new FileParserService(fileWorkerService);
        fileParserValidator = new FileParserValidator();
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            switch (consoleHelper.read()) {
                case "1":
                    countNumberOfLineEntries();
                    break;
                case "2":
                    replaceLineInFile();
                    break;
                case "R":
                    isRunning = false;
                    break;
                default:
                    consoleHelper.write("Wrong input!");
                    break;
            }
        }
    }

    private void showMenu() {
        consoleHelper.write("1. Count the number of line entries");
        consoleHelper.write("2. Replace line in file");
        consoleHelper.write("R. Return to main menu");
    }

    private void countNumberOfLineEntries() {
        String parameter = consoleHelper.read("Enter the parameters in the format: " +
                "<file path>,<line to count>");
        String numberOfLineEntriesInTextFile = countNumberOfLineEntriesInTextFile(parameter.split(","));
        consoleHelper.write(numberOfLineEntriesInTextFile);
    }

    private void replaceLineInFile() {
        String parameter = consoleHelper.read("Enter the parameters in the format: " +
                "<file path>,<search string>,<replacement string>");
        String resultOfReplace = replaceLineInFile(parameter.split(","));
        consoleHelper.write(resultOfReplace);
    }

    public String countNumberOfLineEntriesInTextFile(String[] args) {
        int numberOfLineEntries = 0;
        try {
            fileParserValidator.validateParametersForSearch(args);
            String filePath = args[0];
            String s = args[1];
            numberOfLineEntries = fileParserService.getNumberOfLineEntriesInTextFile(filePath, s);
        } catch (IOException | ValidationException e) {
            return e.getMessage();
        }
        return "The number of line entries in the text file is " + numberOfLineEntries;
    }

    public String replaceLineInFile(String[] args) {
        try {
            fileParserValidator.validatefParametersForReplace(args);
            String filePath = args[0];
            String searchString = args[1];
            String replacementString = args[2];
            fileParserService.replaceLineInFile(filePath, searchString, replacementString);
        } catch (IOException | ValidationException e) {
            return e.getMessage();
        }
        return "Replacing lines in the file is completed.";
    }
}
