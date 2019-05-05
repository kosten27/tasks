package task1.services;

import org.junit.Before;
import org.junit.Test;
import task1.models.ChessBoard;

import static org.junit.Assert.*;

public class ChessBoardServiceTest {

    private ChessBoardService chessBoardService;

    @Before
    public void setUp() {
        chessBoardService = new ChessBoardService();
    }

    @Test
    public void getChessBoardPresentationTest() {
        //GIVEN
        String expectedChessBoardPresentation =
                "■□■□\n" +
                "□■□■\n" +
                "■□■□";
        ChessBoard chessBoard = new ChessBoard(3, 4);

        //WHEN
        String chessBoardPresentation = chessBoardService.getChessBoardPresentation(chessBoard);

        //THEN
        assertEquals(expectedChessBoardPresentation, chessBoardPresentation);
    }
}