package task2.controllers;

import exceptions.ValidationException;
import task2.models.Envelope;
import task2.services.EnvelopeService;
import task2.validators.EnvelopeValidator;

import java.util.ArrayList;

public class EnvelopeController {
    private final EnvelopeService envelopeService;
    private final EnvelopeValidator envelopeValidator;

    public EnvelopeController() {
        envelopeService = new EnvelopeService();
        envelopeValidator = new EnvelopeValidator();
    }

    public ArrayList<String> getResultOfEnvelopeComparison(double[][] envelopesParameters) {
        Envelope[] envelops = new Envelope[envelopesParameters.length];
        for (int i = 0; i < envelopesParameters.length; i++) {
            try {
                envelopeValidator.validateInputDouble(envelopesParameters[i][0]);
                envelopeValidator.validateInputDouble(envelopesParameters[i][1]);
            } catch (ValidationException e) {
                ArrayList<String> result = new ArrayList<>();
                result.add(e.getMessage());
                return result;
            }
            envelops[i] = new Envelope(envelopesParameters[i][0], envelopesParameters[i][1]);
        }
        return envelopeService.getResultOfEnvelopeComparison(envelops);
    }
}
