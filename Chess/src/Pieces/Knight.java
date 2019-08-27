package Pieces;

import java.awt.Point;

public class Knight extends AbstractPiece {
	private Point myPosition;
	
	public Knight(Point thePosition, boolean isWhite) {
		super(thePosition, Piece.KNIGHT, isWhite);
		myPosition = thePosition;
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean isValid(Point theDestination) {
		// TODO Auto-generated method stub
		if(theDestination.x < 0 || theDestination.y < 0 || theDestination.x > 7 || theDestination.y > 7) {//OOB
			return false;
		}
		if(Math.abs(theDestination.x - myPosition.x) == 1 &&
				Math.abs(theDestination.y - myPosition.y) == 2) {
			return true;
		} if(Math.abs(theDestination.x - myPosition.x) == 2 &&
				Math.abs(theDestination.y - myPosition.y) == 1) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "N";
	}

}
