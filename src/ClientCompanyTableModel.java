import database.DbUtils;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ClientCompanyTableModel extends AbstractTableModel {
    String[] columnTitles = { "Id", "Name", "Business", "Contact" };

    List<ClientCompanyItem> dataEntries;

    int rowCount;

    public ClientCompanyTableModel(List<ClientCompanyItem> dataEntries) {
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
            return dataEntries.get(row).getName();
        if (column == 2)
            return dataEntries.get(row).getBusiness();
        if (column == 3)
            return dataEntries.get(row).getContact();

        return "Something went wrong";
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
            dataEntries.get(row).setName(value.toString());

        if (column == 2)
            dataEntries.get(row).setBusiness(value.toString());
        if (column == 3)
            dataEntries.get(row).setContact(value.toString());

        String updateQuery = String.format("update legal set name='%s' where id_client_legal = %x",
                dataEntries.get(row).getName(), dataEntries.get(row).getId());

        String updateQuery2 = String.format("update legal set business='%s' where id_client_legal = %x",
                dataEntries.get(row).getBusiness(), dataEntries.get(row).getId());

        String updateQuery1 = String.format("update legal set contact='%s' where id_client_legal = %x",
                dataEntries.get(row).getContact(), dataEntries.get(row).getId());



        DbUtils.ExecuteQuery(updateQuery);
        DbUtils.ExecuteQuery(updateQuery1);
        DbUtils.ExecuteQuery(updateQuery2);
        Update();

    }

    public void Delete(int row)
    {
        int id = dataEntries.get(row).getId();

        String delQuery = String.format("delete from legal where id_client_legal = %x",id);

        String delQuery1 = String.format("delete from client where id_client = %x",id);

        DbUtils.ExecuteQuery(delQuery);
        DbUtils.ExecuteQuery(delQuery1);


        Update();
    }

    private void Update()
    {
        String query = "select id_client as id, name, business, contact\r\n" +
                "from legal i\r\n" +
                "inner join `client`\r\n" +
                "on `client`.id_client = i.id_client_legal";

        dataEntries = DbUtils.GetMapped(query, ClientCompanyItem.class);
        fireTableDataChanged();
    }
}
