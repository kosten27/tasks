package task1.services.impl;

import task1.controllers.ViewController;
import task1.model.ChessBoard;
import task1.services.ChessBoardService;

public class ChessBoardServiceImpl implements ChessBoardService {
    ViewController viewController;

    public ChessBoardServiceImpl(ViewController viewController) {
        this.viewController = viewController;
    }

    public void show(ChessBoard chessBoard) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chessBoard.getHeight(); i++) {
            for (int j = 0; j < chessBoard.getWidth(); j++) {
                if (((i - j) % 2) == 0) {
                    stringBuilder.append("*");
                } else {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append("\n");
        }
        viewController.show(stringBuilder.toString());
    }
}
