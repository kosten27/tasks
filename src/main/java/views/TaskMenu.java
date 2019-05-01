package views;

import task3.controllers.FileParserController;

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
//                    FileParserView fileParserView = new FileParserView(args, consoleHelper);
//                    fileParserView.show();
                    FileParserController fileParserController = new FileParserController(args, consoleHelper);
                    fileParserController.run();
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
        consoleHelper.write("E. Exit");
    }
}
