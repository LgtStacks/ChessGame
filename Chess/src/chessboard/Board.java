package chessboard;

import java.awt.Point;
import java.util.Arrays;

import pieces.AbstractPiece;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

/**
 * The Chess-Board in a game of Chess.
 * @author Gobindroop Mann
 * @author Colby Tong
 * @version 0.1
 */
public class Board {
    /**
     * The size of a board.
     */
    private static final int BOARDSIZE = 8;
    /**
     * A 2-D array representing the board.
     */
    private AbstractPiece[][] myBoard;
    /**
     * The amount of pieces left on the board.
     */
    private int myPiecesLeft;

    /**
     * The constructor for a board.
     */
    public Board() {
        myBoard = new AbstractPiece[BOARDSIZE][BOARDSIZE];
        myPiecesLeft = 0;
        setupBlack();
        setupWhite();
    }

    /**
     * Creates and adds all of the black pieces to the board.
     */
    private void setupBlack() { // Sets up the ChessBoard
        // Creating all Black Pieces
        final Rook blackLRook = new Rook(new Point(7, 0), false);
        final Knight blackLKnight = new Knight(new Point(7, 1), false);
        final Bishop blackLBishop = new Bishop(new Point(7, 2), false);
        final King blackKing = new King(new Point(7, 3), false);
        final Queen blackQueen = new Queen(new Point(7, 4), false);
        final Bishop blackRBishop = new Bishop(new Point(7, 5), false);
        final Knight blackRKnight = new Knight(new Point(7, 6), false);
        final Rook blackRRook = new Rook(new Point(7, 7), false);
        final Pawn blackPawn1 = new Pawn(new Point(6, 0), false);
        final Pawn blackPawn2 = new Pawn(new Point(6, 1), false);
        final Pawn blackPawn3 = new Pawn(new Point(6, 2), false);
        final Pawn blackPawn4 = new Pawn(new Point(6, 3), false);
        final Pawn blackPawn5 = new Pawn(new Point(6, 4), false);
        final Pawn blackPawn6 = new Pawn(new Point(6, 5), false);
        final Pawn blackPawn7 = new Pawn(new Point(6, 6), false);
        final Pawn blackPawn8 = new Pawn(new Point(6, 7), false);

        // Adding all Black pieces to Board
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
    }

    /**
     * Creates and adds all of the white pieces to the board.
     */
    private void setupWhite() { // Sets up the ChessBoard
        // Creating all White Pieces
        final Rook whiteLRook = new Rook(new Point(0, 0), true);
        final Knight whiteLKnight = new Knight(new Point(0, 1), true);
        final Bishop whiteLBishop = new Bishop(new Point(0, 2), true);
        final King whiteKing = new King(new Point(0, 3), true);
        final Queen whiteQueen = new Queen(new Point(0, 4), true);
        final Bishop whiteRBishop = new Bishop(new Point(0, 5), true);
        final Knight whiteRKnight = new Knight(new Point(0, 6), true);
        final Rook whiteRRook = new Rook(new Point(0, 7), true);
        final Pawn whitePawn1 = new Pawn(new Point(1, 0), true);
        final Pawn whitePawn2 = new Pawn(new Point(1, 1), true);
        final Pawn whitePawn3 = new Pawn(new Point(1, 2), true);
        final Pawn whitePawn4 = new Pawn(new Point(1, 3), true);
        final Pawn whitePawn5 = new Pawn(new Point(1, 4), true);
        final Pawn whitePawn6 = new Pawn(new Point(1, 5), true);
        final Pawn whitePawn7 = new Pawn(new Point(1, 6), true);
        final Pawn whitePawn8 = new Pawn(new Point(1, 7), true);
        // Adding all White pieces to Board
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

    /**
     * Returns whether the space passed on the board is free or not.
     *
     * @param thePoint The x,y coordinate on the board to check
     * @return If the space at the point given is free
     */
    public boolean isFree(final Point thePoint) {
        if (myBoard[thePoint.x][thePoint.y] == null) {
            return true;
        }
        return false;
    }

    /**
     * Prints out the board.
     */
    public void printBoard() {
        System.out.println(" ---------White---------");
        System.out.println(Arrays.deepToString(myBoard).replace
                ("], ", "]\n------------------------\n").replace
                ("[[", "[").replace("]]", "]").replace("null", " ").replace(",", "|"));
        System.out.println(" ---------Black---------");
    }

    /**
     * Moves the piece at the current location to the target location.
     *
     * @param theCurrent     The current location of the piece of interest
     * @param theDestination The destination of the piece of interest
     */
    public void move(final Point theCurrent, final Point theDestination) {
        final AbstractPiece pieceInQuestion = myBoard[theCurrent.x][theCurrent.y];
        final AbstractPiece attackedPiece = myBoard[theDestination.x][theDestination.y];
        System.out.println("Can the piece maneuver to the destination: "
            + pieceInQuestion.isValid(theDestination));
        System.out.println("Is the destination free: " + isFree(theDestination));
        if (pieceInQuestion.getPiece() == Piece.KING && theCurrent.y - theDestination.y == 2) {
            //Piece is a king and destination is two Y to the left
            castle(theCurrent, theDestination);
        } else if (pieceInQuestion.isValid(theDestination)
                && isFree(theDestination)) { // if the piece can move there and the spot is
            // open then move it
            pathClearanceChecker(theCurrent, theDestination);
            System.out.println("Moving...");
            pieceInQuestion.move(theDestination);
            myBoard[theCurrent.x][theCurrent.y] = null;
            myBoard[theDestination.x][theDestination.y] = pieceInQuestion;
        } else if (pieceInQuestion.canAttack(theDestination)
                && !isFree(theDestination)
                && (attackedPiece.isWhite() != pieceInQuestion.isWhite())) {
            //Can attack destination
            //and there is a piece there to attack
            //and they are different colors
            System.out.println("Attacking...");
            pathClearanceChecker(theCurrent, theDestination);
            pieceInQuestion.move(theDestination);
            myBoard[theCurrent.x][theCurrent.y] = null;
            myBoard[theDestination.x][theDestination.y] = pieceInQuestion;
            myPiecesLeft--;
        } else {
            throw new IllegalArgumentException("This piece cannot move here");
        }
    }

    /**
     * Checks whether the path from current to destination is clear when moving diagonally.
     *
     * @param theCurrent     The current location of the piece that is trying to move
     * @param theDestination The desired destination for the piece that is trying to move
     * @return A boolean returning whether or not the path is clear
     * between current and destination.
     */
    private boolean isDiagonalClear(final Point theCurrent, final Point theDestination) {
        if (theCurrent.x < theDestination.x) { // Moving down
            for (int i = 1; i < theDestination.x - theCurrent.x; i++) {
                if (theCurrent.y < theDestination.y) { // Moving right
                    if (!isFree(new Point(theCurrent.x + i, theCurrent.y + i))) {
                        return false;
                    }
                } else if (theCurrent.y > theDestination.y) { // Moving left
                    if (!isFree(new Point(theCurrent.x + i, theCurrent.y - i))) {
                        return false;
                    }
                }
            }
        } else if (theCurrent.x > theDestination.x) { // Moving up
            for (int i = 1; i < theCurrent.x - theDestination.x; i++) {
                if (theCurrent.y < theDestination.y) { // Moving right
                    if (!isFree(new Point(theCurrent.x - i, theCurrent.y + i))) {
                        return false;
                    }
                } else if (theCurrent.y > theDestination.y) { // Moving left
                    if (!isFree(new Point(theCurrent.x - i, theCurrent.y - i))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Checks whether the path from current to destination is clear when moving straight.
     *
     * @param theCurrent     The current location of the piece that is trying to move
     * @param theDestination The desired destination for the piece that is trying to move
     * @return A boolean returning whether or not the path is clear
     * between current and destination.
     */
    private boolean isStraightClear(final Point theCurrent, final Point theDestination) {
        if (theCurrent.y == theDestination.y) { // Moving vertically
            for (int i = 1; i < Math.abs(theCurrent.x - theDestination.x); i++) {
                if ((theCurrent.x > theDestination.x
                        && !isFree(new Point(theCurrent.x - i, theCurrent.y)))
                        || (theCurrent.x < theDestination.x
                                && !isFree(new Point(theCurrent.x + i, theCurrent.y)))) {
                    return false;
                }
            }
        } else if (theCurrent.x == theDestination.x) { // Moving horizontally
            for (int i = 1; i < Math.abs(theCurrent.y - theDestination.y); i++) {
                if ((theCurrent.y > theDestination.y
                        && !isFree(new Point(theCurrent.x, theCurrent.y - i)))
                        || (theCurrent.y < theDestination.y
                                && !isFree(new Point(theCurrent.x, theCurrent.y + i)))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Adds a piece to the board.
     *
     * @param thePiece The Piece you want to add to the board
     */
    private void add(final AbstractPiece thePiece) {
        myPiecesLeft++;
        myBoard[thePiece.getPosition().x][thePiece.getPosition().y] = thePiece;
    }

    /**
     * Throws an error if the path to a destination is blocked.
     *
     * @param theCurrent     Where the piece is starting
     * @param theDestination The destination or where the piece is going.
     */
    private void pathClearanceChecker(final Point theCurrent, final Point theDestination) {
        final AbstractPiece pieceInQuestion = myBoard[theCurrent.x][theCurrent.y];
        if (pieceInQuestion.getPiece() == Piece.ROOK) {
            if (!isStraightClear(theCurrent, theDestination)) {
                throw new IllegalArgumentException("Straight path of rook is blocked");
            }
        } else if (pieceInQuestion.getPiece() == Piece.BISHOP) {
            if (!isDiagonalClear(theCurrent, theDestination)) {
                throw new IllegalArgumentException("Diagonal path of bishop is blocked");
            }
        } else if (pieceInQuestion.getPiece() == Piece.QUEEN) {
            if ((theCurrent.x == theDestination.x //traveling straight
                    || theCurrent.y == theDestination.y)
                    && !isStraightClear(theCurrent, theDestination)) {
                throw new IllegalArgumentException("Stright path of queen blocked");
            } else if (!isDiagonalClear(theCurrent, theDestination)) {
                throw new IllegalArgumentException("Diagonal path of queen blocked");
            }
        }
    }
    /**
     * Performs castle if possible, does nothing otherwise.
     * Assumes Piece is a King and the destination is > 1 unit away
     * @param theCurrent     Where the piece is starting
     * @param theDestination The destination or where the piece is going.
     */
    private void castle(final Point theCurrent, final Point theDestination) {
        final AbstractPiece kingInQuestion = myBoard[theCurrent.x][theCurrent.y];
        if (kingInQuestion.isValid(theDestination) && isFree(theDestination)) {
         // Destination is a castling spot, king has not moved yet, and the destination is open
            final Point rookDestination = new Point(theCurrent.x, theCurrent.y - 1);
            final AbstractPiece rookInQuestion = myBoard[theCurrent.x][0];
            if (rookInQuestion != null) {
                if (rookInQuestion.isValid(rookDestination) && isFree(rookDestination)) {
    // Rook has valid castling destination, rook has not moved yet, and its destination is open
                    System.out.println("Castling...");
                    kingInQuestion.move(theDestination);
                    myBoard[theCurrent.x][theCurrent.y] = null;
                    myBoard[theDestination.x][theDestination.y] = kingInQuestion;
                    rookInQuestion.move(rookDestination);
                    myBoard[theCurrent.x][0] = null;
                    myBoard[rookDestination.x][rookDestination.y] = rookInQuestion;
                }
            }
        }
    }
}