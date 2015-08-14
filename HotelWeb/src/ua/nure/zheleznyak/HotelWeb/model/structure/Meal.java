package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;

public class Meal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9166665027077996500L;

	private int id;

	private String meal;
	private double price;
	private String description;
	private boolean active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean isActive) {
		this.active = isActive;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
