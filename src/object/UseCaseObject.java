package object;

import java.awt.Color;
import java.awt.Graphics;

import model.Location;
import view.Canvas;

public class UseCaseObject extends BasicObject {

	public UseCaseObject(String name, Location position) {
		super(name, position, 100, 60);
	}

	public UseCaseObject(Location position) {
		this("", position);
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		int x = position[0].getX();
		int y = position[0].getY();

		g.setColor(new Color(Canvas.objectColor));
		g.fillOval(x, y, width, height);
		g.setColor(Color.black);
		g.drawOval(x, y, width, height);
		g.drawString(name, x + 30, y + 32);
	}
}
