package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;

public class RoomPattern implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String roomClass;
	private int price;
	private int size;
	private String description;
	private String photoSetPath;
	private static final String PhotoSetDefault = "view/PhotoSets/";
	private float rating;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
		return PhotoSetDefault + photoSetPath;
	}

	public void setPhotoSetPath(String photoSetPath) {
		this.photoSetPath = photoSetPath;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

}
