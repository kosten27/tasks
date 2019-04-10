package task1;

import task1.entity.ChessBoard;
import task1.exceptions.ValidationException;
import task1.service.ChessBoardService;
import task1.service.impl.ChessBoardServiceImpl;
import task1.validators.ValidationService;
import task1.validators.impl.ValidationServiceImpl;

public class App {
    public static void main(String[] args) {
        ValidationService validationService = new ValidationServiceImpl();

        try {
            validationService.validateParameters(args);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return;
        }

        ChessBoard chessBoard = new ChessBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        ChessBoardService chessBoardService = new ChessBoardServiceImpl();
        chessBoardService.printIntoConsole(chessBoard);
    }
}
