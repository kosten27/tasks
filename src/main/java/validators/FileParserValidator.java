package validators;

import exceptions.ValidationException;

public class FileParserValidator {
    private final String REQUIRED_PARAMETERS_EXCEPTION = "When you start the application, " +
            "you must pass the program arguments:\n" +
            "1. <file path> <line to count>\n" +
            "2. <file path> <search string> <replacement string>";

    public void validateParameters(String[] args) throws ValidationException {
        int minRequiredNumberOfParameters = 2;
        if (args.length < minRequiredNumberOfParameters) {
            new ValidationException(REQUIRED_PARAMETERS_EXCEPTION);
        }
    }
}
