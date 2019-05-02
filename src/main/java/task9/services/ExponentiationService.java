package task9.services;

import java.util.*;

public class ExponentiationService {
    public long raiseNumberToPow(long number, int exponent) {
        Map<Integer, Long> powerOfNumber = getPowerOfNumber(number, exponent);
        long remainderExponent = exponent;
        long pow = 1;
        for (Map.Entry<Integer, Long> entry:powerOfNumber.entrySet()) {
            if (remainderExponent == 0) {
                break;
            }
            if (remainderExponent >= entry.getKey()) {
                pow *= entry.getValue();
                remainderExponent -= entry.getKey();
            }
        }
        return pow;
    }

    private  Map<Integer, Long> getPowerOfNumber(long number, int exponent) {
        Map<Integer, Long> powerOfNumber = new TreeMap<>((i1, i2) -> Integer.compare(i2, i1));
        long value = number;
        powerOfNumber.put(1, value);
        for (int i = 2; i <= exponent; i *= 2) {
            value *= value;
            powerOfNumber.put(i, value);
        }
        return powerOfNumber;
    }
}
