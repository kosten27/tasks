package task5.services;

import task5.models.NumberInWords;

public class NumberInWordsService {
    private NumberInWords numberInWords;

    public NumberInWordsService(NumberInWords numberInWords) {
        this.numberInWords = numberInWords;
    }

    public String convertNumberInWords(int number) {
        if (number == 0) {
            return numberInWords.getZeroInWords();
        }
        StringBuilder result = new StringBuilder();
        int tempNumber = number;
        int rank = 0;
        while (tempNumber > 0) {
            StringBuilder tempResult = new StringBuilder();
            int partOfNumber = tempNumber % 1000;
            int hundreds = partOfNumber - partOfNumber % 100;
            int tens = (partOfNumber % 100) / 10 * 10;
            int units = partOfNumber % 10;
            appendNumberInWords(tempResult, hundreds, rank);
            if (tens == 10) {
                appendNumberInWords(tempResult, tens + units, rank);
            } else {
                appendNumberInWords(tempResult, tens, rank);
                appendNumberInWords(tempResult, units, rank);
            }
            appendQuantity(tempResult, partOfNumber, rank);
            tempNumber /= 1000;
            if (result.length() > 0 && tempResult.length() > 0) {
                tempResult.append(' ');
            }
            result.insert(0, tempResult);
            rank++;
        }
        return result.toString();
    }

    private void appendQuantity(StringBuilder string, int partOfNumber, int rank) {
        String quality = numberInWords.getQuality(partOfNumber, rank);
        if (!"".equals(quality)) {
            if (string.length() > 0) {
                string.append(' ');
            }
            string.append(quality);
        }
    }

    private void appendNumberInWords(StringBuilder string, int number, int rank) {
        if (number > 0) {
            if (string.length() > 0) {
                string.append(' ');
            }
            string.append(numberInWords.getNumberInWords(number, rank));
        }
    }
}
