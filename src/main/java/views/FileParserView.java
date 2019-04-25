package views;

import controllers.FileParserController;

public class FileParserView {
    private final String[] args;
    private final ConsoleHelper consoleHelper;
    private final FileParserController fileParserController;

    public FileParserView(String[] args, ConsoleHelper consoleHelper) {
        this.args = args;
        this.consoleHelper = consoleHelper;
        this.fileParserController = new FileParserController();
    }

    public void show() {
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            switch (consoleHelper.read()) {
                case "1":
                    countNubmerOfLineEntries();
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

    private void countNubmerOfLineEntries() {
        String parameter = consoleHelper.read("Enter the parameters in the format: " +
                "<file path>,<line to count>");
        String numberOfLineEntriesInTextFile = fileParserController.countNumberOfLineEntriesInTextFile(parameter.split(","));
        consoleHelper.write(numberOfLineEntriesInTextFile);
    }

    private void replaceLineInFile() {
        String parameter = consoleHelper.read("Enter the parameters in the format: " +
                "<file path>,<search string>,<replacement string>");
        String resultOfReplace = fileParserController.replaceLineInFile(parameter.split(","));
        consoleHelper.write(resultOfReplace);
    }
}

