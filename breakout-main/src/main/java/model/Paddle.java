package model;

import utils.Vector;

/**
 * Created by mikkel on 21-Jul-16.
 */
public class Paddle {
	private final Vector position;

	public Paddle() {
		position = new Vector(100, 0);
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
