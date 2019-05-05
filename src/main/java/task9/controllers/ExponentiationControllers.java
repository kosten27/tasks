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
        raiseNumberToPow();
        consoleHelper.read("Press Enter to continue.");
    }

    private void raiseNumberToPow() {
        try {
            String inputNumber = consoleHelper.read("Enter the number");
            double number = Double.parseDouble(inputNumber);
            String inputExponent = consoleHelper.read("Enter exponent");
            long exponent = Long.parseLong(inputExponent);
            exponentiationValidator.validateExponent(exponent);
            double pow = exponentiationService.raiseNumberToPow(number, exponent);
            consoleHelper.write(String.valueOf(pow));
        } catch (NumberFormatException e) {
            consoleHelper.write("Number format error");
        } catch (ValidationException e) {
            consoleHelper.write(e.getMessage());
        }
    }
}
