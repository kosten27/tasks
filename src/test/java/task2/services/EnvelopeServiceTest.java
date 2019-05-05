package task2.services;

import org.junit.Before;
import org.junit.Test;
import task2.models.Envelope;

import static org.junit.Assert.*;

public class EnvelopeServiceTest {

    private EnvelopeService envelopeService;

    @Before
    public void setUp() {
        envelopeService = new EnvelopeService();
    }

    @Test
    public void compareFirstEnvelopeCanBePutInSecondTest() {
        //GIVEN
        Envelope firstEnvelope = new Envelope(2, 3);
        Envelope secondEnvelope = new Envelope(3, 4);

        //WHEN
        int resultOfComparison = envelopeService.compare(firstEnvelope, secondEnvelope);

        //THEN
        assertTrue(resultOfComparison < 0);
    }

    @Test
    public void compareSecondEnvelopeCanBePutInFirstTest() {
        //GIVEN
        Envelope firstEnvelope = new Envelope(3, 4);
        Envelope secondEnvelope = new Envelope(2, 3);

        //WHEN
        int resultOfComparison = envelopeService.compare(firstEnvelope, secondEnvelope);

        //THEN
        assertTrue(resultOfComparison > 0);
    }

    @Test
    public void compareEnvelopesCannotBeNestedTest() {
        //GIVEN
        Envelope firstEnvelope = new Envelope(3, 4);
        Envelope secondEnvelope = new Envelope(2, 5);

        //WHEN
        int resultOfComparison = envelopeService.compare(firstEnvelope, secondEnvelope);

        //THEN
        assertTrue(resultOfComparison == 0);
    }
}