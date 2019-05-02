package task8.services;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class FibonacciNumbersService {
    public String getFibonacciNumbers(long firstNumber, long lastNumber) {
        int maxSequenceNumber = 93;
        return LongStream.range(0, maxSequenceNumber)
                .map(this::getFibonacciNumberByN)
                .filter(i -> i >= firstNumber && i <= lastNumber)
                .mapToObj(Long::toString)
                .collect(Collectors.joining(","));
    }

    private long getFibonacciNumberByN(long n) {
        double sqrt5 = Math.sqrt(5);
        double result = (Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n)) / sqrt5;
        return (long) result;
    }
}
