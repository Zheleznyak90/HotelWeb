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

	private String apartmentClass;
	private Date created;
	boolean isServed = false;
	
	private Date checkOutDate;
	private Date checkInDate;
	
	public Request(){
		aClass = new ApartmentClass();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public ApartmentClass getaClass() {
		return aClass;
	}

	public void setaClass(ApartmentClass aClass) {
		this.aClass = aClass;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	
}
