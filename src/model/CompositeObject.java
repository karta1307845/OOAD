package model;

import java.awt.Graphics;

public class CompositeObject extends ShapeObject {
	private UML_Object[] elements;
	private final int padding = 20;

	public CompositeObject(UML_Object[] elements) {
		this.elements = elements;
		setSelected(true);
		calculatePosition();
	}

	public UML_Object[] getElements() {
		return elements;
	}

	private void calculatePosition() {
		position = new Location[4];
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;

		for (UML_Object i : elements) {
			if (i instanceof ShapeObject) {
				int tempMinX = ((ShapeObject) i).position[0].getX();
				int tempMinY = ((ShapeObject) i).position[0].getY();
				int tempMaxX = ((ShapeObject) i).position[3].getX();
				int tempMaxY = ((ShapeObject) i).position[3].getY();

				minX = Integer.min(minX, tempMinX);
				minY = Integer.min(minY, tempMinY);

				maxX = Integer.max(maxX, tempMaxX);
				maxY = Integer.max(maxY, tempMaxY);
			}
		}

		int maxWidth = Integer.max(maxX - minX, maxY - minY);
		width = maxWidth + padding * 2;
		height = maxWidth + padding * 2;
		super.calculatePosition(new Location(minX - padding, minY - padding));
	}

	@Override
	public void setSelected(boolean selected) {
		super.setSelected(selected);
		for (UML_Object i : elements) {
			i.setSelected(selected);
		}
	}

	@Override
	public void move(int deltaX, int deltaY) {
		super.move(deltaX, deltaY);
		for (UML_Object i : elements) {
			i.move(deltaX, deltaY);
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(position[0].getX(), position[0].getY(), width, height);
		for (UML_Object i : elements) {
			i.draw(g);
		}
	}
}
