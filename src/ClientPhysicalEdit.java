import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import database.DbUtils;

public class ClientPhysicalEdit extends JFrame implements ActionListener{
	
	public ClientPhysicalEdit() 
	{
		this.InitializeComponents();
	}
	
	private void InitializeComponents() {
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    
		String query = "select id_client as id, phone, surname, sex\r\n" + 
				"from individual i\r\n" + 
				"inner join `client`\r\n" + 
				"on `client`.id_client = i.id_client_individual";
		
		List<PhysicalClientEditModel> items = DbUtils.GetMapped(query, PhysicalClientEditModel.class);
		PhysicalClientEditModel[] arr = items.toArray(new PhysicalClientEditModel[items.size()]);
		ClientPhysicalTableModel model = new ClientPhysicalTableModel(items);
	    JTable table = new JTable(model);
	    table.createDefaultColumnsFromModel();

	    JButton jb = new JButton("Delete");
	    jb.setBounds(50, 107, 100, 50);
		this.getContentPane().add(jb);
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				model.Delete(row);
				
			}
		});
		
	    JButton hb2 = new JButton("Return");
	    hb2.setBounds(200, 107, 100, 50);
		this.getContentPane().add(hb2);
		hb2.addActionListener(this);
		
		
	    this.add(jb);
	    
	    this.add(new JScrollPane(table));

	    this.setSize(300, 200); 
	    this.setVisible(true);
	  }
	
	public void actionPerformed(ActionEvent ae) 
	{
		
		if(ae.getActionCommand() == "Return")
		{
			
			 ClientsMain clientsmain = new ClientsMain();
			 clientsmain.setVisible(true);
				this.setVisible(false);
			
		}
		
		
	}

}

