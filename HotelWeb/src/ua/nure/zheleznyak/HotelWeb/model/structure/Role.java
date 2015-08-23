package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;

public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8721951264569442789L;

	private int id;
	private String role;

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
	 * @return role name
	 */
	public String getRole() {
		return role;
	}
	/**
	 * Simple setter.
	 * @param role name to role
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
