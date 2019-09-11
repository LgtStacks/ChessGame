package pieces;

import java.awt.Point;

/**
 * An interface for all Chess pieces.
 *
 * @author Gobindroop Mann
 * @version 0.1
 */
public interface PieceInterface {
    /**
     * Getter for the Position of the Piece.
     *
     * @return The current position of the piece.
     */
    Point getPosition();

    /**
     * Getter for the value of the piece.
     *
     * @return The value of the piece.
     */
    int getValue();

    /**
     * Returns if a move is valid for a given piece.
     *
     * @param theDestination Where the piece is trying to move.
     * @return Whether the piece can move where it is trying to.
     */
    boolean isValid(Point theDestination);

    /**
     * Moves the piece to where is needs to move.
     *
     * @param theDestination Where the piece is going.
     */
    void move(Point theDestination);

    /**
     * Returns if the piece can attack a certain spot.
     *
     * @param theDestination Where the piece is trying to attack
     * @return If the piece can attack there
     */
    boolean canAttack(Point theDestination);
}