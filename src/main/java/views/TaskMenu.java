package views;

import task4.controllers.FileParserController;
import task5.controllers.NumberInWordsController;
import task6.controllers.HappyTicketsController;

public class TaskMenu {

    private final String[] args;
    private final ConsoleHelper consoleHelper;

    public TaskMenu(String[] args) {
        this.args = args;
        this.consoleHelper = new ConsoleHelper();
    }

    public void show() {
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            switch (consoleHelper.read()) {
                case "1":
                    ChessBoardView chessBoardView = new ChessBoardView(args, consoleHelper);
                    chessBoardView.show();
                    break;
                case "2":
                    EnvelopeView envelopeView = new EnvelopeView(consoleHelper);
                    envelopeView.show();
                    break;
                case "3":
                    TriangleView triangleView = new TriangleView(consoleHelper);
                    triangleView.show();
                    break;
                case "4":
                    FileParserController fileParserController = new FileParserController(args, consoleHelper);
                    fileParserController.run();
                    break;
                case "5":
                    NumberInWordsController numberInWordsController = new NumberInWordsController(consoleHelper);
                    numberInWordsController.run();
                    break;
                case "6":
                    HappyTicketsController happyTicketsController = new HappyTicketsController(consoleHelper);
                    happyTicketsController.run();
                    break;
                case "E":
                    isRunning = false;
                    break;
                default:
                    consoleHelper.write("Wrong input!");
                    break;
            }
        }
    }

    private void showMenu() {
        consoleHelper.write("1. Chess board");
        consoleHelper.write("2. Envelope analysis");
        consoleHelper.write("3. Sort triangles");
        consoleHelper.write("4. File parser");
        consoleHelper.write("5. Number in words");
        consoleHelper.write("6. Happy tickets");
        consoleHelper.write("E. Exit");
    }
}
