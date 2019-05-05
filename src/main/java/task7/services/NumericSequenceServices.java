package task7.services;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericSequenceServices {

    public String getNumberSequence(int number) {
        return IntStream.rangeClosed(1, (int) Math.sqrt(number))
                .filter(n -> n * n < number)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));
    }
}
