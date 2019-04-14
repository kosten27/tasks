package task2.controllers.impl;

import task2.controllers.ViewController;
import task2.exceptions.ValidationException;
import task2.model.Envelope;
import task2.services.CompareEnvelope;
import task2.validators.ValidationService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleControllerImpl implements ViewController {

    private BufferedReader bufferedReader;
    private ValidationService validationService;

    public ConsoleControllerImpl(ValidationService validationService) {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.validationService = validationService;
    }

    public void runEnvelopeComparison() {
        Envelope firstEnvelope;
        Envelope secondEnvelope;
        boolean isRunning = true;

        while (isRunning){
            firstEnvelope = createEnvelope();
            secondEnvelope = createEnvelope();

            CompareEnvelope compareEnvelope = new CompareEnvelope();
            int compare = compareEnvelope.compare(firstEnvelope, secondEnvelope);
            if (compare > 0) {
                System.out.println("The second envelope can be put in the first envelope.");
            } else if (compare < 0) {
                System.out.println("The first envelope can be put in the second envelope.");
            } else {
                System.out.println("Envelopes cannot be nested.");
            }

            System.out.println("Continue envelope comparison? (y/yes)");
            String line = "";
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            if ("y".equalsIgnoreCase(line) == false & "yes".equalsIgnoreCase(line) == false) {
                isRunning = false;
            }
        }
    }

    private Envelope createEnvelope() {
        double height;
        double width;

        height = readDouble("Enter envelope height:");
        width = readDouble("Enter envelope width:");

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
