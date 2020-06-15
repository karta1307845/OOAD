package object;

import java.awt.Graphics;

import model.Location;

public abstract class UML_Object implements Comparable<UML_Object> {
	protected int depth;
	protected boolean selected;

	public UML_Object() {
		this(0);
	}

	public UML_Object(int depth) {
		this.depth = depth;
		selected = false;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getDepth() {
		return depth;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean getSelected() {
		return selected;
	}

	public boolean isClicked(Location clickPoint) {
		return false;
	}

	protected abstract boolean isSelected(Location upperLeft, Location bottomRight);

	public abstract void move(int deltaX, int deltaY);

	public abstract void draw(Graphics g);

	@Override
	public int compareTo(UML_Object obj) {
		return this.depth - obj.depth;
	}
}
