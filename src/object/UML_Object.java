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
		if (depth < 0) {
			this.depth = 0;
		} else if (depth > 99) {
			this.depth = 99;
		} else {
			this.depth = depth;
		}
	}

	public int getDepth() {
		return depth;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean getSelected() {
		return false;
	}

	public boolean isClicked(Location clickPoint) {
		return false;
	}

	protected boolean isInsideSelectArea(SelectArea area) {
		return false;
	}

	public Location[] getPosition() {
		return null;
	}

	public void move(int deltaX, int deltaY) {

	}

	public void group(UML_Object[] elements) {

	}

	public UML_Object[] unGroup() {
		return null;
	}

	public boolean isBasicObject() {
		return false;
	}

	public boolean isCompositeObject() {
		return false;
	}

	public void setName(String name) {

	}

	public Port getMappingPort(Location clickPoint) {
		return null;
	}

	public abstract void draw(Graphics g);

	@Override
	public int compareTo(UML_Object obj) {
		return this.depth - obj.depth;
	}
}
