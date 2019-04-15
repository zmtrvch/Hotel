import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class ClientsMain extends JFrame implements ActionListener
{
	private JPanel panel;
	private JButton services,giveBill;
	private JButton getBack;
	
	public ClientsMain() 
	{
		this.InitializeComponents();
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
	
		this.giveBill = new JButton("Physical");
	
		this.panel.add(this.giveBill);
		giveBill.addActionListener(this);
		
		
		this.services = new JButton("Company");
		services.addActionListener(this);
		
		
		 
		this.giveBill.setBounds(260,80,200,40);
		this.giveBill.setBounds(280,80,200,40);
		
		this.panel.add(this.services);
		this.getBack = new JButton("Return");
		 this.panel.add(this.getBack);
		 this.getBack.addActionListener(this);
	
		
		
		this.add(this.panel);
		this.setSize(200, 200);
		this.setTitle("Clients");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getActionCommand() == "Physical")
		{
			
			ClientPhysicalMenu clientphysicalmenu = new ClientPhysicalMenu();
			clientphysicalmenu.setVisible(true);
				this.setVisible(false);
			
		}
		else if(ae.getActionCommand() == "Company")
		{
			
			ClientCompanyMenu clientcompanymenu = new ClientCompanyMenu();
			clientcompanymenu.setVisible(true);
				this.setVisible(false);
		     
			
		}
		
		else if(ae.getActionCommand() == "Return")
			{
			 MainPage mainpage = new MainPage();
				mainpage.setVisible(true);
				this.setVisible(false);
			}
		
	}

}
