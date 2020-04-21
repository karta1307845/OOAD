package model;

import java.awt.Graphics;

public class AssociationLine extends ConnectionLine {

	public AssociationLine(BasicObject startObj, Location start, BasicObject endObj, Location end) {
		super(startObj, start, endObj, end, 10);
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);

		Location arrowPoint1 = new Location(-arrowSize, -arrowSize);
		arrowPoint1 = arrowPoint1.rotate(end, theta);

		Location arrowPoint2 = new Location(-arrowSize, arrowSize);
		arrowPoint2 = arrowPoint2.rotate(end, theta);

		g.drawLine(arrowPoint1.getX(), arrowPoint1.getY(), end.getX(), end.getY());
		g.drawLine(arrowPoint2.getX(), arrowPoint2.getY(), end.getX(), end.getY());
	}
}
