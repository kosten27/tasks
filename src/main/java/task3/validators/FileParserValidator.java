package task3.validators;

import exceptions.ValidationException;

public class FileParserValidator {
    private final String REQUIRED_PARAMETERS_FOR_SEARCH_EXCEPTION = "You must enter the parameters in the format: " +
            "<file path>,<line to count>";
    private final String REQUIRED_PARAMETERS_FOR_REPLACE_EXCEPTION = "You must enter the parameters in the format: " +
            "<file path>,<search string>,<replacement string>";

    public void validateParametersForSearch(String[] args) throws ValidationException {
        int minRequiredNumberOfParameters = 2;
        if (args.length < minRequiredNumberOfParameters) {
            throw new ValidationException(REQUIRED_PARAMETERS_FOR_SEARCH_EXCEPTION);
        }
    }

    public void validatefParametersForReplace(String[] args) throws ValidationException {
        int minRequiredNumberOfParameters = 3;
        if (args.length < minRequiredNumberOfParameters) {
            throw new ValidationException(REQUIRED_PARAMETERS_FOR_REPLACE_EXCEPTION);
        }
    }
}
