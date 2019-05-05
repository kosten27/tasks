package views;

import task1.controllers.ChessBoardController;
import task2.controllers.EnvelopeController;
import task3.controllers.TriangleController;
import task4.controllers.FileParserController;
import task5.controllers.NumberInWordsController;
import task6.controllers.HappyTicketsController;
import task7.controllers.NumericSequenceController;
import task8.controllers.FibonacciNumbersController;
import task9.controllers.ExponentiationControllers;

public class TaskMenu {
    private final ConsoleHelper consoleHelper;

    public TaskMenu(ConsoleHelper consoleHelper) {
        this.consoleHelper = consoleHelper;
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            switch (consoleHelper.read()) {
                case "1":
                    ChessBoardController chessBoardController = new ChessBoardController(consoleHelper);
                    chessBoardController.run();
                    break;
                case "2":
                    EnvelopeController envelopeController = new EnvelopeController(consoleHelper);
                    envelopeController.run();
                    break;
                case "3":
                    TriangleController triangleController = new TriangleController(consoleHelper);
                    triangleController.run();
                    break;
                case "4":
                    FileParserController fileParserController = new FileParserController(consoleHelper);
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
                case "7":
                    NumericSequenceController numericSequenceController = new NumericSequenceController(consoleHelper);
                    numericSequenceController.run();
                    break;
                case "8":
                    FibonacciNumbersController fibonacciNumbersController = new FibonacciNumbersController(consoleHelper);
                    fibonacciNumbersController.run();
                    break;
                case "9":
                    ExponentiationControllers exponentiationControllers = new ExponentiationControllers(consoleHelper);
                    exponentiationControllers.run();
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
        consoleHelper.write("7. Numeric sequence");
        consoleHelper.write("8. Fibonacci number range");
        consoleHelper.write("9. Exponentiation");
        consoleHelper.write("E. Exit");
    }
}
