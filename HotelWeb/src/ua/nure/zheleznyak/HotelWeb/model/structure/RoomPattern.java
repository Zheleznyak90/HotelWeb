package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;

public class RoomPattern implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String roomClass;
	private int price;
	private int size;
	private String description;
	private String photoSetPath;
	
	public String getRoomClass() {
		return roomClass;
	}
	public void setRoomClass(String roomClass) {
		this.roomClass = roomClass;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhotoSetPath() {
		return photoSetPath;
	}
	public void setPhotoSetPath(String photoSetPath) {
		this.photoSetPath = photoSetPath;
	}

}
