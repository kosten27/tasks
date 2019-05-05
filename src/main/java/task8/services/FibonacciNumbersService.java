package task8.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FibonacciNumbersService {

    public String getFibonacciNumbers(long firstNumber, long lastNumber) {
        List<String> fibonacciNumbers = new ArrayList<>();
        long firstFibonacciNumber = 0L;
        long secondFibonacciNumber = 1L;
        long fibonacciNumber = firstFibonacciNumber;
        while (fibonacciNumber <= lastNumber) {
            if (fibonacciNumber >= firstNumber) {
                fibonacciNumbers.add(String.valueOf(fibonacciNumber));
            }
            if (fibonacciNumber == firstFibonacciNumber && fibonacciNumber != secondFibonacciNumber) {
                fibonacciNumber = secondFibonacciNumber;
            } else {
                fibonacciNumber = firstFibonacciNumber + secondFibonacciNumber;
                firstFibonacciNumber = secondFibonacciNumber;
                secondFibonacciNumber = fibonacciNumber;
            }
        }
        return fibonacciNumbers.stream()
                .collect(Collectors.joining(","));
    }
}
