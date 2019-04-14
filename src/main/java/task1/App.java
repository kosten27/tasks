package task1;

import task1.controllers.ViewController;
import task1.controllers.impl.ConsoleControllerImpl;
import task1.model.ChessBoard;
import task1.exceptions.ValidationException;
import task1.services.ChessBoardService;
import task1.services.impl.ChessBoardServiceImpl;
import task1.validators.ValidationService;
import task1.validators.impl.ValidationServiceImpl;

public class App {
    public static void main(String[] args) {
        ValidationService validationService = new ValidationServiceImpl();
        ViewController viewController = new ConsoleControllerImpl();

        try {
            validationService.validateParameters(args);
        } catch (ValidationException e) {
            viewController.show(e.getMessage());
            return;
        }

        ChessBoard chessBoard = new ChessBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        ChessBoardService chessBoardService = new ChessBoardServiceImpl(viewController);
        chessBoardService.show(chessBoard);
    }
}
