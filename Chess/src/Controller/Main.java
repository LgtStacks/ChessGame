package Controller;

import java.awt.Point;

import ChessBoard.Board;

public class Main {

	public static void main(String[] args) {
		Board testBoard = new Board();
		testBoard.printBoard();
		testBoard.move(new Point(1,0), new Point(3,0));
		System.out.println();
		System.out.println();
		System.out.println();
		testBoard.printBoard();
		

	}

}
