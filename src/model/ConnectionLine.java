package model;

import java.awt.Graphics;

public abstract class ConnectionLine extends UML_Object {
	protected Location start;
	protected Location end;
	protected double theta;
	protected int arrowSize;

	public ConnectionLine(Location start, Location end, int arrowSize) {
		this.start = start;
		this.end = end;
		this.arrowSize = arrowSize;
	}

	public void draw(Graphics g) {
		g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
		theta = Math.atan2(end.getY() - start.getY(), end.getX() - start.getX());
	}
}
