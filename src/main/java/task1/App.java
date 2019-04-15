package task1;

import task1.controllers.ViewController;
import task1.controllers.impl.ConsoleControllerImpl;
import task1.services.ChessBoardService;
import task1.services.impl.ChessBoardServiceImpl;
import task1.validators.ValidationService;
import task1.validators.impl.ValidationServiceImpl;

public class App {
    public static void main(String[] args) {
        ValidationService validationService = new ValidationServiceImpl();
        ChessBoardService chessBoardService = new ChessBoardServiceImpl();
        ViewController viewController = new ConsoleControllerImpl(chessBoardService, validationService);
        viewController.showChessBoard(args);
    }
}
