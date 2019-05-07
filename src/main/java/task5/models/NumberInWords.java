package task5.models;

public interface NumberInWords {
    String getNumberInWords(int number, int rank);
    String getQuantity(int partOfNumber, int rank);
    String getZeroInWords();
}
