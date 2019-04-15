package task2.validators.impl;

import task2.exceptions.ValidationException;
import task2.validators.ValidationService;

public class ValidationServiceImpl implements ValidationService {

    public static final String MESSAGE_WRONG_DOUBLE = "The value entered is not double.";
    public static final String MESSAGE_MIN_VALUE = "The value entered must be greater than 0.";

    public void validateInputDouble(String s) throws ValidationException {
        double minValue = 0.1d;
        try {
            if (Double.parseDouble(s) < minValue) {
                throw new ValidationException(MESSAGE_MIN_VALUE);
            }
        } catch (NumberFormatException e) {
            throw new ValidationException(MESSAGE_WRONG_DOUBLE);
        }
    }
}
