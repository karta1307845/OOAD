package model;

public class Port {
	private Location position;
	private boolean connected;
	
	public Port(Location position) {
		this.position = position;
		connected = false;
	}
}
