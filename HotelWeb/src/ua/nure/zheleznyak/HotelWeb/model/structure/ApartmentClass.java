package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;

public class ApartmentClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4922270488948672230L;

	private int id;
	private String aClass;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getaClass() {
		return aClass;
	}

	public void setaClass(String aClass) {
		this.aClass = aClass;
	}

}
