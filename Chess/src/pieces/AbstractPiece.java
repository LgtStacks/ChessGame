package pieces;
import java.awt.Point;
/**
 * An abstract Chess piece.
 * @author Gobindroop Mann
 * @version 0.1
 */
public abstract class AbstractPiece implements PieceInterface {
    /**The current position of the piece.*/
    private Point myPosition;
    /**The current type of the piece.*/
    private Piece myPiece;
    /**Whether the piece is currently white or not.*/
    private boolean myIsWhite;
    /**
     * Constructor for an Abstract Piece.
     * @param thePosition The starting position for the piece.
     * @param thePiece Which type of piece it is.
     * @param theIsWhite Whether or not the piece is white.
     */
    public AbstractPiece(final Point thePosition, final Piece thePiece,
                         final boolean theIsWhite) {
        myPosition = thePosition;
        myPiece = thePiece;
        myIsWhite = theIsWhite;
    }
    /**
     * Getter for the type of piece.
     * @return The type of piece.
     */
    public Piece getPiece() {
        return myPiece;
    }
    /**
     * Returns whether the piece is white or not.
     * @return Returns whether the piece is white or not.
     */
    public boolean isWhite() {
        return myIsWhite;
    }
    
    public String getColor() {
    	if(myIsWhite) {
    		return "W";
    	} else {
    		return "B";
    	}
    	
    }
    /**
     * @return The position of the piece.
     */
    public Point getPosition() {
        return myPosition;
    }
    /**
     * @return The value of the piece.
     */
    public int getValue() {
        return myPiece.getValue();
    }
    /**
     * Moves the piece to the destination provided.
     * @param theDestination Where the piece will move.
     */
    public void move(final Point theDestination) {
        myPosition = theDestination;
    }
}