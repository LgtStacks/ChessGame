package ChessBoard;

import java.awt.Point;
import java.util.Arrays;

import Pieces.*;

public class Board {
    private AbstractPiece[][] myBoard;
    private int myPiecesLeft;

    public Board() {
        myBoard = new AbstractPiece[8][8];
        myPiecesLeft = 0;
        Setup();
    }

    public void Setup() {//Sets up the ChessBoard
        //Creating all Black Pieces
        Rook blackLRook = new Rook(new Point(7, 0), false);
        Knight blackLKnight = new Knight(new Point(7, 1), false);
        Bishop blackLBishop = new Bishop(new Point(7, 2), false);
        King blackKing = new King(new Point(7, 3), false);
        Queen blackQueen = new Queen(new Point(7, 4), false);
        Bishop blackRBishop = new Bishop(new Point(7, 5), false);
        Knight blackRKnight = new Knight(new Point(7, 6), false);
        Rook blackRRook = new Rook(new Point(7, 7), false);
        Pawn blackPawn1 = new Pawn(new Point(6, 0), false);
        Pawn blackPawn2 = new Pawn(new Point(6, 1), false);
        Pawn blackPawn3 = new Pawn(new Point(6, 2), false);
        Pawn blackPawn4 = new Pawn(new Point(6, 3), false);
        Pawn blackPawn5 = new Pawn(new Point(6, 4), false);
        Pawn blackPawn6 = new Pawn(new Point(6, 5), false);
        Pawn blackPawn7 = new Pawn(new Point(6, 6), false);
        Pawn blackPawn8 = new Pawn(new Point(6, 7), false);

        //Creating all White Pieces
        Rook whiteLRook = new Rook(new Point(0, 0), true);
        Knight whiteLKnight = new Knight(new Point(0, 1), true);
        Bishop whiteLBishop = new Bishop(new Point(0, 2), true);
        King whiteKing = new King(new Point(0, 3), true);
        Queen whiteQueen = new Queen(new Point(0, 4), true);
        Bishop whiteRBishop = new Bishop(new Point(0, 5), true);
        Knight whiteRKnight = new Knight(new Point(0, 6), true);
        Rook whiteRRook = new Rook(new Point(0, 7), true);
        Pawn whitePawn1 = new Pawn(new Point(1, 0), true);
        Pawn whitePawn2 = new Pawn(new Point(1, 1), true);
        Pawn whitePawn3 = new Pawn(new Point(1, 2), true);
        Pawn whitePawn4 = new Pawn(new Point(1, 3), true);
        Pawn whitePawn5 = new Pawn(new Point(1, 4), true);
        Pawn whitePawn6 = new Pawn(new Point(1, 5), true);
        Pawn whitePawn7 = new Pawn(new Point(1, 6), true);
        Pawn whitePawn8 = new Pawn(new Point(1, 7), true);

        //Adding all Black pieces to Board
        add(blackLRook);
        add(blackLKnight);
        add(blackLBishop);
        add(blackQueen);
        add(blackKing);
        add(blackRBishop);
        add(blackRKnight);
        add(blackRRook);
        add(blackPawn1);
        add(blackPawn2);
        add(blackPawn3);
        add(blackPawn4);
        add(blackPawn5);
        add(blackPawn6);
        add(blackPawn7);
        add(blackPawn8);

        //Adding all White pieces to Board
        add(whiteLRook);
        add(whiteLKnight);
        add(whiteLBishop);
        add(whiteQueen);
        add(whiteKing);
        add(whiteRBishop);
        add(whiteRKnight);
        add(whiteRRook);
        add(whitePawn1);
        add(whitePawn2);
        add(whitePawn3);
        add(whitePawn4);
        add(whitePawn5);
        add(whitePawn6);
        add(whitePawn7);
        add(whitePawn8);
    }

    public boolean isFree(Point inQuestion) {
        if (myBoard[inQuestion.x][inQuestion.y] == null) {
            return true;
        }
        return false;
    }

    public void printBoard() {
        System.out.println(" ---------White---------");
        System.out.println(Arrays.deepToString(myBoard).replace("], ", "]\n------------------------\n").replace("[[", "[").replace("]]", "]").replace("null", " ").replace(",", "|"));
        System.out.println(" ---------Black---------");
    }

    public void attack(Point current, Point target) {
        AbstractPiece pieceInQuestion = myBoard[current.x][current.y];
        AbstractPiece targetInQuestion = myBoard[target.x][target.y];
        if (pieceInQuestion.isValid(target) && !isFree(target)) {
            if (pieceInQuestion.getPiece() == Piece.PAWN) {
                if (Math.abs(current.x - target.x) == 1 && Math.abs(current.y - target.y) == 1) {
                    pieceInQuestion.move(target);
                    myBoard[current.x][current.y] = null;
                    myBoard[target.x][target.y] = pieceInQuestion;
                }
            } else if (pieceInQuestion.getPiece() == Piece.ROOK) {
                if (isStraightClear(current, target)) {
                    pieceInQuestion.move(target);
                    myBoard[current.x][current.y] = null;
                    myBoard[target.x][target.y] = pieceInQuestion;
                }
            } else if (pieceInQuestion.getPiece() == Piece.BISHOP) {
                if (isDiagonalClear(current, target)) {
                    pieceInQuestion.move(target);
                    myBoard[current.x][current.y] = null;
                    myBoard[target.x][target.y] = pieceInQuestion;
                }
            } else if (pieceInQuestion.getPiece() == Piece.QUEEN) {
                if (isDiagonalClear(current, target) || isStraightClear(current, target)) {
                    pieceInQuestion.move(target);
                    myBoard[current.x][current.y] = null;
                    myBoard[target.x][target.y] = pieceInQuestion;
                }
            } else {
                pieceInQuestion.move(target);
                myBoard[current.x][current.y] = null;
                myBoard[target.x][target.y] = pieceInQuestion;
            }
        }
    }

    public void move(Point current, Point destination) {
        AbstractPiece pieceInQuestion = myBoard[current.x][current.y];
        if (pieceInQuestion.isValid(destination) && isFree(destination)) {//if the piece can move there and the spot is open then move it
            if (pieceInQuestion.getPiece() == Piece.BISHOP || pieceInQuestion.getPiece() == Piece.ROOK || pieceInQuestion.getPiece() == Piece.QUEEN) {
                if (!isStraightClear(current, destination)) {
                    throw new IllegalArgumentException();
                } else if (!isDiagonalClear(current, destination)) {
                    throw new IllegalArgumentException();
                }
            }
            pieceInQuestion.move(destination);
            myBoard[current.x][current.y] = null;
            myBoard[destination.x][destination.y] = pieceInQuestion;
        }
    }

    private boolean isDiagonalClear(Point current, Point destination) {
        if ((current.x < destination.x)) {//Moving down
            for (int i = 1; i <= destination.x - current.x; i++) {
                if (current.y < destination.y) {//Moving right
                    if (!isFree(new Point(current.x + i, current.y + i))) {
                        return false;
                    }
                } else if (current.y > destination.y) {//Moving left
                    if (!isFree(new Point(current.x + i, current.y - i))) {
                        return false;
                    }
                }
            }
        } else if ((current.x > destination.x)) {//Moving up
            for (int i = 1; i <= current.x - destination.x; i++) {
                if (current.y < destination.y) {//Moving right
                    if (!isFree(new Point(current.x - i, current.y + i))) {
                        return false;
                    }
                } else if (current.y > destination.y) {//Moving left
                    if (!isFree(new Point(current.x - i, current.y - i))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isStraightClear(Point current, Point destination) {
        if ((current.y == destination.y)) {//Moving vertically
            if (current.x > destination.x) {//Moving up
                for (int i = current.x; i > destination.x; i--) {
                    if (!isFree(new Point(i + 1, current.y))) {
                        return false;
                    }
                }
            }
            if (current.x < destination.x) {//Moving down
                for (int i = current.x; i < destination.x; i++) {
                    if (!isFree(new Point(i + 1, current.y))) {
                        return false;
                    }
                }
            }
            return true;
        } else if ((current.x == destination.x)) {//Moving horizontally
            if (current.y < destination.y) {//Moving right
                for (int i = current.y; i < destination.y; i++) {
                    if (!isFree(new Point(current.x, i + 1))) {
                        return false;
                    }
                }
            }
            if (current.y > destination.y) {//Moving left
                for (int i = current.y; i > destination.y; i--) {
                    if (!isFree(new Point(current.x, i - 1))) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private void add(AbstractPiece thePiece) {
        myPiecesLeft++;
        myBoard[thePiece.getPosition().x][thePiece.getPosition().y] = thePiece;
    }
}
