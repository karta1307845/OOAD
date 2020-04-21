package model;

public class Location {
	private int x;
	private int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Location move(int deltaX, int deltaY) {
		int x = this.getX();
		int y = this.getY();
		return new Location(x + deltaX, y + deltaY);
	}

	public double getSlope(Location point) {
		double deltaX = this.x - point.x;
		double deltaY = this.y - point.y;

		if (deltaX != 0) {
			return deltaY / deltaX;
		} else {
			return Double.MAX_VALUE;
		}
	}

	public double getDistance(Location point) {
		double sumX = Math.pow(this.x - point.x, 2);
		double sumY = Math.pow(this.y - point.y, 2);
		double result = Math.sqrt(sumX + sumY);
		return result;
	}

	public Location rotate(Location original, double theta) {
		double sin = Math.sin(theta);
		double cos;

		if (sin == 1 || sin == -1) {
			cos = 0;
		} else {
			cos = Math.cos(theta);
		}
		if (cos == 1 || cos == -1) {
			sin = 0;
		}

		int tempX = this.getX();
		int tempY = this.getY();
		int x = (int) (tempX * cos - tempY * sin) + original.getX();
		int y = (int) (tempX * sin + tempY * cos) + original.getY();

		return new Location(x, y);
	}
}
