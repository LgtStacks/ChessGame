package Pieces;

import java.awt.Point;

public class Pawn extends AbstractPiece {
	private Point myPosition;
	private int myMoveCount;
	private boolean myIsWhite;

	public Pawn(Point thePosition, boolean isWhite) {
		super(thePosition, Piece.PAWN, isWhite);
		myIsWhite = isWhite;
		myPosition = thePosition;
		myMoveCount = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(Point theDestination) {
			myPosition = theDestination;
			myMoveCount++;
	}

	@Override
	public boolean isValid(Point theDestination) {
		if(theDestination.x < 0 || theDestination.y < 0 || theDestination.x > 7 || theDestination.y > 7) {//OOB
			return false;
		}
		if (theDestination.y != myPosition.y) {// Can't move in Y direction
			return false;
		}
		if (myIsWhite) {// White Piece
			if ((myMoveCount == 0) && (theDestination.x - myPosition.x == 2)) {// First Turn
				return true;
			}
			if (theDestination.x - myPosition.x == 1) {// Every other turn
				return true;
			}
		}
		if (!myIsWhite) {// Black Piece
			if ((myMoveCount == 0) && (theDestination.x - myPosition.x == -2)) {// First Turn
				return true;
			}
			if (theDestination.x - myPosition.x == -1) {// Every other turn
				return true;
			}
		}

		return false;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
