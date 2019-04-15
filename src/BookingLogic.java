import java.util.Date;

import database.DbUtils;

public class BookingLogic {
	
	public BookingLogic() {
		
	}
	
	public int addBooking(int clientId, int roomId, 
			Date bookDate, Date checkInDate, int duration) {
		String query = "insert into `booking` (`id_client`, `id_room`, `book_date`, `check_in_date`, `duration`) values ("
				+ clientId + ", " + roomId + ", "
				+ "'" + new java.sql.Date(bookDate.getTime()) + ' ' + new java.sql.Time(bookDate.getTime()) + "', "
				+ "'" + new java.sql.Date(checkInDate.getTime()) + ' ' + new java.sql.Time(checkInDate.getTime()) + "', "
				+ duration + ")";
		int insertedId = DbUtils.insertAndGetId(query);
		
		return insertedId;
	}
	
}
