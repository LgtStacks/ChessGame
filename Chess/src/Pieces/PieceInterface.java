package Pieces;
import java.awt.Point;

public interface PieceInterface {
	Point getPosition();
	int getValue();
	boolean isValid(Point theDestination);
	void move(Point theDestination);
}
