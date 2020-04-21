package model;

import java.awt.Color;
import java.awt.Graphics;

import view.Canvas;

public class ClassObject extends BasicObject {

	public ClassObject(String name, Location position) {
		super(name, position, 70, 80);
	}

	public ClassObject(Location position) {
		this("", position);
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		int x = position[0].getX();
		int y = position[0].getY();

		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
		g.setColor(new Color(Canvas.objectColor));
		g.fillRect(x + 1, y + 1, width - 1, height - 1);
		g.setColor(Color.black);
		g.drawLine(x, y + height / 3, x + width, y + height / 3);
		g.drawLine(x, y + 2 * height / 3, x + width, y + 2 * height / 3);
	}

}
