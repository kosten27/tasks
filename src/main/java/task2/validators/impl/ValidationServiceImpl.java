package task2.validators.impl;

import task2.exceptions.ValidationException;
import task2.validators.ValidationService;

public class ValidationServiceImpl implements ValidationService {

    public static final String MESSAGE_WRONG_DOUBLE = "The value entered is not double.";

    public void validateInputDouble(String s) throws ValidationException {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            throw new ValidationException(MESSAGE_WRONG_DOUBLE);
        }
    }
}
