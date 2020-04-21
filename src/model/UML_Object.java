package model;

import java.awt.Graphics;

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

	public abstract void draw(Graphics g);

	@Override
	public int compareTo(UML_Object obj) {
		return this.depth - obj.depth;
	}
}
