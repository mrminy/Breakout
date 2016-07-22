package model;

import utils.Vector;

import static utils.Utils.*;

/**
 * Created by mikkel on 21-Jul-16.
 */
public class Ball {
	private Vector position;
	private double direction; // Floating point for defining direction using radians (0 - 2*pi)

	public Ball() {
		reset();
	}

	public Ball(double x, double y) {
		position.setX(x);
		position.setY(y);
	}

	public void reset(){
		position = new Vector(G_WIDTH / 2, G_HEIGHT / 2);
	}

	public double getX() {
		return position.getX();
	}

	public double getY() {
		return position.getY();
	}

	public Vector getPosition() {
		return position;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}

	public double getDirection() {
		return direction;
	}

	public double getConvertedDirection() {
		return direction * 360.0;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public void move(double deltaX, double deltaY) {
		position.setX(getX() + deltaX);
		position.setY(getY() + deltaY);
	}
}
