package task5.controllers;

import exceptions.ValidationException;
import task5.models.NumberInWordsRu;
import task5.services.NumberInWordsService;
import task5.validators.NumberInWordsValidator;
import views.ConsoleHelper;

public class NumberInWordsController {
    private final ConsoleHelper consoleHelper;
    private final NumberInWordsService numberInWordsService;
    private final NumberInWordsValidator numberInWordsValidator;

    public NumberInWordsController(ConsoleHelper consoleHelper) {
        this.consoleHelper = consoleHelper;
        this.numberInWordsService = new NumberInWordsService(new NumberInWordsRu());
        this.numberInWordsValidator = new NumberInWordsValidator();
    }

    public void run() {
        convertNumberInWords();
        consoleHelper.read("Press Enter to continue.");
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
