package pieces;

import java.awt.Point;

/**
 * The King piece in the game of chess.
 * @author Colby Tong
 * @author Gobindroop Mann
 * @version 0.1
 */
public class King extends AbstractPiece {
    /**
     * The index size of the board.
     */
    private static final int BOUNDSCHECK = 7;
    /**
     * The current position of the King.
     */
    private Point myPosition;
    /***/
    private int myMoveCount;

    /**
     * The constructor for the King.
     *
     * @param thePosition The starting position for the king.
     * @param theIsWhite  Whether it is the black or white king.
     */
    public King(final Point thePosition, final boolean theIsWhite) {
        super(thePosition, Piece.KING, theIsWhite);
        myPosition = thePosition;
    }

    @Override
    public boolean isValid(final Point theDestination) {
        if (theDestination.x < 0 || theDestination.y < 0
                || theDestination.x > BOUNDSCHECK || theDestination.y > BOUNDSCHECK) { //OOB
            return false;
        } else if (Math.abs(myPosition.y - theDestination.y) == 2) {
            //Castling destination is two Y to either side
            if (myPosition.x != theDestination.x || myMoveCount != 0) {
                //Destination is on same row and King has not moved yet
                return false;
            }
        } else if (Math.abs(theDestination.x - myPosition.x) > 1
                || Math.abs(theDestination.y - myPosition.y) > 1) { //Can move one in X or Y
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean canAttack(final Point theDestination) {
        return isValid(theDestination);
    }

    @Override
    public void move(final Point theDestination) {
        myPosition = theDestination;
        myMoveCount++;
    }

}