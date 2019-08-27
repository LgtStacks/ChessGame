package Pieces;

import java.awt.Point;

public class Rook extends AbstractPiece {
	private Point myPosition;

	public Rook(Point thePosition, boolean isWhite) {
		super(thePosition, Piece.ROOK, isWhite);
		myPosition = thePosition;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValid(Point theDestination) {
		if(theDestination.x < 0 || theDestination.y < 0 || theDestination.x > 7 || theDestination.y > 7) {//OOB
			return false;
		} if((theDestination.x == myPosition.x) ||
			 (theDestination.y == myPosition.y)) {//Moving straight
			return true;
		} 
		return false;
	}
	
	@Override
	public String toString() {
		return "R";
	}

}
