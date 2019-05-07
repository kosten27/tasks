package task5.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberInWordsRuTest {
    private NumberInWordsRu numberInWordsRu;

    @Before
    public void setUp() throws Exception {
        numberInWordsRu = new NumberInWordsRu();
    }

    @Test
    public void getOneInWordsTest() {
        //GIVEN
        int number = 1;
        int rank = 0;
        String expectedNumberInWords = "один";

        //WHEN
        String numberInWords = numberInWordsRu.getNumberInWords(number, rank);

        //THEN
        assertEquals(expectedNumberInWords, numberInWords);
    }

    @Test
    public void getOneInFeminineInWordsTest() {
        //GIVEN
        int number = 1;
        int rank = 1;
        String expectedNumberInWords = "одна";

        //WHEN
        String numberInWords = numberInWordsRu.getNumberInWords(number, rank);

        //THEN
        assertEquals(expectedNumberInWords, numberInWords);
    }

    @Test
    public void getMaxNumberInWordsTest() {
        //GIVEN
        int number = 900;
        int rank = 0;
        String expectedNumberInWords = "девятьсот";

        //WHEN
        String numberInWords = numberInWordsRu.getNumberInWords(number, rank);

        //THEN
        assertEquals(expectedNumberInWords, numberInWords);
    }

    @Test
    public void getQuantityOneThousandTest() {
        //GIVEN
        int partOfNumber = 1;
        int rank = 1;
        String expectedQuantity = "тысяча";

        //WHEN
        String quantity = numberInWordsRu.getQuantity(partOfNumber, rank);

        //THEN
        assertEquals(expectedQuantity, quantity);
    }

    @Test
    public void getQuantityTwoThousandTest() {
        //GIVEN
        int partOfNumber = 2;
        int rank = 1;
        String expectedQuantity = "тысячи";

        //WHEN
        String quantity = numberInWordsRu.getQuantity(partOfNumber, rank);

        //THEN
        assertEquals(expectedQuantity, quantity);
    }

    @Test
    public void getQuantityFiveThousandTest() {
        //GIVEN
        int partOfNumber = 5;
        int rank = 1;
        String expectedQuantity = "тысяч";

        //WHEN
        String quantity = numberInWordsRu.getQuantity(partOfNumber, rank);

        //THEN
        assertEquals(expectedQuantity, quantity);
    }

    @Test
    public void getZeroInWordsTest() {
        //GIVEN
        String expectedZeroInWords = "ноль";

        //WHEN
        String zeroInWords = numberInWordsRu.getZeroInWords();

        //THEN
        assertEquals(expectedZeroInWords, zeroInWords);
    }
}