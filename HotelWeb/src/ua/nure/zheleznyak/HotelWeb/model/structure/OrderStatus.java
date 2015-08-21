package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;

public class OrderStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3248828979816163181L;

	private int id;
	private String status;
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
	 * @return status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * Simple setter.
	 * @param status name to set status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
