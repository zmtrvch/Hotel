import java.util.Date;

import database.DbUtils;

public class BookingLogic {
	
	public BookingLogic() {
		
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
		String query = "update `booking` set `id_client` = " + clientId + ", `id_room` = " + roomId
				+ ", book_date = '" + getDateString(bookDate) + "'" 
				+ ", check_in_date = '" + getDateString(checkInDate) + "'"
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
