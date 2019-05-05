package task2.validators;

import exceptions.ValidationException;

public class EnvelopeValidator {
    private static final String MESSAGE_MIN_VALUE = "The height and width of the envelope must be greater than 0.";

    public void validateParameters(double height, double width) throws ValidationException {
        double minValue = 0.0;
        if (height <= minValue || width <= minValue) {
            throw new ValidationException(MESSAGE_MIN_VALUE);
        }
    }
}