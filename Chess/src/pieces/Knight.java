package pieces;

import java.awt.Point;
/**
 * The Knight piece in chess.
 * @author Gobindroop Mann
 * @version 0.1
 */
public class Knight extends AbstractPiece {
    /**The index size of the board.*/
    private static final int BOUNDSCHECK = 7;
    /**The current position of the Knight.*/
    private Point myPosition;
    /**
     * The constructor for the Knight.
     * @param thePosition The starting position for the knight.
     * @param theIsWhite Whether the knight is white or black.
     */
    public Knight(final Point thePosition, final boolean theIsWhite) {
        super(thePosition, Piece.KNIGHT, theIsWhite);
        myPosition = thePosition;
    }
    
    
    @Override
    public boolean isValid(final Point theDestination) {
        if (theDestination.x < 0 || theDestination.y < 0
            || theDestination.x > BOUNDSCHECK || theDestination.y > BOUNDSCHECK) { //OOB
            return false;
        }
        if ((Math.abs(theDestination.x - myPosition.x) == 1
            && Math.abs(theDestination.y - myPosition.y) == 2)
            || (Math.abs(theDestination.x - myPosition.x) == 2 
            && Math.abs(theDestination.y - myPosition.y) == 1)) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "N";
    }

}
