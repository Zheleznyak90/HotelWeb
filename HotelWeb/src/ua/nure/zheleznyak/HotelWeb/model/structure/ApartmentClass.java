package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;

public class ApartmentClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4922270488948672230L;

	private int id;
	private String aClass;
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
	 * @return apartmentClass
	 */
	public String getaClass() {
		return aClass;
	}
	/**
	 * Simple setter.
	 * @param appartmant name to set aClass
	 */
	public void setaClass(String aClass) {
		this.aClass = aClass;
	}

}
