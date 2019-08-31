package pieces;
/**
 * An enum to represent the different pieces in chess.
 * @author Gobindroop Mann
 * @version 0.1
 */
public enum Piece {
    /**The King.*/
    KING('K'),
    /**The Queen.*/
    QUEEN('Q'),
    /**The Bishop.*/
    BISHOP('B'),
    /**The Knight.*/
    KNIGHT('N'),
    /**The Rook.*/
    ROOK('R'),
    /**The Pawn.*/
    PAWN('P');
    /**The value of a King.*/
    private static final int KINGVALUE = 99;
    /**The value of a Queen.*/
    private static final int QUEENVALUE = 9;
    /**The value of a Bishop.*/
    private static final int BISHOPVALUE = 3;
    /**The value of a Knight.*/
    private static final int KNIGHTVALUE = 3;
    /**The value of a Rook.*/
    private static final int ROOKVALUE = 5;
    /**The value of a Pawn.*/
    private static final int PAWNVALUE = 1;
    /**The chosen letter.*/
    private char myLetter;
    /**
     * The constructor for a Piece.
     * @param theLetter The letter chosen.
     */
    Piece(final char theLetter) {
        myLetter = theLetter;
    }
    /**
     * Returns the value of the Piece.
     * @return The values of the Piece.
     */
    public int getValue() {
        final int returnValue;
        if (myLetter == 'K') {
            returnValue = KINGVALUE;
        } else if (myLetter == 'Q') {
            returnValue = QUEENVALUE;
        } else if (myLetter == 'B') {
            returnValue = BISHOPVALUE;
        } else if (myLetter == 'N') {
            returnValue = KNIGHTVALUE;
        } else if (myLetter == 'R') {
            returnValue = ROOKVALUE;
        } else {
            returnValue = PAWNVALUE;
        }
        return returnValue;
    }
}
