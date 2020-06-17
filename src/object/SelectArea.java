package object;

import java.awt.Color;
import java.awt.Graphics;

import model.Location;

public class SelectArea extends ShapeObject {

	public SelectArea(Location start, Location end) {
		width = Math.abs(start.getX() - end.getX());
		height = Math.abs(start.getY() - end.getY());
		int x = start.getX() < end.getX() ? start.getX() : end.getX();
		int y = start.getY() < end.getY() ? start.getY() : end.getY();
		calculatePosition(new Location(x, y));
	}

	@Override
	public void setDepth(int depth) {
		super.setDepth(99);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.drawRect(position[0].getX(), position[0].getY(), width, height);
	}

	public void selectAllObjects(UML_Object[] objects) {
		for (UML_Object i : objects) {
			if (i.isInsideSelectArea(this)) {
				i.setSelected(true);
			}
		}
	}

}
