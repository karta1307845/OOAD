package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Rectangle extends UML_Object {
	private Location[] position;
	private int width;
	private int height;

	public Rectangle(Location start, Location end) {
		int x = start.getX() < end.getX() ? start.getX() : end.getX();
		int y = start.getY() < end.getY() ? start.getY() : end.getY();
		width = Math.abs(start.getX() - end.getX());
		height = Math.abs(start.getY() - end.getY());
		position = new Location[4];
		position[0] = new Location(x, y);
		position[1] = new Location(x + width, y);
		position[2] = new Location(x, y + height);
		position[3] = new Location(x + width, y + height);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.drawRect(position[0].getX(), position[0].getY(), width, height);
	}

	public BasicObject[] selectAllBasicObjects(UML_Object[] objects) {
		List<BasicObject> list = new ArrayList<BasicObject>();
		int minX = position[0].getX();
		int maxX = position[3].getX();
		int minY = position[0].getY();
		int maxY = position[3].getY();

		for (UML_Object i : objects) {
			if (i instanceof BasicObject) {
				boolean inRectangle = true;
				for (Location point : ((BasicObject) i).position) {
					int x = point.getX();
					int y = point.getY();
					if (x < minX || x > maxX || y < minY || y > maxY) {
						inRectangle = false;
						break;
					}
				}
				if (inRectangle) {
					list.add((BasicObject) i);
				}
			}
		}

		BasicObject[] result = new BasicObject[list.size()];
		return list.toArray(result);
	}

}
