package task9.validators;

import exceptions.ValidationException;
import org.junit.Before;
import org.junit.Test;

public class ExponentiationValidatorTest {
    private ExponentiationValidator exponentiationValidator;

    @Before
    public void setUp() throws Exception {
        exponentiationValidator = new ExponentiationValidator();
    }

    @Test(expected = ValidationException.class)
    public void validateNegativeExponentTest() throws ValidationException {
        //GIVEN
        int exponent = -1;

        //WHEN
        exponentiationValidator.validateExponent(exponent);
    }

    @Test
    public void validateCorrectExponentTest() throws ValidationException {
        //GIVEN
        int exponent = 0;

        //WHEN
        exponentiationValidator.validateExponent(exponent);
    }
}