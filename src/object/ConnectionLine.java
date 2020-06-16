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
	public void move(int deltaX, int deltaY) {
		
		//moveStart(deltaX, deltaY);
		//moveEnd(deltaX, deltaY);
	}

	/*public void moveStart(int deltaX, int deltaY) {
		start.move(deltaX, deltaY);
	}

	public void moveEnd(int deltaX, int deltaY) {
		end.move(deltaX, deltaY);
	}*/

	public BasicObject getStartObj() {
		return start.getParent();
	}

	public BasicObject getEndObj() {
		return end.getParent();
	}

	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
		theta = Math.atan2(end.getY() - start.getY(), end.getX() - start.getX());
	}
}
