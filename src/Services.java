import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//import net.proteanit.sql.DbUtils;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
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
	private JButton buttonok;
	
	public Services()
	{
		this.initializeComponents();
	}
	
	private void initializeComponents() {
		this.panel = new JPanel();
		
		Vector<String> columns = new Vector<String>();
		columns.add("Прізвище");
		columns.add("Дата");
		columns.add("Назва послуги");
		
		//DataConnection data = new DataConnection(); //клас з під'єднанням до бази даний
		//this.tableModel = new DefaultTableModel(data.getAllServices(), columns);
		this.table = new JTable(this.tableModel)
		
		
		{
			public boolean isCellEditable(int row, int column)
			{
				if(column == 0)
					return true;
				else
					return false;
			}
		};
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
	
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane = new JScrollPane(this.table);
		this.panel.add(this.scrollPane);
		
		this.buttonok =new JButton("Повернутись на головну");
		this.buttonok.addActionListener(this);
		this.panel.add(this.buttonok);
		
		
		this.add(this.panel);
		this.setTitle("Архів послуг");
		this.setSize(700, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand() == "Повернутись на головну")
		{
			
			MainPage adminpanel = new MainPage();
				adminpanel.setVisible(true);
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