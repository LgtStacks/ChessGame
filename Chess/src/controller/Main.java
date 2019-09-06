package controller;

import chessboard.Board;
import java.awt.Point;

/**
 * Main method used for testing functionality.
 * @author Gobindroop Mann
 * @author Colby Tong
 * @version 0.1
 */

/*NOTES: Some Pieces (at least the rook) do not update their internal
 * myPosition properly after they move on the board. When getPosition is
 * called on the Rook, it doesn't print an updated location. This causes an
 * error without an override of move(Point theDestination) within the Rook class.
 * There are also bugs in attack which haven't been fully tested/explored.
 * We should fix these bugs first before testing these shortened versions
 * of the Clear Tests (below).
 */
//Shortened versions of Clear Tests:
        /*private boolean isStraightClear(final Point theCurrent, final Point theDestination){
            if (theCurrent.y == theDestination.y) { // Moving vertically
                for (int i = 1; i < Math.abs(theCurrent.x - theDestination.x); i++) {
                    if ((theCurrent.x > theDestination.x && !isFree(new Point(theCurrent.x - i, theCurrent.y)))
                            || (theCurrent.x < theDestination.x && !isFree(new Point(theCurrent.x + i, theCurrent.y)))) {
                        return false;
                    }
                }
            } else if (theCurrent.x == theDestination.x) { // Moving horizontally
                for (int i = 1; i < Math.abs(theCurrent.y - theDestination.y); i++) {
                    if ((theCurrent.y > theDestination.y && !isFree(new Point(theCurrent.x, theCurrent.y - i)))
                            || (theCurrent.y < theDestination.y && !isFree(new Point(theCurrent.x, theCurrent.y + i)))) {
                        return false;
                    }
                }
            }
            return true;
        }*/
        /*private boolean isDiagonalClear(final Point theCurrent, final Point theDestination){
            for (int i = 1; i < Math.abs(theDestination.x - theCurrent.x); i++) {
                if ((theCurrent.y < theDestination.y && !isFree(new Point(theCurrent.x + i, theCurrent.y + i)))
                        || (theCurrent.y > theDestination.y && !isFree(new Point(theCurrent.x + i, theCurrent.y - i)))
                        || (theCurrent.y < theDestination.y && !isFree(new Point(theCurrent.x - i, theCurrent.y + i)))
                        || theCurrent.y > theDestination.y && !isFree(new Point(theCurrent.x - i, theCurrent.y - i))) {
                    return false;
                }
            }
            return true;
        }*/

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
        testBoard.move(new Point(7, 0), new Point(5, 0));
        testBoard.printBoard();
        testBoard.move(new Point(5, 0), new Point(5, 3));
        testBoard.printBoard();
    }

}
