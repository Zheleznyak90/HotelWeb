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
	/**
	 * Simple getter.
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Simple setter.
	 * @param id to set id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Simple getter.
	 * @return floor
	 */
	public int getFloor() {
		return floor;
	}
	/**
	 * Simple setter.
	 * @param floor to set floor 
	 */
	public void setFloor(int floor) {
		this.floor = floor;
	}
	/**
	 * Simple getter.
	 * @return appartment number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * Simple setter.
	 * @param appartment number to set number
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * Simple getter.
	 * @return RoomPattern object
	 */
	public RoomPattern getPattern() {
		return pattern;
	}
	/**
	 * Simple setter.
	 * @param RoomPattern object to set pattern 
	 */
	public void setPattern(RoomPattern pattern) {
		this.pattern = pattern;
	}
	/**
	 * Simple getter.
	 * @return maintained
	 */
	public boolean isMaintained() {
		return maintained;
	}
	/**
	 * Simple setter.
	 * @param maintaince state to set maintained 
	 */
	public void setMaintained(boolean maintained) {
		this.maintained = maintained;
	}


}
