package pieces;

import java.awt.Point;
/**
 * The rook piece in chess.
 * @author Gobindroop Mann
 * @version 0.1
 */
public class Rook extends AbstractPiece {
    /**The index size of the board.*/
    private static final int BOUNDSCHECK = 7;
    /***/
    private Point myPosition;
    /**
     * The constructor for the Rook.
     * @param thePosition The starting position for the Rook.
     * @param theIsWhite Whether or not the rook is white.
     */
    public Rook(final Point thePosition, final boolean theIsWhite) {
        super(thePosition, Piece.ROOK, theIsWhite);
        myPosition = thePosition;
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isValid(final Point theDestination) {
        if (theDestination.x < 0 || theDestination.y < 0
            || theDestination.x > BOUNDSCHECK || theDestination.y > BOUNDSCHECK) { //OOB
            return false;
        }
        if ((theDestination.x == myPosition.x)
            || (theDestination.y == myPosition.y)) { //Moving straight
            return true;
        } 
        return false;
    }
    
    @Override
    public String toString() {
        return "R";
    }

}
