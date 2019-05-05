package task5.models;

public class NumberInWordsRu implements NumberInWords {
    private final String zero;
    private final String[][] units;
    private final String[] tens1;
    private final String[] tens2;
    private final String[] hundreds;
    private final String[][] quantities;

    public NumberInWordsRu() {
        zero = "ноль";
        units = new String[][]{
                {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
                {"", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"}};

        tens1 = new String[]{"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
                "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};

        tens2 = new String[]{"", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят",
                "восемьдесят", "девяносто"};

        hundreds = new String[]{"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот",
                "восемьсот", "девятьсот"};

        quantities = new String[][]{
                {"", "", "", "0"},
                {"тысяча", "тысячи", "тысяч", "1"},
                {"миллион", "миллиона", "миллионов", "0"},
                {"миллиард", "миллиарда", "миллиардов", "0"},
        };
    }

    @Override
    public String getNumberInWords(int number, int rank) {
        if (number >= 100) {
            return hundreds[number / 100];
        } else if (number >= 20) {
            return tens2[number / 10];
        } else if (number >= 10) {
            return tens1[number - 10];
        } else {
            int row = Integer.parseInt(quantities[rank][3]);
            return units[row][number];
        }
    }

    @Override
    public String getQuality(int partOfNumber, int rank) {
        if (rank > 0 && partOfNumber > 0) {
            int remainderHundred = partOfNumber % 100;
            int remainderTen = partOfNumber % 10;
            int tens = remainderHundred - remainderTen;
            if (remainderTen == 1 && tens != 10) {
                return quantities[rank][0];
            } else if (remainderTen >= 2 && remainderTen <= 4 && tens != 10) {
                return quantities[rank][1];
            } else {
                return quantities[rank][2];
            }
        }
        return "";
    }

    @Override
    public String getZeroInWords() {
        return zero;
    }
}
