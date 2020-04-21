package model;

import java.awt.Graphics;

public abstract class BasicObject extends UML_Object {
	protected String name;
	public Location[] position;
	protected int width;
	protected int height;
	protected Location[] ports;
	protected final int portSize = 5;

	public BasicObject(String name, Location upperLeft, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
		position = new Location[4];
		calculatePosition(upperLeft);
		ports = new Location[4];
		createPorts();
	}

	private void calculatePosition(Location upperLeft) {
		position[0] = upperLeft;
		position[1] = upperLeft.move(width, 0);
		position[2] = upperLeft.move(0, height);
		position[3] = upperLeft.move(width, height);
	}

	private void createPorts() {
		ports[0] = position[0].move(width / 2, 0);
		ports[1] = position[0].move(0, height / 2);
		ports[2] = position[0].move(width, height / 2);
		ports[3] = position[0].move(width / 2, height);
	}

	public boolean isClicked(Location clickPoint) {
		int x = clickPoint.getX();
		int y = clickPoint.getY();

		if (x < position[0].getX() || x > position[1].getX()) {
			return false;
		}

		if (y < position[0].getY() || y > position[2].getY()) {
			return false;
		}

		return true;
	}

	public Location getMappingPort(Location clickPoint) {
		double diagonalSlope1 = position[3].getSlope(position[0]);
		double diagonalSlope2 = position[2].getSlope(position[1]);
		double slope1 = clickPoint.getSlope(position[0]);
		double slope2 = clickPoint.getSlope(position[1]);
		boolean smaller1 = false;
		boolean smaller2 = false;

		if (slope1 < diagonalSlope1) {
			smaller1 = true;
		}

		if (slope2 < diagonalSlope2) {
			smaller2 = true;
		}

		if (smaller1 && smaller2) {
			return ports[2];
		} else if (smaller1) {
			return ports[0];
		} else if (smaller2) {
			return ports[3];
		} else {
			return ports[1];
		}
	}

	@Override
	public void draw(Graphics g) {
		if (selected) {
			for (Location i : ports) {
				int x = i.getX();
				int y = i.getY();
				int[] xAry = new int[] { x + portSize, x + portSize, x - portSize, x - portSize };
				int[] yAry = new int[] { y - portSize, y + portSize, y + portSize, y - portSize };

				g.fillPolygon(xAry, yAry, 4);
			}
		}
	}
}
