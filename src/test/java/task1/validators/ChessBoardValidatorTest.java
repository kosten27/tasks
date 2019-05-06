package task1.validators;

import exceptions.ValidationException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChessBoardValidatorTest {
    private ChessBoardValidator chessBoardValidator;

    @Before
    public void setUp() throws Exception {
        chessBoardValidator = new ChessBoardValidator();
    }

    @Test(expected = ValidationException.class)
    public void validateWrongParametersTest() throws ValidationException {
        //GIVEN
        int wrongHeight = 1;
        int wrongWidth = 1;

        //WHEN
        chessBoardValidator.validateParameters(wrongHeight, wrongWidth);
    }

    @Test
    public void validateCorrectParametersTest() throws ValidationException {
        //GIVEN
        int correctHeight = 2;
        int correctWidth = 2;

        //WHEN
        chessBoardValidator.validateParameters(correctHeight, correctWidth);
    }
}