import java.util.List;

import database.DbUtils;

public class ClientLogic {
	
	public List<PhysicalClientEditModel> getAll() {
		String query = "select id_client as id, phone, surname, sex\r\n" + 
				"from individual i\r\n" + 
				"inner join `client`\r\n" + 
				"on `client`.id_client = i.id_client_individual";
		List<PhysicalClientEditModel> clients = DbUtils.GetMapped(query, PhysicalClientEditModel.class);
		
		return clients;
	}
	
}
