package task7.controllers;

import exceptions.ValidationException;
import task7.services.NumericSequenceServices;
import task7.validators.NumericSequenceValidator;
import views.ConsoleHelper;

public class NumericSequenceController {
    private final ConsoleHelper consoleHelper;
    private final NumericSequenceValidator numericSequenceValidator;
    private final NumericSequenceServices numericSequenceServices;

    public NumericSequenceController(ConsoleHelper consoleHelper) {
        this.consoleHelper = consoleHelper;
        this.numericSequenceValidator = new NumericSequenceValidator();
        this.numericSequenceServices = new NumericSequenceServices();
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            switch (consoleHelper.read()) {
                case "1":
                    showNumberSequence();
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
        consoleHelper.write("1. Show number sequence");
        consoleHelper.write("R. Return to main menu");
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
