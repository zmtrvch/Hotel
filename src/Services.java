import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Vector;

public class Services extends JFrame implements ActionListener, KeyListener
{
	
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JButton buttonok, getBack;
	
	public Services()
	{
		this.initializeComponents();
	}
	
	private void initializeComponents() {
		this.panel = new JPanel();
		
		Vector<String> columns = new Vector<String>();
		columns.add("Surname");
		columns.add("Data");
		columns.add("Service Name");
		
		String[] columnNames = { "Surname", "Data", "Service Name" }; 
		String[][] data = { 
	            { "Sen Betan", "01-01-2019", "SPA" }, 
	            { "Emma Gret", "02-01-2019", "Laundry" }, 
	            { "David Kelly", "02-01-2019", "Laundry" }, 
	            { "Alive Willy", "04-01-2019", "Dinner" }, 
	        }; 
		this.tableModel = new DefaultTableModel(data, columnNames);
		this.table = new JTable(this.tableModel);
		
		
		//DataConnection data = new DataConnection(); 
		//this.tableModel = new DefaultTableModel(data.getAllServices(), columns);
		//this.table = new JTable(this.tableModel)
		
		/*
		{
			public boolean isCellEditable(int row, int column)
			{
				if(column == 0)
					return true;
				else
					return false;
			}
		};*/
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
	
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane = new JScrollPane(this.table);
		this.panel.add(this.scrollPane);
		
		this.getBack = new JButton("Return");
		 this.panel.add(this.getBack);
		 this.getBack.addActionListener(this);
		
		this.add(this.panel);
		this.setTitle("Services Archive");
		this.setSize(700, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{

		if(ae.getActionCommand() == "Return")
		{
			 MainPage mainpage = new MainPage();
				mainpage.setVisible(true);
				this.setVisible(false);
			}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	


}
