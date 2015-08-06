package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;

public class Meal implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9166665027077996500L;
	
	private String meal;
	private boolean isActive;
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	

}
