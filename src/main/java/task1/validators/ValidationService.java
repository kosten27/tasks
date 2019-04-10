package task1.validators;

import task1.exceptions.ValidationException;

public interface ValidationService {
    void validateParameters(String[] args) throws ValidationException;
}
