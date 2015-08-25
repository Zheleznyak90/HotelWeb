package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;

public class RoomPattern implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3107310774010908147L;
	
	private int id;
	private ApartmentClass aClass;
	
	private double price;
	private int size;
	private String description;
	private String name;
	private static final String PhotoSetDefault = "view/PhotoSets/";
	
	public RoomPattern(){
		aClass = new ApartmentClass();
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
	 * @return AppartmentClass object
	 */
	public ApartmentClass getaClass() {
		return aClass;
	}
	/**
	 * Simple setter.
	 * @param AppartmentClass object to set aClass 
	 */
	public void setaClass(ApartmentClass aClass) {
		this.aClass = aClass;
	}
	/**
	 * Simple getter.
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Simple setter.
	 * @param price to set price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Simple getter.
	 * @return room size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * Simple setter.
	 * @param room size to set size 
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * Simple getter.
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Simple setter.
	 * @param description text to set description 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Simple getter.
	 * @return full path to gallery directory
	 */
	public String getPhotoSetPath() {
		return PhotoSetDefault + name+"/";
	}
	/**
	 * Simple getter.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Simple setter.
	 * @param pattern name to set name 
	 */
	public void setName(String name) {
		this.name = name;
	}

}
