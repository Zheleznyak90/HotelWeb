package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;

public class Meal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9166665027077996500L;

	private int id;

	private String name;
	private double price;
	private String description;
	private boolean active;
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
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Simple setter.
	 * @param meal name to set name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Simple getter.
	 * @return active state
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * Simple setter.
	 * @param bollean activity to set isActive
	 */
	public void setActive(boolean isActive) {
		this.active = isActive;
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

}
