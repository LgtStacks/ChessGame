package Pieces;

import java.awt.Point;

public class Queen extends AbstractPiece {
	private Point myPosition;

	public Queen(Point thePosition, boolean isWhite) {
		super(thePosition, Piece.QUEEN, isWhite);
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
		} if(Math.abs(theDestination.x - myPosition.x) ==
			 Math.abs(theDestination.y - myPosition.y)) {//Moving diagonally
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Q";
	}

}
