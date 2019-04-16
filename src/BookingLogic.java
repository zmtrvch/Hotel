import java.util.Date;
import java.util.List;

import database.DbUtils;

public class BookingLogic {
	
	public BookingLogic() {
		
	}
	
	List<BookingItem> getAll() {
		String query = "select id_booking as id, b.id_client as clientId, b.id_room as roomId, "
				+ "book_date as bookDate, check_in_date as checkInDate, duration, "
				+ "cancel_date as cancelDate, cancel_reason as cancelReason, phone "
				+ "as clientPhone, room_number as roomNumber from booking b "
				+ "inner join client c on b.id_client = c.id_client "
				+ "inner join room r on b.id_room = r.id_room";
		List<BookingItem> bookings = DbUtils.GetMapped(query, BookingItem.class);
		
		return bookings;
	}
	
	public int addBooking(int clientId, int roomId, 
			Date bookDate, Date checkInDate, int duration) {
		String query = "insert into `booking` (`id_client`, `id_room`, `book_date`, `check_in_date`, `duration`) values ("
				+ clientId + ", " + roomId + ", " + "'" + getDateString(bookDate) + "', " + "'" + getDateString(checkInDate) 
				+ "', " + duration + ")";
		int insertedId = DbUtils.insertAndGetId(query);
		
		return insertedId;
	}
	
	public void updateBooking(int bookingId, int clientId, int roomId, Date bookDate, 
			Date checkInDate, int duration, Date cancelDate, String cancelReason) {
		String query = "update `booking` set `id_client` = " + clientId
				+ ", `id_room` = " + roomId + ", book_date = '" 
				+ getDateString(bookDate) + "'" + ", check_in_date = '" + getDateString(checkInDate) + "'"
				+ ", duration = " + duration + ", cancel_date = '" + getDateString(cancelDate) + "'"
				+ ", cancel_reason = '" + cancelReason + "'" + " where id_booking = " + bookingId;
		DbUtils.ExecuteQuery(query);
	}
	
	public void deleteBooking(int bookingId) {
		String query = "delete from `booking` where `id_booking` = " + bookingId;
		DbUtils.ExecuteQuery(query);
	}
	
	private String getDateString(Date date) {
		return new java.sql.Date(date.getTime()).toString() + ' ' + new java.sql.Time(date.getTime());
	}
	
}
