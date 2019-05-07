package task1.controllers;

import exceptions.ValidationException;
import application.Controller;
import task1.models.ChessBoard;
import task1.services.ChessBoardService;
import task1.validators.ChessBoardValidator;
import application.ConsoleHelper;

public class ChessBoardController implements Controller {
    private final ConsoleHelper consoleHelper;
    private final ChessBoardValidator chessBoardValidator;
    private final ChessBoardService chessBoardService;

    public ChessBoardController(ConsoleHelper consoleHelper, ChessBoardService chessBoardService,
                                ChessBoardValidator chessBoardValidator) {
        this.consoleHelper = consoleHelper;
        this.chessBoardService = chessBoardService;
        this.chessBoardValidator = chessBoardValidator;
    }

    public void run() {
        displayChessBoard();
        consoleHelper.read("Press Enter to continue.");
    }

    @Override
    public String getName() {
        return "Chess board";
    }

    private void displayChessBoard() {
        try {
            String stringHeight = consoleHelper.read("Enter height");
            int height = Integer.parseInt(stringHeight);
            String stringWidth = consoleHelper.read("Enter width");
            int width = Integer.parseInt(stringWidth);
            chessBoardValidator.validateParameters(height, width);
            ChessBoard chessBoard = new ChessBoard(height, width);
            consoleHelper.write(chessBoardService.getChessBoardPresentation(chessBoard));
        } catch (NumberFormatException e) {
            consoleHelper.write("Number format error");
        } catch (ValidationException e) {
            consoleHelper.write(e.getMessage());
        }
    }
}
