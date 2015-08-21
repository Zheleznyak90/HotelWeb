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

	public Order() {
		meal = new Meal();
		client = new User();
		manager = new User();
		room = new Room();
		status = new OrderStatus();
	}
	/**
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
	 * @return Meal object
	 */
	public Meal getMeal() {
		return meal;
	}
	/**
	 * Simple setter.
	 * @param Meal object to set meal
	 */
	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	/**
	 * Simple getter.
	 * @return Room object
	 */
	public Room getRoom() {
		return room;
	}
	/**
	 * Simple setter.
	 * @param Room object to set room
	 */
	public void setRoom(Room room) {
		this.room = room;
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
	 * @return OrderStatus object
	 */
	public OrderStatus getStatus() {
		return status;
	}
	/**
	 * Simple setter.
	 * @param OrderStatus object to set status
	 */
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	/**
	 * Simple getter.
	 * @return Creation Date
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * Simple setter.
	 * @param cteation date to set creationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
