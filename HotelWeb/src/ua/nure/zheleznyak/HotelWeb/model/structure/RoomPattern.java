package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;

public class RoomPattern implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private ApartmentClass aClass;
	
	private double price;
	private int size;
	private String description;
	private String name;
	private static final String PhotoSetDefault = "view/PhotoSets/";
	private float rating;
	
	public RoomPattern(){
		aClass = new ApartmentClass();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public ApartmentClass getaClass() {
		return aClass;
	}

	public void setaClass(ApartmentClass aClass) {
		this.aClass = aClass;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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
		return PhotoSetDefault + name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

}
