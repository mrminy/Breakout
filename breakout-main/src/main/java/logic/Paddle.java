package logic;

import utils.Position;

/**
 * Created by mikkel on 21-Jul-16.
 */
public class Paddle {
	private final Position position;

	public Paddle() {
		position = new Position(0, 0);
	}

	public double getY() {
		return position.getY();
	}

	public double getX() {
		return position.getX();
	}

	public void move(double deltaX){
		position.setX(position.getX() + deltaX);
	}
}
