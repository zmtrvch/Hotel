import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class ClientPhysicalMenu extends JFrame implements ActionListener
{
	private JPanel panel;
	private JButton services,giveBill;
	private JButton getBack;
	
	public ClientPhysicalMenu() 
	{
		this.InitializeComponents();
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
	
		this.giveBill = new JButton("Створити");
	
		this.panel.add(this.giveBill);
		giveBill.addActionListener(this);
		
		
		this.services = new JButton("Редагувати");
		services.addActionListener(this);
		
		
		 
		this.giveBill.setBounds(260,80,200,40);
		this.giveBill.setBounds(280,80,200,40);
		
		this.panel.add(this.services);
		this.getBack = new JButton("Повернутись");
		 this.panel.add(this.getBack);
		 this.getBack.addActionListener(this);
	
		
		
		this.add(this.panel);
		this.setSize(200, 200);
		this.setTitle("Меню");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getActionCommand() == "Створити")
		{
			
			ClientPhysical clientphysical = new ClientPhysical();
			clientphysical.setVisible(true);
			this.setVisible(false);
			
		}
		else if(ae.getActionCommand() == "Редагувати")
		{
			

		     
			
		}
		
		else if(ae.getActionCommand() == "Повернутись")
			{
			 ClientsMain clientsmain = new ClientsMain();
			 clientsmain.setVisible(true);
				this.setVisible(false);
			}
		
	}

}
