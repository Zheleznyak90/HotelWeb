package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;

public class OrderStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3248828979816163181L;

	private int id;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
