package task5.controllers;

import exceptions.ValidationException;
import application.Controller;
import task5.services.NumberInWordsService;
import task5.validators.NumberInWordsValidator;
import application.ConsoleHelper;

public class NumberInWordsController implements Controller {
    private final ConsoleHelper consoleHelper;
    private final NumberInWordsService numberInWordsService;
    private final NumberInWordsValidator numberInWordsValidator;

    public NumberInWordsController(ConsoleHelper consoleHelper, NumberInWordsService numberInWordsService,
                                   NumberInWordsValidator numberInWordsValidator) {
        this.consoleHelper = consoleHelper;
        this.numberInWordsService = numberInWordsService;
        this.numberInWordsValidator = numberInWordsValidator;
    }

    public void run() {
        convertNumberInWords();
        consoleHelper.read("Press Enter to continue.");
    }

    @Override
    public String getName() {
        return "Number in words";
    }

    private void convertNumberInWords() {
        String inputValue = consoleHelper.read("Enter a number");
        try {
            int inputInteger = Integer.parseInt(inputValue);
            numberInWordsValidator.validateNumber(inputInteger);
            String numberInWords = numberInWordsService.convertNumberInWords(inputInteger);
            consoleHelper.write(inputValue + " - " + numberInWords);
        } catch (NumberFormatException e) {
            consoleHelper.write("Invalid value entered");
        } catch (ValidationException e) {
            consoleHelper.write(e.getMessage());
        }
    }
}
