package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;

public class Room implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2036673802378064539L;

	private int id;
	private RoomPattern pattern;
	private int floor;
	private int number;
	private boolean maintained;
	
	public Room(){
		pattern = new RoomPattern();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public RoomPattern getPattern() {
		return pattern;
	}

	public void setPattern(RoomPattern pattern) {
		this.pattern = pattern;
	}

	public boolean isMaintained() {
		return maintained;
	}

	public void setMaintained(boolean maintained) {
		this.maintained = maintained;
	}


}
