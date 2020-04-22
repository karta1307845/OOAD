package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Rectangle extends ShapeObject {

	public Rectangle(Location start, Location end) {
		width = Math.abs(start.getX() - end.getX());
		height = Math.abs(start.getY() - end.getY());
		int x = start.getX() < end.getX() ? start.getX() : end.getX();
		int y = start.getY() < end.getY() ? start.getY() : end.getY();
		calculatePosition(new Location(x, y));
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.drawRect(position[0].getX(), position[0].getY(), width, height);
	}

	public UML_Object[] selectAllObjects(UML_Object[] objects) {
		List<UML_Object> list = new ArrayList<UML_Object>();

		for (UML_Object i : objects) {
			if (i.isSelected(position[0], position[3])) {
				list.add(i);
			}
		}

		UML_Object[] result = new UML_Object[list.size()];
		result = list.toArray(result);
		return result;
	}

}
