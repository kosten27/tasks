package task5.validators;

import exceptions.ValidationException;

public class NumberInWordsValidator {
    private final String NEGATIVE_NUMBER_EXCEPTION = "The number must be greater than zero.";

    public void validateNumber(int number) throws ValidationException {
        if (number < 0) {
            throw new ValidationException(NEGATIVE_NUMBER_EXCEPTION);
        }
    }
}
