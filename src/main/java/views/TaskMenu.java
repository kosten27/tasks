package views;

public class TaskMenu {

    private final String[] args;
    private final ConsoleHelper consoleHelper;

    public TaskMenu(String[] args) {
        this.args = args;
        this.consoleHelper = new ConsoleHelper();
    }

    public void show() {
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            switch (consoleHelper.read()) {
                case "1":
                    ChessBoardView chessBoardView = new ChessBoardView(args, consoleHelper);
                    chessBoardView.show();
                    break;
                case "2":
                    EnvelopeView envelopeView = new EnvelopeView(consoleHelper);
                    envelopeView.show();
                    break;
                case "E":
                    isRunning = false;
                    break;
                default:
                    consoleHelper.write("Wrong input!");
                    break;
            }
        }
    }

    private void showMenu() {
        consoleHelper.write("1. Chess board");
        consoleHelper.write("2. Envelope analysis");
        consoleHelper.write("E. Exit");
    }
}
