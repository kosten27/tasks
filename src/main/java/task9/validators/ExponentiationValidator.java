package task9.validators;

import exceptions.ValidationException;

public class ExponentiationValidator {
    private final String NEGATIVE_EXPONENT_EXCEPTION = "Exponent must be greater than zero.";

    public void validateExponent(long exponent) throws ValidationException {
        if (exponent < 0) {
            throw new ValidationException(NEGATIVE_EXPONENT_EXCEPTION);
        }
    }
}
