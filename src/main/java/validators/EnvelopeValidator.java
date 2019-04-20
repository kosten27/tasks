package validators;

import exceptions.ValidationException;

public class EnvelopeValidator {
    public static final String MESSAGE_MIN_VALUE = "The value entered must be greater than 0.";

    public void validateInputDouble(Double value) throws ValidationException {
        double minValue = 0.0;
        if (value <= minValue) {
            throw new ValidationException(MESSAGE_MIN_VALUE);
        }
    }
}