package views;

import controllers.EnvelopeController;

import java.util.ArrayList;

public class EnvelopeView {
    private final ConsoleHelper consoleHelper;
    private final EnvelopeController envelopeController;
    private final int NUMBER_OF_ENVELOPES_TO_COMPARE = 2;

    public EnvelopeView(ConsoleHelper consoleHelper) {
        this.consoleHelper = consoleHelper;
        this.envelopeController = new EnvelopeController();
    }

    public void show() {
        boolean isRunning = true;
        while (isRunning){
            showMenu();
            switch (consoleHelper.read()) {
                case "1":
                    compareEnvelopes();
                    break;
                case "R":
                    isRunning = false;
                    break;
                default:
                    consoleHelper.write("Wrong input!");
                    break;
            }
        }
    }

    private void showMenu() {
        consoleHelper.write("1. Compare envelopes");
        consoleHelper.write("R. Return");
    }

    private void compareEnvelopes() {
        int numberOfEnvelopeParameters = 2;
        double[][] envelopesParameters = new double[NUMBER_OF_ENVELOPES_TO_COMPARE][numberOfEnvelopeParameters];
        for (int i = 0; i < envelopesParameters.length; i++) {
            readEnvelopeParameters(i + 1, envelopesParameters[i]);
        }
        ArrayList<String> resultOfComparison = envelopeController.getResultOfEnvelopeComparison(envelopesParameters);
        for (int i = 0; i < resultOfComparison.size(); i++) {
            consoleHelper.write(resultOfComparison.get(i));
        }
    }

    private void readEnvelopeParameters(int envelopeNumber, double[] envelopParameter) {
        consoleHelper.write("Envelope #" + envelopeNumber);
        envelopParameter[0] = consoleHelper.readDouble("Enter height:");
        envelopParameter[1] = consoleHelper.readDouble("Enter width:");
    }
}
