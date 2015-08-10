package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -902762891337612017L;

	private int id;

	private Meal meal;
	private Room room;
	private User client;
	private User manager;
	private String status;

	private BookingPeriod period;
	private Date creationDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BookingPeriod getPeriod() {
		return period;
	}

	public void setPeriod(BookingPeriod period) {
		this.period = period;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
