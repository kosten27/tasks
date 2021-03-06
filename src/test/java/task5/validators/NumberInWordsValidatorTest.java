package task5.validators;

import exceptions.ValidationException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberInWordsValidatorTest {
    private NumberInWordsValidator numberInWordsValidator;

    @Before
    public void setUp() throws Exception {
        numberInWordsValidator = new NumberInWordsValidator();
    }

    @Test(expected = ValidationException.class)
    public void validateNegativeNumberTest() throws ValidationException {
        //GIVEN
        int number = -1;

        //WHEN
        numberInWordsValidator.validateNumber(number);
    }

    @Test
    public void validateCorrectNumberTest() throws ValidationException {
        //GIVEN
        int number = 0;

        //WHEN
        numberInWordsValidator.validateNumber(number);
    }
}