package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;
import java.sql.Date;

public class Request implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 404424215980411028L;
	
	private User client;
	private User manager;
	private int numberOfPerson;
	
	private String apartmentClass;
	private Date checkIn;
	private Date checkOut;
	private Date created;
	
	boolean isServed = false;
	
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
	public User getManager() {
		return manager;
	}
	public void setManager(User manager) {
		this.manager = manager;
	}
	public int getNumberOfPerson() {
		return numberOfPerson;
	}
	public void setNumberOfPerson(int numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public boolean isServed() {
		return isServed;
	}
	public void setServed(boolean isServed) {
		this.isServed = isServed;
	}
	public String getApartmentClass() {
		return apartmentClass;
	}
	public void setApartmentClass(String apartmentClass) {
		this.apartmentClass = apartmentClass;
	}

}
