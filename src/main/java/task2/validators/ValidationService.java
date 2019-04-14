package task2.validators;

import task2.exceptions.ValidationException;

public interface ValidationService {
    void validateInputDouble(String s) throws ValidationException;
}
