package task2.controllers;

import exceptions.ValidationException;
import application.Controller;
import task2.models.Envelope;
import task2.services.EnvelopeService;
import task2.validators.EnvelopeValidator;
import application.ConsoleHelper;

public class EnvelopeController implements Controller {
    private final ConsoleHelper consoleHelper;
    private final EnvelopeValidator envelopeValidator;
    private final EnvelopeService envelopeService;

    public EnvelopeController(ConsoleHelper consoleHelper, EnvelopeService envelopeService,
                              EnvelopeValidator envelopeValidator) {
        this.consoleHelper = consoleHelper;
        this.envelopeValidator = envelopeValidator;
        this.envelopeService = envelopeService;
    }

    public void run() {
        compareEnvelopes();
        consoleHelper.read("Press Enter to continue.");
    }

    @Override
    public String getName() {
        return "Envelope analysis";
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
