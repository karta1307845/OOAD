package model;

import java.awt.Color;
import java.awt.Graphics;

public abstract class ConnectionLine extends UML_Object {
	protected BasicObject startObj;
	protected BasicObject endObj;
	protected Location start;
	protected Location end;
	protected double theta;
	protected int arrowSize;

	public ConnectionLine(BasicObject startObj, Location start, BasicObject endObj, Location end, int arrowSize) {
		this.startObj = startObj;
		this.endObj = endObj;
		this.start = start;
		this.end = end;
		this.arrowSize = arrowSize;
		super.setDepth(99);
	}

	@Override
	public void move(int deltaX, int deltaY) {
		moveStart(deltaX, deltaY);
		moveEnd(deltaX, deltaY);
	}

	public void moveStart(int deltaX, int deltaY) {
		start = start.move(deltaX, deltaY);
	}

	public void moveEnd(int deltaX, int deltaY) {
		end = end.move(deltaX, deltaY);
	}

	@Override
	protected boolean isSelected(Location upperLeft, Location bottomRight) {
		Location[] points = new Location[] { start, end };
		for (Location point : points) {
			int x = point.getX();
			int y = point.getY();
			if (x < upperLeft.getX() || x > bottomRight.getX() || y < upperLeft.getX() || y > bottomRight.getY()) {
				return false;
			}
		}
		return true;
	}

	public BasicObject getStartObj() {
		return startObj;
	}

	public BasicObject getEndObj() {
		return endObj;
	}

	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
		theta = Math.atan2(end.getY() - start.getY(), end.getX() - start.getX());
	}
}
