package task1.validators.impl;

import task1.exceptions.ValidationException;
import task1.validators.ValidationService;

public class ValidationServiceImpl implements ValidationService {
    private final String REQUIRED_PARAMETERS_EXCEPTION = "When you start the application, " +
            "you must pass the parameters height and width.";
    private final String REQUIRED_TYPE_OF_PARAMETERS_EXCEPTION = "Parameters should be of type integer.";

    public void validateParameters(String[] args) throws ValidationException {
        int requiredNumberOfParameters = 2;

        if (args.length < requiredNumberOfParameters) {
            throw new ValidationException(REQUIRED_PARAMETERS_EXCEPTION);
        } else {
            try {
                Integer.parseInt(args[0]);
                Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                throw new ValidationException(REQUIRED_TYPE_OF_PARAMETERS_EXCEPTION);
            }
        }
    }
}
