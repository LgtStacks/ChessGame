package Pieces;
import java.awt.Point;

public abstract class AbstractPiece implements PieceInterface {
	private Point myPosition;
	private Piece myPiece;
	public AbstractPiece(Point thePosition, Piece thePiece, boolean isWhite) {
		myPosition = thePosition;
		myPiece = thePiece;
	}
	public Piece getPiece() {
		return myPiece;
	}
	
	public Point getPosition() {
		return myPosition;
	}
	public int getValue() {
		return myPiece.getValue();
	}
	public void move(Point theDestination) {
			myPosition = theDestination;
	}
}
