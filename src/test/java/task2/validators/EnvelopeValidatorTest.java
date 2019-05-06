package task2.validators;

import exceptions.ValidationException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnvelopeValidatorTest {
    private EnvelopeValidator envelopeValidator;

    @Before
    public void setUp() throws Exception {
        envelopeValidator = new EnvelopeValidator();
    }

    @Test(expected = ValidationException.class)
    public void validateWrongParametersTest() throws ValidationException {
        //GIVEN
        double wrongHeight = 0.0;
        double wrongWidth = 0.0;

        //WHEN
        envelopeValidator.validateParameters(wrongHeight, wrongWidth);
    }

    @Test
    public void validateCorrectParametersTest() throws ValidationException {
        //GIVEN
        double wrongHeight = 0.1;
        double wrongWidth = 0.1;

        //WHEN
        envelopeValidator.validateParameters(wrongHeight, wrongWidth);
    }
}