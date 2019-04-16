import java.util.List;

import database.DbUtils;

public class RoomLogic {
	
	public List<RoomItem> getAll() {
		String query = "select id_room as id, room_number as roomNumber, room_class as roomClass, "
				+ "people_amount as peopleAmount, floor from room";
		List<RoomItem> rooms = DbUtils.GetMapped(query, RoomItem.class);
		
		return rooms;
	}
	
}
