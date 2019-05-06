package task6.validators;

import exceptions.ValidationException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HappyTicketsValidatorTest {
    private HappyTicketsValidator happyTicketsValidator;

    @Before
    public void setUp() throws Exception {
        happyTicketsValidator = new HappyTicketsValidator();
    }

    @Test(expected = ValidationException.class)
    public void validateWrongFileContentsTest() throws ValidationException {
        //GIVEN
        String fileContents = "Any algorithm";

        //WHEN
        happyTicketsValidator.validateFileContents(fileContents);
    }

    @Test
    public void validateMoskowFileContentsTest() throws ValidationException {
        //GIVEN
        String fileContents = "Moskow";

        //WHEN
        happyTicketsValidator.validateFileContents(fileContents);
    }

    @Test
    public void validatePiterFileContentsTest() throws ValidationException {
        //GIVEN
        String fileContents = "Piter";

        //WHEN
        happyTicketsValidator.validateFileContents(fileContents);
    }
}