package services;

import models.Envelope;

import java.util.ArrayList;
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

    public ArrayList<String> getResultOfEnvelopeComparison(Envelope[] envelopes) {
        ArrayList<String> resultOfComparison = new ArrayList<>();
        for (int i = 0; i < envelopes.length - 1; i++) {
            for (int j = i + 1; j < envelopes.length; j++) {
                int compare = compare(envelopes[i], envelopes[j]);
                if (compare > 0) {
                    resultOfComparison.add(envelopes[j] + " can be put in " + envelopes[i]);
                } else if (compare < 0) {
                    resultOfComparison.add(envelopes[i] + " can be put in " + envelopes[j]);
                } else {
                    resultOfComparison.add(envelopes[i] + " and " + envelopes[j] + " cannot be nested");
                }
            }
        }
        return resultOfComparison;
    }
}
