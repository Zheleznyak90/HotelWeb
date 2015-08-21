package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;
import java.sql.Date;

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
	private OrderStatus status;
	private Date creationDate;

	private Date checkOutDate;
	private Date checkInDate;

	public Order (){
		meal = new Meal();
		client = new User();
		manager = new User();
		room = new Room();
		status = new OrderStatus();
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
