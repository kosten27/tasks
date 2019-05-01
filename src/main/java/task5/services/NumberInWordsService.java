package task5.services;

import task5.models.NumberInWords;
import task5.models.Quantity;

public class NumberInWordsService {
    private NumberInWords numberInWords;

    public NumberInWordsService(NumberInWords numberInWords) {
        this.numberInWords = numberInWords;
    }

    public String convertNumberInWords(int number) {
        StringBuilder result = new StringBuilder();
        int tempNumber = number;
        int rank = 0;
        while (tempNumber > 0) {
            StringBuilder tempResult = new StringBuilder();
            Quantity quality = numberInWords.getQuality(rank++);
            int partOfNumber = tempNumber % 1000;
            int hundreds = partOfNumber - partOfNumber % 100;
            int tens = (partOfNumber % 100) / 10 * 10;
            int units = partOfNumber % 10;
            appendNumberInWords(tempResult, hundreds, quality);
            if (tens == 10) {
                appendNumberInWords(tempResult, tens + units, quality);
            } else {
                appendNumberInWords(tempResult, tens, quality);
                appendNumberInWords(tempResult, units, quality);
            }
            appendQuantity(tempResult, partOfNumber, quality);
            tempNumber /= 1000;
            if (result.length() > 0) {
                tempResult.append(' ');
            }
            result.insert(0, tempResult);
        }
        return result.toString();
    }

    private void appendQuantity(StringBuilder string, int partOfNumber, Quantity quantity) {
        if (quantity != null && partOfNumber > 0) {
            if (string.length() > 0) {
                string.append(' ');
            }
            int remainderHundred = partOfNumber % 100;
            int remainderTen = partOfNumber % 10;
            int tens = remainderHundred - remainderTen;
            if (remainderTen == 1 && tens != 10) {
                string.append(quantity.getName());
            } else if (remainderTen >= 2 && remainderTen <= 4 && tens != 10) {
                string.append(quantity.getNameGenitive());
            } else {
                string.append(quantity.getNameGenitivePlural());
            }
        }
    }

    private void appendNumberInWords(StringBuilder string, int number, Quantity quantity) {
        if (number > 0) {
            if (string.length() > 0) {
                string.append(' ');
            }
            string.append(numberInWords.getNumberInWords(number, quantity.getGenus()));
        }
    }
}
