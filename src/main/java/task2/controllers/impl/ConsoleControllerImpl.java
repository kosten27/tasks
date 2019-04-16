package task2.controllers.impl;

import task2.controllers.ViewController;
import task2.exceptions.ValidationException;
import task2.models.Envelope;
import task2.services.EnvelopeService;
import task2.validators.ValidationService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConsoleControllerImpl implements ViewController {

    private static final int NUMBER_OF_ENVELOPES_TO_COMPARE = 2;
    private BufferedReader bufferedReader;
    private ValidationService validationService;
    private EnvelopeService envelopeService;

    public ConsoleControllerImpl(EnvelopeService envelopeService, ValidationService validationService) {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.validationService = validationService;
        this.envelopeService = envelopeService;
    }

    public void runEnvelopeComparison() {
        boolean isRunning = true;

        while (isRunning) {

            compareEnvelopes();

            System.out.println("Continue envelope comparison? (y/yes)");
            String line = "";
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            if ("y".equalsIgnoreCase(line) == false && "yes".equalsIgnoreCase(line) == false) {
                isRunning = false;
            }
        }
    }

    private void compareEnvelopes() {
        ArrayList<Envelope> envelopes = new ArrayList();
        for (int i = 0; i < NUMBER_OF_ENVELOPES_TO_COMPARE; i++) {
            envelopes.add(createEnvelope(i));
        }

        for (int i = 0; i < envelopes.size() - 1; i++) {
            for (int j = i + 1; j < envelopes.size(); j++) {
                int compare = envelopeService.compare(envelopes.get(i), envelopes.get(j));
                if (compare > 0) {
                    System.out.printf("Envelope #%d can be put in envelope #%d.\n", j, i);
                } else if (compare < 0) {
                    System.out.printf("Envelope #%d can be put in envelope #%d.\n", i, j);
                } else {
                    System.out.printf("Envelopes #%d and #%d cannot be nested.\n", i, j);
                }
            }
        }
    }

    private Envelope createEnvelope(int envelopeNumber) {
        System.out.println("Envelope #" + envelopeNumber + ":");
        double height = readDouble("Enter height:");
        double width = readDouble("Enter width:");

        return new Envelope(height, width);
    }

    private double readDouble(String s) {
        boolean isRunning = true;
        String line = "";
        while (isRunning) {
            System.out.println(s);
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                continue;
            }
            try {
                validationService.validateInputDouble(line);
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
                continue;
            }
            isRunning = false;
        }
        return Double.parseDouble(line);
    }
}
