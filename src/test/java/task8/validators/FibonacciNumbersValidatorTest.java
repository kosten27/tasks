package task8.validators;

import exceptions.ValidationException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciNumbersValidatorTest {
    private FibonacciNumbersValidator fibonacciNumbersValidator;

    @Before
    public void setUp() throws Exception {
        fibonacciNumbersValidator = new FibonacciNumbersValidator();
    }

    @Test(expected = ValidationException.class)
    public void validateNegativeNumberTest() throws ValidationException {
        //GIVEN
        int number = -1;

        //WHEN
        fibonacciNumbersValidator.validateNumber(number);
    }

    @Test
    public void validateCorrectNumberTest() throws ValidationException {
        //GIVEN
        int number = 0;

        //WHEN
        fibonacciNumbersValidator.validateNumber(number);
    }
}