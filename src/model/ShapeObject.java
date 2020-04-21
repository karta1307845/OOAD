package model;

public abstract class ShapeObject extends UML_Object {
	protected Location[] position;
	protected int width;
	protected int height;

	protected void calculatePosition(Location upperLeft) {
		position = new Location[4];
		position[0] = upperLeft;
		position[1] = upperLeft.move(width, 0);
		position[2] = upperLeft.move(0, height);
		position[3] = upperLeft.move(width, height);
	}
}
