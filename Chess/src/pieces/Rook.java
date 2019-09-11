package pieces;

import java.awt.Point;
/**
 * The rook piece in chess.
 * @author Colby Tong
 * @author Gobindroop Mann
 * @version 0.1
 */
public class Rook extends AbstractPiece {
    /**The index size of the board.*/
    private static final int BOUNDSCHECK = 7;
    /***/
    private Point myPosition;
    /***/
    private int myMoveCount;
    /**
     * The constructor for the Rook.
     * @param thePosition The starting position for the Rook.
     * @param theIsWhite Whether or not the rook is white.
     */
    public Rook(final Point thePosition, final boolean theIsWhite) {
        super(thePosition, Piece.ROOK, theIsWhite);
        myPosition = thePosition;
        myMoveCount = 0;
    }
    /**
     * Returns the amount of moves the rook has made.
     * @return The amount of moves the rook has made.
     */
    public int moveCount() {
        return myMoveCount;
    }

    @Override
    public boolean isValid(final Point theDestination) {
        if (theDestination.x < 0 || theDestination.y < 0
                || theDestination.x > BOUNDSCHECK || theDestination.y > BOUNDSCHECK) { //OOB
            return false;
        } else if ((theDestination.x == myPosition.x)
                && (theDestination.y - myPosition.y == 2)) { //Castling
            if (myMoveCount == 0) { //Rook has not moved yet
                return true;
            }
        } else if ((theDestination.x == myPosition.x)
                || (theDestination.y == myPosition.y)) { //Moving straight
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "R";
    }
    @Override
    public boolean canAttack(final Point theDestination) {
        return isValid(theDestination);
    }
    /**
     * @return The position of the piece.
     */
    public Point getPosition() {
        return myPosition;
    }
    @Override
    public void move(final Point theDestination) {
        myPosition = theDestination;
        myMoveCount++;
    }


}