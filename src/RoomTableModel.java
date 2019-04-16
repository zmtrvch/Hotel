import java.util.List;

import javax.swing.table.AbstractTableModel;

class RoomTableModel extends AbstractTableModel {
	
	private String[] columnTitles = { "Room number", "Room class", "People amount", "Floor" };
	private List<RoomItem> dataEntries;

	public RoomTableModel(List<RoomItem> dataEntries) {
	    this.dataEntries = dataEntries;
	  }

	public int getRowCount() {
		int size;
		if (dataEntries == null) {
			size = 0;
		} else {
			size = dataEntries.size();
		}
		return size;
	}

	public int getColumnCount() {
		return columnTitles.length;
	}

	public Object getValueAt(int row, int column) {
		if (column == 0)
			return dataEntries.get(row).getRoomNumber();
		if (column == 1)
			return dataEntries.get(row).getRoomClass();
		if (column == 2)
			return dataEntries.get(row).getPeopleAmount();
		if (column == 3)
			return dataEntries.get(row).getFloor();

		return "Something went wrong";
	}

	public Class getColumnClass(int column) {
		return getValueAt(0, column).getClass();
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public String getColumnName(int col) {
		return columnTitles[col];
	}
	
	public RoomItem getItem(int row) {
		return dataEntries.get(row);
	}
	
}