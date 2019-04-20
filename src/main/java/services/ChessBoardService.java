package services;

import models.ChessBoard;

public class ChessBoardService {

    public String getChessBoardPresentation(ChessBoard chessBoard) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chessBoard.getHeight(); i++) {
            for (int j = 0; j < chessBoard.getWidth(); j++) {
                if (((i - j) % 2) == 0) {
                    stringBuilder.append('*');
                } else {
                    stringBuilder.append(' ');
                }
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
