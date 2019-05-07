package task5.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import task5.models.NumberInWords;
import task5.models.NumberInWordsRu;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NumberInWordsServiceTest {
    private NumberInWords numberInWords;
    private NumberInWordsService numberInWordsService;

    @Before
    public void setUp() throws Exception {
        numberInWords = mock(NumberInWords.class);
        numberInWordsService = new NumberInWordsService(numberInWords);
    }

    @Test
    public void convertNumberInWordsZeroTest() {
        //GIVEN
        int number = 0;
        String expectedValue = "ноль";
        when(numberInWords.getZeroInWords()).thenReturn(expectedValue);

        //WHEN
        String value = numberInWordsService.convertNumberInWords(number);

        //THEN
        assertEquals(expectedValue, value);
    }

    @Test
    public void convertNumberInWordsMaxNumberTest() {
        //GIVEN
        when(numberInWords.getNumberInWords(2, 3)).thenReturn("два");
        when(numberInWords.getQuantity(2, 3)).thenReturn("миллиарда");
        when(numberInWords.getNumberInWords(100, 2)).thenReturn("сто");
        when(numberInWords.getNumberInWords(40, 2)).thenReturn("сорок");
        when(numberInWords.getNumberInWords(7, 2)).thenReturn("семь");
        when(numberInWords.getQuantity(147, 2)).thenReturn("миллионов");
        when(numberInWords.getNumberInWords(400, 1)).thenReturn("четыреста");
        when(numberInWords.getNumberInWords(80, 1)).thenReturn("восемьдесят");
        when(numberInWords.getNumberInWords(3, 1)).thenReturn("три");
        when(numberInWords.getQuantity(483, 1)).thenReturn("тысячи");
        when(numberInWords.getNumberInWords(600, 0)).thenReturn("шестьсот");
        when(numberInWords.getNumberInWords(40, 0)).thenReturn("сорок");
        when(numberInWords.getNumberInWords(7, 0)).thenReturn("семь");
        when(numberInWords.getQuantity(anyInt(), eq(0))).thenReturn("");
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
        when(numberInWords.getNumberInWords(1, 3)).thenReturn("один");
        when(numberInWords.getQuantity(1, 3)).thenReturn("миллиард");
        when(numberInWords.getNumberInWords(1, 2)).thenReturn("один");
        when(numberInWords.getQuantity(1, 2)).thenReturn("миллион");
        when(numberInWords.getNumberInWords(1, 1)).thenReturn("одна");
        when(numberInWords.getQuantity(1, 1)).thenReturn("тысяча");
        when(numberInWords.getNumberInWords(1, 0)).thenReturn("один");
        when(numberInWords.getQuantity(anyInt(), eq(0))).thenReturn("");
        int number = 1_001_001_001;
        String expectedValue = "один миллиард один миллион одна тысяча один";

        //WHEN
        String value = numberInWordsService.convertNumberInWords(number);

        //THEN
        assertEquals(expectedValue, value);
    }
}