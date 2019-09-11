package pieces;

import java.awt.Point;

/**
 * The Queen in the game of chess.
 *
 * @author Gobindroop Mann
 * @version 0.1
 */
public class Queen extends AbstractPiece {
    /**
     * The index size of the board.
     */
    private static final int BOUNDSCHECK = 7;
    /**
     * The current location of the piece.
     */
    private Point myPosition;

    /**
     * The constructor for the Queen.
     *
     * @param thePosition The starting position of the queen.
     * @param theIsWhite  Whether or not the queen is white.
     */
    public Queen(final Point thePosition, final boolean theIsWhite) {
        super(thePosition, Piece.QUEEN, theIsWhite);
        myPosition = thePosition;
    }

    @Override
    public boolean isValid(final Point theDestination) {
        if (theDestination.x < 0 || theDestination.y < 0
                || theDestination.x > BOUNDSCHECK || theDestination.y > BOUNDSCHECK) { //OOB
            return false;
        }
        if ((theDestination.x == myPosition.x)
                || (theDestination.y == myPosition.y)
                || ((Math.abs(theDestination.x - myPosition.x)
                == Math.abs(theDestination.y - myPosition.y)))) { //Moving straight
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Q";
    }
    @Override
    public boolean canAttack(final Point theDestination) {
        return isValid(theDestination);
    }
    
    @Override
    public void move(final Point theDestination) {
        myPosition = theDestination;
    }

    @Override
    public boolean canAttack(final Point theDestination) {
        return isValid(theDestination);
    }

    @Override
    public void move(final Point theDestination) {
        myPosition = theDestination;
    }

}