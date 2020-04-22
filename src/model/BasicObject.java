package model;

import java.awt.Color;
import java.awt.Graphics;

public abstract class BasicObject extends ShapeObject {
	protected String name;
	protected Location[] ports;
	protected final int portSize = 5;

	public BasicObject(String name, Location upperLeft, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
		calculatePosition(upperLeft);
		createPorts();
	}

	private void createPorts() {
		ports = new Location[4];
		ports[0] = position[0].move(width / 2, 0);
		ports[1] = position[0].move(0, height / 2);
		ports[2] = position[0].move(width, height / 2);
		ports[3] = position[0].move(width / 2, height);
	}

	public Location[] getPorts() {
		return ports;
	}

	public void setName(String name) {
		this.name = name;
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
	public void move(int deltaX, int deltaY) {
		super.move(deltaX, deltaY);
		for (int i = 0; i < 4; i++) {
			ports[i] = ports[i].move(deltaX, deltaY);
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
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
