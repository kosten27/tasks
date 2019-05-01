package task5.models;

import java.util.HashMap;
import java.util.Map;

public class NumberInWordsRu implements NumberInWords {
    private final Map<Integer, String> numbersInWords = new HashMap<>();
    private final Map<Integer, String> numbersInWordsInFeminine = new HashMap<>();
    private final Map<Integer, Quantity> quantities = new HashMap<>();

    public NumberInWordsRu() {
        numbersInWords.put(1, "один");
        numbersInWords.put(2, "два");
        numbersInWords.put(3, "три");
        numbersInWords.put(4, "четыре");
        numbersInWords.put(5, "пять");
        numbersInWords.put(6, "шесть");
        numbersInWords.put(7, "семь");
        numbersInWords.put(8, "восемь");
        numbersInWords.put(9, "девять");
        numbersInWords.put(10, "десять");
        numbersInWords.put(11, "одиннадцать");
        numbersInWords.put(12, "двенадцать");
        numbersInWords.put(13, "тринадцать");
        numbersInWords.put(14, "четырнадцать");
        numbersInWords.put(15, "пятнадцать");
        numbersInWords.put(16, "шестнадцать");
        numbersInWords.put(17, "семнадцать");
        numbersInWords.put(18, "восемнадцать");
        numbersInWords.put(19, "девятнадцать");
        numbersInWords.put(20, "двадцать");
        numbersInWords.put(30, "тридцать");
        numbersInWords.put(40, "сорок");
        numbersInWords.put(50, "пятьдесят");
        numbersInWords.put(60, "шестьдесят");
        numbersInWords.put(70, "семьдесят");
        numbersInWords.put(80, "восемьдесят");
        numbersInWords.put(90, "девяносто");
        numbersInWords.put(100, "сто");
        numbersInWords.put(200, "двести");
        numbersInWords.put(300, "триста");
        numbersInWords.put(400, "четыреста");
        numbersInWords.put(500, "пятьсот");
        numbersInWords.put(600, "шестьсот");
        numbersInWords.put(700, "семьсот");
        numbersInWords.put(800, "восемьсот");
        numbersInWords.put(900, "девятьсот");

        numbersInWordsInFeminine.put(1, "одна");
        numbersInWordsInFeminine.put(2, "две");

        quantities.put(0, new Quantity("", "", "", Genus.MALE));
        quantities.put(1, new Quantity("тысяча", "тысячи", "тысяч", Genus.FEMALE));
        quantities.put(2, new Quantity("миллион", "миллиона", "миллионов",
                Genus.MALE));
        quantities.put(3, new Quantity("миллиард", "миллиарда", "миллиардов",
                Genus.MALE));
    }

    @Override
    public String getNumberInWords(int number, Genus genus) {
        if (genus == Genus.FEMALE && numbersInWordsInFeminine.containsKey(number)) {
            return numbersInWordsInFeminine.get(number);
        } else {
            return numbersInWords.get(number);
        }
    }

    @Override
    public Quantity getQuality(int rank) {
        return quantities.get(rank);
    }
}
