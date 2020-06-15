package object;

import java.util.ArrayList;
import java.util.List;

import model.Location;

public class Port {
	private Location location;
	private BasicObject parent;
	private List<ConnectionLine> lines;
	
	public Port(Location location, BasicObject parent) {
		this.location = location;
		this.parent = parent;
		lines = new ArrayList<ConnectionLine>();
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
