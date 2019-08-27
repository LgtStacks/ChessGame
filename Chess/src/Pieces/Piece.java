package Pieces;

public enum Piece {
	KING('K'),
	QUEEN('Q'),
	BISHOP('B'),
	KNIGHT('N'),
	ROOK('R'),
	PAWN('P');
	private char myLetter;
	
	Piece(char theLetter){
		myLetter = theLetter;
	}
	public int getValue() {
		if(myLetter == 'K') {
			return 99;
		} else if(myLetter == 'Q') {
			return 9;
		}else if(myLetter == 'B') {
			return 3;
		}else if(myLetter == 'N') {
			return 3;
		}else if(myLetter == 'R') {
			return 5;
		}else {
			return 1;
		}
	}
}
