import java.util.List;

import javax.swing.table.AbstractTableModel;

import database.DbUtils;

class ClientPhysicalTableModel extends AbstractTableModel {
	    String[] columnTitles = { "Id", "Phone", "Surname", "Sex" };

	  List<PhysicalClientEditModel> dataEntries;

	  int rowCount;

	  public ClientPhysicalTableModel(List<PhysicalClientEditModel> dataEntries) {
	    this.dataEntries = dataEntries;
	  }

	  public int getRowCount() {
		  int size; 
	      if (dataEntries == null) { 
	         size = 0; 
	      } 
	      else { 
	         size = dataEntries.size(); 
	      } 
	      return size; 
	  }

	  public int getColumnCount() {
	    return columnTitles.length;
	  }

	  public Object getValueAt(int row, int column) {
	    if (column == 0)
	    	return dataEntries.get(row).getId();
	    if (column == 1)
	    	return dataEntries.get(row).getPhone();
	    if (column == 2)
	    	return dataEntries.get(row).getSurname();
	    if (column == 3)
	    	return dataEntries.get(row).getSex();
	    
	    return "Something went wrong";
	  }

	  public Class getColumnClass(int column) {
	    return getValueAt(0, column).getClass();
	  }

	  public boolean isCellEditable(int row, int column) {
	    return true;
	  }
    
	    @Override
	    public String getColumnName(int col) { 
	      return columnTitles[col]; 
	    }     
	    
	  public void setValueAt(Object value, int row, int column) {
		  if (column == 1)
			  dataEntries.get(row).setPhone(value.toString());
		  
		  if (column == 2)
			  dataEntries.get(row).setSurname(value.toString());
		  
		  String updateQuery = String.format("update individual set surname='%s' where id_client_individual = %x", 
				  dataEntries.get(row).getSurname(), dataEntries.get(row).getId());
		  
		  String updateQuery1 = String.format("update client set phone='%s' where id_client = %x", 
				dataEntries.get(row).getPhone(), dataEntries.get(row).getId());
		  
		  DbUtils.ExecuteQuery(updateQuery);
		  DbUtils.ExecuteQuery(updateQuery1);
		  Update();
	  
	  }
	  
	  public void Delete(int row)
	  {
		 int id = dataEntries.get(row).getId();
		 
		 String delQuery = String.format("delete from individual where id_client_individual = %x", 
				  id);
		 
		 String delQuery1 = String.format("delete from client where id_client = %x", 
				  id);
		 
		  DbUtils.ExecuteQuery(delQuery);
		  DbUtils.ExecuteQuery(delQuery1);

		 
		 Update();
	  }
	  
	  private void Update()
	  {
		  String query = "select id_client as id, phone, surname, sex\r\n" + 
					"from individual i\r\n" + 
					"inner join `client`\r\n" + 
					"on `client`.id_client = i.id_client_individual";
			
		  dataEntries = DbUtils.GetMapped(query, PhysicalClientEditModel.class);
		  fireTableDataChanged();
	  }
}