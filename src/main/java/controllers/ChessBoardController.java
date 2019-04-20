package controllers;

import exceptions.ValidationException;
import models.ChessBoard;
import services.ChessBoardService;
import validators.ChessBoardValidator;

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
