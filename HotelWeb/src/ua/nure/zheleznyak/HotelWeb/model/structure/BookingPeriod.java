package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.io.Serializable;
import java.sql.Date;

public class BookingPeriod implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6485760405654183522L;
	
	private Date checkOutDate;
	private Date checkInDate;
	
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
