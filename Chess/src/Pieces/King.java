package Pieces;

import java.awt.Point;

public class King extends AbstractPiece{
	private Point myPosition;
	
	public King(Point thePosition, boolean isWhite) {
		super(thePosition, Piece.KING , isWhite);
		myPosition = thePosition;
	}

	@Override
	public boolean isValid(Point theDestination) {
		// TODO Auto-generated method stub
		if(theDestination.x < 0 || theDestination.y < 0 || theDestination.x > 7 || theDestination.y > 7) {//OOB
			return false;
		}
		if(Math.abs(theDestination.x - myPosition.x) > 1) {//Can move one in X
			return false;
		}
		if(Math.abs(theDestination.y - myPosition.y) > 1) {//Also can move one in Y
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "K";
	}

}
