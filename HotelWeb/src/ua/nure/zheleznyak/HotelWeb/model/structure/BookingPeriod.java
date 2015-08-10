package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;
import java.sql.Date;

public class BookingPeriod implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6485760405654183522L;

	private int id;

	private Date checkOutDate;
	private Date checkInDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
