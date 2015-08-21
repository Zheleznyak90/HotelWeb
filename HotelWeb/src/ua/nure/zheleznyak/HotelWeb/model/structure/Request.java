package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;
import java.sql.Date;

public class Request implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 404424215980411028L;

	private int id;

	private User client;
	private User manager;
	private int numberOfPerson;
	
	private ApartmentClass aClass;

	private Date created;
	boolean isServed = false;
	
	private Date checkOutDate;
	private Date checkInDate;
	
	public Request(){
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
	 * @return client User object
	 */
	public User getClient() {
		return client;
	}
	/**
	 * Simple setter.
	 * @param User object to set client
	 */
	public void setClient(User client) {
		this.client = client;
	}
	/**
	 * Simple getter.
	 * @return manager User object
	 */
	public User getManager() {
		return manager;
	}
	/**
	 * Simple setter.
	 * @param User object to set manager
	 */
	public void setManager(User manager) {
		this.manager = manager;
	}
	/**
	 * Simple getter.
	 * @return number of person
	 */
	public int getNumberOfPerson() {
		return numberOfPerson;
	}
	/**
	 * Simple setter.
	 * @param number of persons to set numberOfPerson
	 */
	public void setNumberOfPerson(int numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}
	/**
	 * Simple getter.
	 * @return creation date
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * Simple setter.
	 * @param creacted date to set created
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * Simple getter.
	 * @return is served
	 */
	public boolean isServed() {
		return isServed;
	}
	/**
	 * Simple setter.
	 * @param served state to set isServed
	 */
	public void setServed(boolean isServed) {
		this.isServed = isServed;
	}

	/**
	 * Simple getter.
	 * @return ApartmentClass object
	 */
	public ApartmentClass getaClass() {
		return aClass;
	}
	/**
	 * Simple setter.
	 * @param ApartmentClass to set aClass
	 */
	public void setaClass(ApartmentClass aClass) {
		this.aClass = aClass;
	}	/**
	 * Simple getter.
	 * @return checkOutDate
	 */
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	/**
	 * Simple setter.
	 * @param check out date to set checkOutDate
	 */
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	/**
	 * Simple getter.
	 * @return checkInDate
	 */
	public Date getCheckInDate() {
		return checkInDate;
	}
	/**
	 * Simple setter.
	 * @param check in date to set checkInDate
	 */
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	
}
