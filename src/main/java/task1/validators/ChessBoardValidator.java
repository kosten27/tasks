package task1.validators;


import exceptions.ValidationException;

public class ChessBoardValidator {
    private final String MIN_VALUE_OF_PARAMETERS_EXCEPTION = "The height and width of the chessboard " +
            "must be at least two.";

    public void validateParameters(int height, int width) throws ValidationException {
        int minValueOfParameter = 2;
            if (height < minValueOfParameter || width < minValueOfParameter) {
                throw new ValidationException(MIN_VALUE_OF_PARAMETERS_EXCEPTION);
            }
    }
}
