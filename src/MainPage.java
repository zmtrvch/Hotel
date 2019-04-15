import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class MainPage extends JFrame implements ActionListener
{
	private JPanel panel;
	private JButton services, bills,giveBill;
	
	public MainPage() 
	{
		this.InitializeComponents();
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
	
		this.giveBill = new JButton("Clients");
	
		this.panel.add(this.giveBill);
		giveBill.addActionListener(this);
		
		this.bills =  new JButton("Booking");
		this.panel.add(this.bills);
		bills.addActionListener(this);
		
		this.services = new JButton("Residents");
		services.addActionListener(this);
		
		this.bills =  new JButton("Bill");
		this.panel.add(this.bills);
		bills.addActionListener(this);
		
		this.giveBill.setBounds(260,80,200,40);
		this.giveBill.setBounds(280,80,200,40);
		this.panel.add(this.bills);
		this.panel.add(this.services);
	
		
		
		this.add(this.panel);
		this.setSize(150, 200);
		this.setTitle("Main Menu");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getActionCommand() == "Bill")
		{
			
			BillMain calculatebill = new BillMain();
				calculatebill.setVisible(true);
				this.setVisible(false);
		     
			
		}
		else if(ae.getActionCommand() == "Booking")
		{
			BookingMain bokingbill = new BookingMain();
			bokingbill.setVisible(true);
			this.setVisible(false);
			
		     
			
		}
		else if(ae.getActionCommand() == "Residents")
		{
			ResidingMain residingmain = new ResidingMain();
			residingmain.setVisible(true);
			this.setVisible(false);
		     
			
		}
		else if(ae.getActionCommand() == "Clients")
		{
			ClientsMain clientgmain = new ClientsMain();
			clientgmain.setVisible(true);
			this.setVisible(false);
		     
			
		}
		
	}

}
