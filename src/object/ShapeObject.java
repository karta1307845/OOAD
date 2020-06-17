package object;

import model.Location;

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

	@Override
	public boolean getSelected() {
		return selected;
	}
	
	@Override
	public Location[] getPosition() {
		return position;
	}

	@Override
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

	@Override
	protected boolean isInsideSelectArea(SelectArea area) {
		Location upperLeft = area.position[0];
		Location bottomRight = area.position[3];
		for (Location point : position) {
			int x = point.getX();
			int y = point.getY();
			if (x < upperLeft.getX() || x > bottomRight.getX() || y < upperLeft.getY() || y > bottomRight.getY()) {
				return false;
			}
		}
		return true;
	}
}
