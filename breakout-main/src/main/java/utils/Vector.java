package utils;

/**
 * Created by mikkel on 21-Jul-16.
 */
public class Vector {
	private double x, y;

	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public static double generateRandomDirection() {
		return Math.random() * Math.PI * 2;
	}

	public static double generateRandomDirectionDownOrUp(boolean up) {
		if (up) {
			return (Math.random() * 0.5 + 0.5) * Math.PI * 2;
		}else{
			return (Math.random() * 0.5) * Math.PI * 2;
		}

	}
}
