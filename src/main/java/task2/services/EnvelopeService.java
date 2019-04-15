package task2.services;

import task2.models.Envelope;

import java.util.Comparator;

public class EnvelopeService implements Comparator<Envelope> {
    public int compare(Envelope o1, Envelope o2) {
        if (Math.min(o1.getHeight(), o1.getWidth()) > Math.min(o2.getHeight(), o2.getWidth())
                && Math.max(o1.getHeight(), o1.getWidth()) > Math.max(o2.getHeight(), o2.getWidth())) {
            return 1;
        } else if (Math.min(o1.getHeight(), o1.getWidth()) < Math.min(o2.getHeight(), o2.getWidth())
                && Math.max(o1.getHeight(), o1.getWidth()) < Math.max(o2.getHeight(), o2.getWidth())) {
            return -1;
        } else {
            return 0;
        }
    }
}
