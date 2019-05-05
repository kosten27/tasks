package task7.services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumericSequenceServicesTest {
    private NumericSequenceServices numericSequenceServices;

    @Before
    public void setUp() throws Exception {
        numericSequenceServices = new NumericSequenceServices();
    }

    @Test
    public void getNumberSequence() {
        //GIVEN
        int number = 100;
        String expectedNumberSequence = "1,2,3,4,5,6,7,8,9";

        //WHEN
        String numberSequence = numericSequenceServices.getNumberSequence(number);

        //THEN
        assertEquals(expectedNumberSequence, numberSequence);
    }
}