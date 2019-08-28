package Pieces;

import java.awt.Point;

public class Bishop extends AbstractPiece {
	private Point myPosition;
	
	public Bishop(Point thePosition, boolean isWhite) {
		super(thePosition, Piece.BISHOP, isWhite);
		myPosition = thePosition;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isValid(Point theDestination) {
		if(theDestination.x < 0 || theDestination.y < 0 || theDestination.x > 7 || theDestination.y > 7) {//OOB
			return false;
		} if(Math.abs(theDestination.x - myPosition.x) ==
			 Math.abs(theDestination.y - myPosition.y)) {//Moving diagonally
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "B";
	}

}
