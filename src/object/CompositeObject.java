package object;

import java.awt.Color;
import java.awt.Graphics;

import model.Location;

public class CompositeObject extends ShapeObject {
	private ShapeObject[] elements;
	private final int padding = 20;

	public CompositeObject(ShapeObject[] elements) {
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

		for (ShapeObject i : elements) {
			int tempMinX = i.position[0].getX();
			int tempMinY = i.position[0].getY();
			int tempMaxX = i.position[3].getX();
			int tempMaxY = i.position[3].getY();

			minX = Integer.min(minX, tempMinX);
			minY = Integer.min(minY, tempMinY);

			maxX = Integer.max(maxX, tempMaxX);
			maxY = Integer.max(maxY, tempMaxY);
		}

		int maxWidth = Integer.max(maxX - minX, maxY - minY);
		width = maxWidth + padding * 2;
		height = maxWidth + padding * 2;
		super.calculatePosition(new Location(minX - padding, minY - padding));
	}

	@Override
	public void setSelected(boolean selected) {
		super.setSelected(selected);
		for (ShapeObject i : elements) {
			i.setSelected(selected);
		}
	}

	@Override
	public void move(int deltaX, int deltaY) {
		super.move(deltaX, deltaY);
		for (ShapeObject i : elements) {
			i.move(deltaX, deltaY);
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(position[0].getX(), position[0].getY(), width, height);
		for (ShapeObject i : elements) {
			i.draw(g);
		}
	}
}
