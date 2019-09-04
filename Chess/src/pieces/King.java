package pieces;

import java.awt.Point;
/**
 * The King piece in the game of chess.
 * @author Gobindroop Mann
 * @version 0.1
 */
public class King extends AbstractPiece {
    /**The index size of the board.*/
    private static final int BOUNDSCHECK = 7;
    /**The current position of the King.*/
    private Point myPosition;
    /**
     * The constructor for the King.
     * @param thePosition The starting position for the king.
     * @param theIsWhite Whether it is the black or white king.
     */
    public King(final Point thePosition, final boolean theIsWhite) {
        super(thePosition, Piece.KING , theIsWhite);
        myPosition = thePosition;
    }

    @Override
    public boolean isValid(final Point theDestination) {
        if (theDestination.x < 0 || theDestination.y < 0
            || theDestination.x > BOUNDSCHECK || theDestination.y > BOUNDSCHECK) { //OOB
            return false;
        }
        if (Math.abs(theDestination.x - myPosition.x) > 1
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

}
