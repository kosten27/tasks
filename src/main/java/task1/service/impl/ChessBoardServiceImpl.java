package task1.service.impl;

import task1.entity.ChessBoard;
import task1.service.ChessBoardService;

public class ChessBoardServiceImpl implements ChessBoardService {
    public void printIntoConsole(ChessBoard chessBoard) {
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
        System.out.println(stringBuilder);
    }
}
