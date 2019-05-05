package task6.services;

import java.util.stream.IntStream;

public class HappyTicketsServices {

    public long countNumberOfLuckyTickets(String algorithm) {
        if ("Moskow".equals(algorithm)) {
            return countNumberOfLuckyTicketsMoskow();
        } else if ("Piter".equals(algorithm)) {
            return countNumberOfLuckyTicketsPiter();
        } else {
            return 0;
        }
    }

    private long countNumberOfLuckyTicketsMoskow() {
        return IntStream.rangeClosed(1001, 999999)
                .filter(x -> countSumOfNumber(x / 1000) == countSumOfNumber(x % 1000))
                .count();
    }

    private int countSumOfNumber(int number) {
        int temp = number;
        int count = 0;
        while (temp > 0) {
            count += temp % 10;
            temp /= 10;
        }
        return count;
    }

    private int countSumOfNumber(int number, boolean even) {
        int tempNumber = number;
        int count = 0;
        while (tempNumber > 0) {
            int temp = tempNumber % 10;
            if ((even && temp % 2 == 0)
                || (!even && temp % 2 == 1)) {
                count += temp % 10;
            }
            tempNumber /= 10;
        }
        return count;
    }

    private long countNumberOfLuckyTicketsPiter() {
        return IntStream.rangeClosed(112, 999999)
                .filter(x -> countSumOfNumber(x, true) == countSumOfNumber(x, false))
                .count();
    }
}
