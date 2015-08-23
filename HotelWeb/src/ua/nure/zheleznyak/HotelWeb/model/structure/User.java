package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4458518908056823189L;

	private int id;
	private String password;
	private String email;
	private String fullName;
	
	private Role userRole;
	private String phoneNumber;
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
	 * @return phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * Simple setter.
	 * @param phone number to set phoneNumber 
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * Simple getter.
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Simple setter.
	 * @param password to set password 
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Simple getter.
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Simple setter.
	 * @param email address to set email 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Simple getter.
	 * @return full name
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * Simple setter.
	 * @param name to set fullName
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * Simple getter.
	 * @return UserRole object
	 */
	public Role getUserRole() {
		return userRole;
	}
	/**
	 * Simple setter.
	 * @param Role object to set userRole 
	 */
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	
	

}
