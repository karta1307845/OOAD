package model;

import java.awt.Color;
import java.awt.Graphics;

public class CompositionLine extends ConnectionLine {

	public CompositionLine(BasicObject startObj, Location start, BasicObject endObj, Location end) {
		super(startObj, start, endObj, end, 10);
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);

		Location arrowPoint1 = new Location(-arrowSize, -arrowSize / 2);
		arrowPoint1 = arrowPoint1.rotate(end, theta);

		Location arrowPoint2 = new Location(-arrowSize, arrowSize / 2);
		arrowPoint2 = arrowPoint2.rotate(end, theta);

		Location arrowPoint3 = new Location(-arrowSize * 2, 0);
		arrowPoint3 = arrowPoint3.rotate(end, theta);

		int[] xAry = new int[] { end.getX(), arrowPoint1.getX(), arrowPoint3.getX(), arrowPoint2.getX() };
		int[] yAry = new int[] { end.getY(), arrowPoint1.getY(), arrowPoint3.getY(), arrowPoint2.getY() };

		g.setColor(Color.white);
		g.fillPolygon(xAry, yAry, 4);
		g.setColor(Color.black);
		g.drawLine(arrowPoint1.getX(), arrowPoint1.getY(), end.getX(), end.getY());
		g.drawLine(arrowPoint2.getX(), arrowPoint2.getY(), end.getX(), end.getY());
		g.drawLine(arrowPoint1.getX(), arrowPoint1.getY(), arrowPoint3.getX(), arrowPoint3.getY());
		g.drawLine(arrowPoint2.getX(), arrowPoint2.getY(), arrowPoint3.getX(), arrowPoint3.getY());
	}
}
