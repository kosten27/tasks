package task8.services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciNumbersServiceTest {
    private FibonacciNumbersService fibonacciNumbersService;

    @Before
    public void setUp() throws Exception {
        fibonacciNumbersService = new FibonacciNumbersService();
    }

    @Test
    public void getFibonacciNumbersStartTest() {
        //GIVEN
        long firstNumber = 0;
        long lastNumber = 10000;
        String expectedFibonacciNumber = "0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765";

        //WHEN
        String fibonacciNumbers = fibonacciNumbersService.getFibonacciNumbers(firstNumber, lastNumber);

        //THEN
        assertEquals(expectedFibonacciNumber, fibonacciNumbers);
    }

    @Test
    public void getFibonacciNumbersMiddleTest() {
        //GIVEN
        long firstNumber = 100;
        long lastNumber = 1000;
        String expectedFibonacciNumber = "144,233,377,610,987";

        //WHEN
        String fibonacciNumbers = fibonacciNumbersService.getFibonacciNumbers(firstNumber, lastNumber);

        //THEN
        assertEquals(expectedFibonacciNumber, fibonacciNumbers);
    }
}