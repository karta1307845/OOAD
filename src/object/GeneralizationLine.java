package object;

import java.awt.Color;
import java.awt.Graphics;

import model.Location;

public class GeneralizationLine extends ConnectionLine {

	public GeneralizationLine(Port start, Port end) {
		super(start, end, 10);
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);

		Location arrowPoint1 = new Location(-arrowSize, -arrowSize);
		arrowPoint1 = arrowPoint1.rotate(end.getLocation(), theta);

		Location arrowPoint2 = new Location(-arrowSize, arrowSize);
		arrowPoint2 = arrowPoint2.rotate(end.getLocation(), theta);

		int[] xAry = new int[] { end.getX(), arrowPoint1.getX(), arrowPoint2.getX() };
		int[] yAry = new int[] { end.getY(), arrowPoint1.getY(), arrowPoint2.getY() };

		g.setColor(Color.white);
		g.fillPolygon(xAry, yAry, 3);
		g.setColor(Color.black);
		g.drawLine(arrowPoint1.getX(), arrowPoint1.getY(), end.getX(), end.getY());
		g.drawLine(arrowPoint2.getX(), arrowPoint2.getY(), end.getX(), end.getY());
		g.drawLine(arrowPoint1.getX(), arrowPoint1.getY(), arrowPoint2.getX(), arrowPoint2.getY());
	}
}
