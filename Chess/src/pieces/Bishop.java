package pieces;

import java.awt.Point;
/**
 * The bishop chess piece.
 * @author Gobindroop Mann
 * @version 0.1
 */
public class Bishop extends AbstractPiece {
    /**The index size of the board.*/
    private static final int BOUNDSCHECK = 7;
    /**The current position of the piece.*/
    private Point myPosition;
    /**
     * Constructor for the Bishop.
     * @param thePosition The starting location for the bishop.
     * @param theIsWhite Whether the piece is white or not.
     */
    public Bishop(final Point thePosition, final boolean theIsWhite) {
        super(thePosition, Piece.BISHOP, theIsWhite);
        myPosition = thePosition;
    }
    
    @Override
    public boolean isValid(final Point theDestination) {
        if (theDestination.x < 0 || theDestination.y < 0
            || theDestination.x > BOUNDSCHECK || theDestination.y > BOUNDSCHECK) { //OOB
            return false;
        }
        if (Math.abs(theDestination.x - myPosition.x)
            == Math.abs(theDestination.y - myPosition.y)) { //Moving diagonally
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "B";
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
