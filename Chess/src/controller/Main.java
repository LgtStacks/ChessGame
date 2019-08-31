package controller;

import chessboard.Board;
import java.awt.Point;

/**
 * Main method used for testing functionality.
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
        testBoard.move(new Point(0, 0), new Point(0, 2));
        System.out.println();
        System.out.println();
        System.out.println();
        testBoard.printBoard();

    }

}
