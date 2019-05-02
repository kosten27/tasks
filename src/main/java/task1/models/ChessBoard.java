package task1.models;

public class ChessBoard {
    private final int height;
    private final int width;

    public ChessBoard(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
