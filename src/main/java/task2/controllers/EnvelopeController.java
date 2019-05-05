package task2.controllers;

import exceptions.ValidationException;
import task2.models.Envelope;
import task2.services.EnvelopeService;
import task2.validators.EnvelopeValidator;
import views.ConsoleHelper;

public class EnvelopeController {
    private final ConsoleHelper consoleHelper;
    private final EnvelopeValidator envelopeValidator;
    private final EnvelopeService envelopeService;

    public EnvelopeController(ConsoleHelper consoleHelper) {
        this.consoleHelper = consoleHelper;
        this.envelopeValidator = new EnvelopeValidator();
        this.envelopeService = new EnvelopeService();
    }

    public void run() {
        compareEnvelopes();
        String read = consoleHelper.read("Press Enter to continue.");
    }

    private void compareEnvelopes() {
        Envelope firstEnvelope = readEnvelope();
        Envelope secondEnvelope = readEnvelope();
        consoleHelper.write(envelopeService.getResultOfEnvelopeComparison(firstEnvelope, secondEnvelope));
    }

    private Envelope readEnvelope() {
        Envelope envelope = null;
        consoleHelper.write("Envelope:");
        do {
            try {
                double height = consoleHelper.readDouble("Enter height:");
                double width = consoleHelper.readDouble("Enter width:");
                envelopeValidator.validateParameters(height, width);
                envelope = new Envelope(height, width);
            } catch (ValidationException e) {
                consoleHelper.write(e.getMessage());
            }
        } while (envelope == null);
        return envelope;
    }
}
