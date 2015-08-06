package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;

public class Room implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2036673802378064539L;
	
	private RoomPattern pattern;
	private int floor;
	private int number;
	private String status;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public RoomPattern getPattern() {
		return pattern;
	}
	public void setPattern(RoomPattern pattern) {
		this.pattern = pattern;
	}
	
}
