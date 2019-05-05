package task8.controllers;

import exceptions.ValidationException;
import task8.services.FibonacciNumbersService;
import task8.validators.FibonacciNumbersValidator;
import views.ConsoleHelper;

public class FibonacciNumbersController {
    private final ConsoleHelper consoleHelper;
    private final FibonacciNumbersValidator fibonacciNumbersValidator;
    private final FibonacciNumbersService fibonacciNumbersService;

    public FibonacciNumbersController(ConsoleHelper consoleHelper) {
        this.consoleHelper = consoleHelper;
        this.fibonacciNumbersValidator = new FibonacciNumbersValidator();
        this.fibonacciNumbersService = new FibonacciNumbersService();
    }

    public void run() {
        showFibonacciNumbers();
        consoleHelper.read("Press Enter to continue.");
    }

    private void showFibonacciNumbers() {
        try {
            String firstValue = consoleHelper.read("Enter the first number");
            long firstNumber = Long.parseLong(firstValue);
            fibonacciNumbersValidator.validateNumber(firstNumber);
            String lastValue = consoleHelper.read("Enter the last number");
            long lastNumber = Long.parseLong(lastValue);
            fibonacciNumbersValidator.validateNumber(lastNumber);
            String result = fibonacciNumbersService.getFibonacciNumbers(firstNumber, lastNumber);
            consoleHelper.write(result);
        } catch (NumberFormatException e) {
            consoleHelper.write("Number format error");
        } catch (ValidationException e) {
            consoleHelper.write(e.getMessage());
        }
    }
}
