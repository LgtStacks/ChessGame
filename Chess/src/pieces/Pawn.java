package pieces;

import java.awt.Point;

/**
 * The pawn piece in Chess.
 *
 * @author Gobindroop Mann
 * @version 0.1
 */
public class Pawn extends AbstractPiece {
    /**
     * The index size of the board.
     */
    private static final int BOUNDSCHECK = 7;
    /***/
    private Point myPosition;
    /***/
    private int myMoveCount;
    /***/
    private boolean myIsWhite;

    /**
     * The constructor for the Pawn.
     *
     * @param thePosition The starting location of the pawn.
     * @param theIsWhite  Whether the pawn is white or black.
     */
    public Pawn(final Point thePosition, final boolean theIsWhite) {
        super(thePosition, Piece.PAWN, theIsWhite);
        myIsWhite = theIsWhite;
        myPosition = thePosition;
        myMoveCount = 0;
    }

    /**
     * Helper method to check if the pawn move is valid.
     *
     * @param theDestination Where the pawn is trying to move
     * @return Whether it is valid or not for the pawn to move there.
     */
    private boolean pawnCheck(final Point theDestination) {
        if (theDestination.x < 0 || theDestination.y < 0
                || theDestination.x > BOUNDSCHECK || theDestination.y > BOUNDSCHECK) { //OOB
            return false;
        }
        if (theDestination.y != myPosition.y) { // Can't move in Y direction
            return false;
        }
        return true;
    }


    @Override
    public void move(final Point theDestination) {
        myPosition = theDestination;
        myMoveCount++;
    }

    @Override
    public boolean isValid(final Point theDestination) {
        boolean flag = false;
        if (!pawnCheck(theDestination)) {
            return false;
        }
        if (myIsWhite) { // White Piece
            if ((myMoveCount == 0) && (theDestination.x - myPosition.x == 2)) { // First Turn
                flag = true;
            }
            if (theDestination.x - myPosition.x == 1) { // Every other turn
                flag = true;
            }
        }
        if (!myIsWhite) { // Black Piece
            if ((myMoveCount == 0) && (myPosition.x - theDestination.x == 2)) { // First Turn
                flag = true;
            }
            if (theDestination.x - myPosition.x == -1) { // Every other turn
                flag = true;
            }
        }
        return flag;

    }

    @Override
    public String toString() {
        return "P";
    }
    
    @Override
    public boolean canAttack(final Point theDestination) {
        if (myIsWhite) {
            if (theDestination.x - myPosition.x == 1
                    && Math.abs(theDestination.y - myPosition.y) == 1) {
                return true;
            }
        } else if (!myIsWhite) {
            if (theDestination.x - myPosition.x == -1
                    && Math.abs(theDestination.y - myPosition.y) == 1) {
                return true;
            }
        }
        return false;
    }

}