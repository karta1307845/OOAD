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

	public boolean isClicked(Location clickPoint) {
		int x = clickPoint.getX();
		int y = clickPoint.getY();

		if (x < position[0].getX() || x > position[1].getX()) {
			return false;
		}

		if (y < position[0].getY() || y > position[2].getY()) {
			return false;
		}

		return true;
	}

	@Override
	public void move(int deltaX, int deltaY) {
		for (int i = 0; i < 4; i++) {
			position[i] = position[i].move(deltaX, deltaY);
		}
	}
}
