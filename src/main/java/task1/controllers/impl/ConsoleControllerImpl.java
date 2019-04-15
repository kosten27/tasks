package task1.controllers.impl;

import task1.controllers.ViewController;
import task1.exceptions.ValidationException;
import task1.models.ChessBoard;
import task1.services.ChessBoardService;
import task1.validators.ValidationService;

public class ConsoleControllerImpl implements ViewController {

    ChessBoardService chessBoardService;
    ValidationService validationService;

    public ConsoleControllerImpl(ChessBoardService chessBoardService, ValidationService validationService) {
        this.chessBoardService = chessBoardService;
        this.validationService = validationService;
    }

    public void show(String s) {
        System.out.println(s);
    }

    public void showChessBoard(String[] args) {

        try {
            validationService.validateParameters(args);
        } catch (ValidationException e) {
            show(e.getMessage());
            return;
        }

        ChessBoard chessBoard = new ChessBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        show(chessBoardService.getChessBoardPresentation(chessBoard));
    }
}
