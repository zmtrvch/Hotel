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
	
		this.giveBill = new JButton("Клієнти");
	
		this.panel.add(this.giveBill);
		giveBill.addActionListener(this);
		
		this.bills =  new JButton("Бронювання");
		this.panel.add(this.bills);
		bills.addActionListener(this);
		
		this.services = new JButton("Проживаючі");
		services.addActionListener(this);
		
		this.bills =  new JButton("Рахунок");
		this.panel.add(this.bills);
		bills.addActionListener(this);
		
		this.giveBill.setBounds(260,80,200,40);
		this.giveBill.setBounds(280,80,200,40);
		this.panel.add(this.bills);
		this.panel.add(this.services);
	
		
		
		this.add(this.panel);
		this.setSize(200, 200);
		this.setTitle("Головна сторінка");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getActionCommand() == "Рахунок")
		{
			
			BillMain calculatebill = new BillMain();
				calculatebill.setVisible(true);
				this.setVisible(false);
		     
			
		}
		else if(ae.getActionCommand() == "Бронювання")
		{
			BookingMain bokingbill = new BookingMain();
			bokingbill.setVisible(true);
			this.setVisible(false);
			
		     
			
		}
		else if(ae.getActionCommand() == "Проживаючі")
		{
			ResidingMain residingmain = new ResidingMain();
			residingmain.setVisible(true);
			this.setVisible(false);
		     
			
		}
		else if(ae.getActionCommand() == "Клієнти")
		{
			ClientsMain clientgmain = new ClientsMain();
			clientgmain.setVisible(true);
			this.setVisible(false);
		     
			
		}
		
	}

}
