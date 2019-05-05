package task9.services;

public class ExponentiationService {

    public double raiseNumberToPow(double number, long exponent) {
        if (exponent == 0L) {
            return 1.0;
        } else if (exponent % 2 == 1) {
            return raiseNumberToPow(number, --exponent) * number;
        } else {
            return raiseNumberToPow(number * number, exponent / 2);
        }
    }
}

