package views;

import controllers.ChessBoardController;

public class ChessBoardView {
    private final String[] args;
    private final ConsoleHelper consoleHelper;
    private final ChessBoardController chessBoardController;

    public ChessBoardView(String[] args, ConsoleHelper consoleHelper) {
        this.args = args;
        this.consoleHelper = consoleHelper;
        this.chessBoardController = new ChessBoardController();
    }

    public void show() {
        consoleHelper.write(chessBoardController.getChessBoardPresentation(args));
    }
}
