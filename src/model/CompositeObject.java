package model;

import java.awt.Color;
import java.awt.Graphics;

public class CompositeObject extends ShapeObject {
	private ShapeObject[] elements;
	private ConnectionLine[] lines;
	private final int padding = 20;

	public CompositeObject(ShapeObject[] elements, ConnectionLine[] lines) {
		this.elements = elements;
		this.lines = lines;
		setSelected(true);
		calculatePosition();
	}

	public ShapeObject[] getElements() {
		return elements;
	}

	public ConnectionLine[] getLines() {
		return lines;
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
			for (ConnectionLine j : lines) {
				if (i.equals(j.getStartObj())) {
					j.moveStart(deltaX, deltaY);
				}
				if (i.equals(j.getEndObj())) {
					j.moveEnd(deltaX, deltaY);
				}
			}
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
