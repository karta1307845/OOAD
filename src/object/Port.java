package object;

import model.Location;

public class Port {
	private Location location;
	private BasicObject parent;
	
	public Port(Location location, BasicObject parent) {
		this.location = location;
		this.parent = parent;
	}
	
	public void move(int deltaX, int deltaY) {
		location = location.move(deltaX, deltaY);
	}
	
	public int getX() {
		return location.getX();
	}
	
	public int getY() {
		return location.getY();
	}
	
	public Location getLocation() {
		return location;
	}
	
	public BasicObject getParent() {
		return parent;
	}
}
