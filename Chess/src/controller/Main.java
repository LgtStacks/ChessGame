package controller;

import chessboard.Board;
import java.awt.Point;

/**
 * Main method used for testing functionality.
 * @author Colby Tong
 * @author Gobindroop Mann
 * @version 0.1
 */
public final class Main {
    /**
     * Private constructor, to prevent instantiation of this class.
     */
    private Main() {
        throw new IllegalStateException();
    }
    /**
     * The main method to test if functions of the board are working correctly.
     * @param theArgs Command Line arguments
     */
    public static void main(final String[] theArgs) {
        final Board testBoard = new Board();
        testBoard.printBoard();
        testBoard.move(new Point(6, 0), new Point(4, 0));
        testBoard.printBoard();
        testBoard.move(new Point(6, 1), new Point(4, 1));
        testBoard.printBoard();
        testBoard.move(new Point(6, 2), new Point(4, 2));
        testBoard.printBoard();
        testBoard.move(new Point(6, 3), new Point(4, 3));
        testBoard.printBoard();
        testBoard.move(new Point(7, 1), new Point(5, 0));
        testBoard.printBoard();
        testBoard.move(new Point(7, 2), new Point(6, 3));
        testBoard.printBoard();
        //Black king has already moved (disables castling)
        /*testBoard.move(new Point(7, 3), new Point(6, 2));
        testBoard.printBoard();
        testBoard.move(new Point(6, 2), new Point(7, 3));
        testBoard.printBoard();*/
        testBoard.move(new Point(7, 3), new Point(7, 1));
        testBoard.printBoard();


        testBoard.move(new Point(1, 0), new Point(3, 0));
        testBoard.printBoard();
        testBoard.move(new Point(1, 1), new Point(3, 1));
        testBoard.printBoard();
        testBoard.move(new Point(1, 2), new Point(3, 2));
        testBoard.printBoard();
        testBoard.move(new Point(1, 3), new Point(3, 3));
        testBoard.printBoard();
        testBoard.move(new Point(0, 1), new Point(2, 2));
        testBoard.printBoard();
        testBoard.move(new Point(0, 2), new Point(2, 0));
        testBoard.printBoard();
        //White rook has already moved (disables castling)
        /*testBoard.move(new Point(0, 0), new Point(1, 0));
        testBoard.printBoard();
        testBoard.move(new Point(1, 0), new Point(0, 0));
        testBoard.printBoard();*/
        testBoard.move(new Point(0, 3), new Point(0, 1));
        testBoard.printBoard();
    }

}