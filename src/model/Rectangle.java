package model;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends UML_Object {
	private Location[] position;
	private int width;
	private int height;
	private Location start;
	private Location end;

	public Rectangle(Location start, Location end) {
		int x = start.getX() < end.getX() ? start.getX() : end.getX();
		int y = start.getY() < end.getY() ? start.getY() : end.getY();
		width = Math.abs(start.getX() - end.getX());
		height = Math.abs(start.getY() - end.getY());
		position = new Location[4];
		position[0]=new Location(x,y);
		position[0]=new Location(x,y);
		position[0]=new Location(x,y);
		position[0]=new Location(x,y);
		this.start = start;
		this.end = end;
	}

	@Override
	public void draw(Graphics g) {
		int x = start.getX() < end.getX() ? start.getX() : end.getX();
		int y = start.getY() < end.getY() ? start.getY() : end.getY();
		int width = Math.abs(start.getX() - end.getX());
		int height = Math.abs(start.getY() - end.getY());

		g.setColor(Color.blue);
		g.drawRect(x, y, width, height);
	}
	
	public BasicObject[] getSelectedBasicObjects(UML_Object[] objects) {
		for(UML_Object i:objects) {
			if(i instanceof BasicObject) {
				
			}
		}
	}

}
