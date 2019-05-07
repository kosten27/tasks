package task9.controllers;

import exceptions.ValidationException;
import application.Controller;
import task9.services.ExponentiationService;
import task9.validators.ExponentiationValidator;
import application.ConsoleHelper;

public class ExponentiationControllers implements Controller {
    private final ConsoleHelper consoleHelper;
    private final ExponentiationValidator exponentiationValidator;
    private final ExponentiationService exponentiationService;

    public ExponentiationControllers(ConsoleHelper consoleHelper, ExponentiationService exponentiationService,
                                     ExponentiationValidator exponentiationValidator) {
        this.consoleHelper = consoleHelper;
        this.exponentiationValidator = exponentiationValidator;
        this.exponentiationService = exponentiationService;
    }

    public void run() {
        raiseNumberToPow();
        consoleHelper.read("Press Enter to continue.");
    }

    @Override
    public String getName() {
        return "Exponentiation";
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
