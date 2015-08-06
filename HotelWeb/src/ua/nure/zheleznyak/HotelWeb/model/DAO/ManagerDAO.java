package ua.nure.zheleznyak.HotelWeb.model.DAO;

public interface ManagerDAO {
	public boolean showAllBookingRequests();
	public boolean showClientRequests();
	public boolean offerRoom(int roomId);
	public boolean confirmBooking(int roomId, int clientId);
	public boolean confirmBookingCancel();
	public boolean showStat();
}
