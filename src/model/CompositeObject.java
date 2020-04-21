package model;

import java.awt.Graphics;

public class CompositeObject extends ShapeObject {
	private UML_Object[] elements;

	public CompositeObject(UML_Object[] elements) {
		this.elements = elements;
		calculatePosition();
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(position[0].getX(), position[0].getY(), width, height);
	}

	private void calculatePosition() {
		position = new Location[4];
		int minX = 0;
		int minY = 0;
		int maxX = 0;
		int maxY = 0;

		for (UML_Object i : elements) {
			if (i instanceof ShapeObject) {
				int tempMinX = ((ShapeObject) i).position[0].getX();
				int tempMinY = ((ShapeObject) i).position[0].getY();
				int tempMaxX = ((ShapeObject) i).position[3].getX();
				int tempMaxY = ((ShapeObject) i).position[3].getY();

				if (tempMinX < minX) {
					minX = tempMinX;
				}
				if (tempMinY < minY) {
					minY = tempMinY;
				}
				if (tempMaxX > maxX) {
					maxX = tempMaxX;
				}
				if (tempMaxY > maxY) {
					maxY = tempMaxY;
				}
			}
		}

		width = maxX - minX;
		height = maxY - minY;
		super.calculatePosition(new Location(minX, minY));
	}

}
