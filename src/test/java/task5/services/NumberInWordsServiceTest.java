package task5.services;

import org.junit.Before;
import org.junit.Test;
import task5.models.NumberInWordsRu;

import static org.junit.Assert.*;

public class NumberInWordsServiceTest {
    private NumberInWordsService numberInWordsService;

    @Before
    public void setUp() throws Exception {
        numberInWordsService = new NumberInWordsService(new NumberInWordsRu());
    }

    @Test
    public void convertNumberInWordsZeroTest() {
        //GIVEN
        int number = 0;
        String expectedValue = "ноль";

        //WHEN
        String value = numberInWordsService.convertNumberInWords(number);

        //THEN
        assertEquals(expectedValue, value);
    }

    @Test
    public void convertNumberInWordsMaxNumberTest() {
        //GIVEN
        int number = 2_147_483_647;
        String expectedValue = "два миллиарда сто сорок семь миллионов " +
                "четыреста восемьдесят три тысячи шестьсот сорок семь";

        //WHEN
        String value = numberInWordsService.convertNumberInWords(number);

        //THEN
        assertEquals(expectedValue, value);
    }

    @Test
    public void convertNumberInWordsNumberWithThousandTest() {
        //GIVEN
        int number = 1_001_001_001;
        String expectedValue = "один миллиард один миллион одна тысяча один";

        //WHEN
        String value = numberInWordsService.convertNumberInWords(number);

        //THEN
        assertEquals(expectedValue, value);
    }
}