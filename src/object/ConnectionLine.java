package object;

import java.awt.Color;
import java.awt.Graphics;

public abstract class ConnectionLine extends UML_Object {
	protected Port start;
	protected Port end;
	protected double theta;
	protected int arrowSize;

	public ConnectionLine(Port start, Port end, int arrowSize) {
		this.start = start;
		this.end = end;
		this.arrowSize = arrowSize;
	}

	@Override
	public void setDepth(int depth) {
		super.setDepth(99);
	}
	
	@Override
	public void setSelected(boolean selected) {
		selected = false;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
		theta = Math.atan2(end.getY() - start.getY(), end.getX() - start.getX());
	}
}
