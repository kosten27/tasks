package task1.controllers;

import exceptions.ValidationException;
import task1.models.ChessBoard;
import task1.services.ChessBoardService;
import task1.validators.ChessBoardValidator;

public class ChessBoardController {
    private final ChessBoardService chessBoardService;
    private final ChessBoardValidator validationService;

    public ChessBoardController() {
        chessBoardService = new ChessBoardService();
        validationService = new ChessBoardValidator();
    }

    public String getChessBoardPresentation(String[] args) {
        try {
            validationService.validateParameters(args);
        } catch (ValidationException e) {
            return e.getMessage();
        }
        ChessBoard chessBoard = new ChessBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        return chessBoardService.getChessBoardPresentation(chessBoard);
    }
}
