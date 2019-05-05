package task2.services;

import task2.models.Envelope;

import java.util.Comparator;

public class EnvelopeService implements Comparator<Envelope> {

    public int compare(Envelope o1, Envelope o2) {
        if (firstEnvelopeFitsInTheSecond(o1, o2)) {
            return 1;
        } else if (firstEnvelopeFitsInTheSecond(o2, o1)) {
            return -1;
        } else {
            return 0;
        }
    }

    private boolean firstEnvelopeFitsInTheSecond(Envelope o1, Envelope o2) {
        return Math.min(o1.getHeight(), o1.getWidth()) > Math.min(o2.getHeight(), o2.getWidth())
                && Math.max(o1.getHeight(), o1.getWidth()) > Math.max(o2.getHeight(), o2.getWidth());
    }

    public String getResultOfEnvelopeComparison(Envelope firstEnvelope, Envelope secondEnvelope) {
        int compare = compare(firstEnvelope, secondEnvelope);
        if (compare > 0) {
            return secondEnvelope + " can be put in " + firstEnvelope;
        } else if (compare < 0) {
            return firstEnvelope + " can be put in " + secondEnvelope;
        } else {
            return firstEnvelope + " and " + secondEnvelope + " cannot be nested";
        }
    }
}
