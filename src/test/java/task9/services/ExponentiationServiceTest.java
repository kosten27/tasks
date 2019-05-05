package task9.services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExponentiationServiceTest {
    private ExponentiationService exponentiationService;

    @Before
    public void setUp() throws Exception {
        exponentiationService = new ExponentiationService();
    }

    @Test
    public void raiseNumberToPowTest() {
        //GIVEN
        double number = 5.0;
        long exponent = 5;
        double expectedResult = 3125.0;

        //WHEN
        double result = exponentiationService.raiseNumberToPow(number, exponent);

        //THEN
        assertEquals(expectedResult, result, 0);
    }

    @Test
    public void raiseNumberToPowZeroExponentTest() {
        //GIVEN
        double number = 5.0;
        long exponent = 0;
        double expectedResult = 1.0;

        //WHEN
        double result = exponentiationService.raiseNumberToPow(number, exponent);

        //THEN
        assertEquals(expectedResult, result, 0);
    }

    @Test
    public void raiseNumberToPowOneExponentTest() {
        //GIVEN
        double number = 5.0;
        long exponent = 1;
        double expectedResult = number;

        //WHEN
        double result = exponentiationService.raiseNumberToPow(number, exponent);

        //THEN
        assertEquals(expectedResult, result, 0);
    }
}