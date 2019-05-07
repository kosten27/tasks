package task7.controllers;

import exceptions.ValidationException;
import application.Controller;
import task7.services.NumericSequenceServices;
import task7.validators.NumericSequenceValidator;
import application.ConsoleHelper;

public class NumericSequenceController implements Controller {
    private final ConsoleHelper consoleHelper;
    private final NumericSequenceValidator numericSequenceValidator;
    private final NumericSequenceServices numericSequenceServices;

    public NumericSequenceController(ConsoleHelper consoleHelper, NumericSequenceServices numericSequenceServices,
                                     NumericSequenceValidator numericSequenceValidator) {
        this.consoleHelper = consoleHelper;
        this.numericSequenceValidator = numericSequenceValidator;
        this.numericSequenceServices = numericSequenceServices;
    }

    public void run() {
        showNumberSequence();
        consoleHelper.read("Press Enter to continue.");
    }

    @Override
    public String getName() {
        return "Numeric sequence";
    }

    private void showNumberSequence() {
        String inputValue = consoleHelper.read("Enter the number:");
        try {
            int number = Integer.parseInt(inputValue);
            numericSequenceValidator.validateNumber(number);
            String numberSequence = numericSequenceServices.getNumberSequence(number);
            consoleHelper.write(numberSequence);
        } catch (NumberFormatException e) {
            consoleHelper.write("Number format error");
        } catch (ValidationException e) {
            consoleHelper.write(e.getMessage());
        }
    }
}
