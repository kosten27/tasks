package validators;


import exceptions.ValidationException;

public class ChessBoardValidator {
    private final String REQUIRED_PARAMETERS_EXCEPTION = "When you start the application, " +
            "you must pass the program arguments height and width of the chessboard.";
    private final String REQUIRED_TYPE_OF_PARAMETERS_EXCEPTION = "Program arguments for a chessboard should be " +
            "of a numeric type.";
    private final String MIN_VALUE_OF_PARAMETERS_EXCEPTION = "Program arguments for a chessboard should be " +
            "greater than 1.";

    public void validateParameters(String[] args) throws ValidationException {
        int requiredNumberOfParameters = 2;
        int minValueOfParameter = 2;

        if (args.length < requiredNumberOfParameters) {
            throw new ValidationException(REQUIRED_PARAMETERS_EXCEPTION);
        } else {
            try {
                for (int i = 0; i < requiredNumberOfParameters; i++) {
                    if (Integer.parseInt(args[i]) < minValueOfParameter) {
                        throw new ValidationException(MIN_VALUE_OF_PARAMETERS_EXCEPTION);
                    }
                }
            } catch (NumberFormatException e) {
                throw new ValidationException(REQUIRED_TYPE_OF_PARAMETERS_EXCEPTION);
            }
        }
    }
}
