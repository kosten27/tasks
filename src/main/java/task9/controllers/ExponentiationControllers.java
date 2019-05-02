package task9.controllers;

import exceptions.ValidationException;
import task9.services.ExponentiationService;
import task9.validators.ExponentiationValidator;
import views.ConsoleHelper;

public class ExponentiationControllers {
    private final ConsoleHelper consoleHelper;
    private final ExponentiationValidator exponentiationValidator;
    private final ExponentiationService exponentiationService;

    public ExponentiationControllers(ConsoleHelper consoleHelper) {
        this.consoleHelper = consoleHelper;
        this.exponentiationValidator = new ExponentiationValidator();
        this.exponentiationService = new ExponentiationService();
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            switch (consoleHelper.read()) {
                case "1":
                    raiseNumberToPow();
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
        consoleHelper.write("1. Raise the number to a power");
        consoleHelper.write("R. Return to main menu");
    }

    private void raiseNumberToPow() {
        try {
            String inputNumber = consoleHelper.read("Enter the number");
            long number = Long.parseLong(inputNumber);
            String inputExponent = consoleHelper.read("Enter exponent");
            int exponent = Integer.parseInt(inputExponent);
            exponentiationValidator.validateExponent(exponent);
            long pow = exponentiationService.raiseNumberToPow(number, exponent);
            consoleHelper.write(Long.toString(pow));
        } catch (NumberFormatException e) {
            consoleHelper.write("Number format error");
        } catch (ValidationException e) {
            consoleHelper.write(e.getMessage());
        }
    }
}
