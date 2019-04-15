import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class ResidingMain extends JFrame implements ActionListener
{
	private JPanel panel;
	private JButton services,giveBill;
	private JButton getBack;
	
	public ResidingMain() 
	{
		this.InitializeComponents();
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
	
		this.giveBill = new JButton("Add");
	
		this.panel.add(this.giveBill);
		giveBill.addActionListener(this);
		
		
		this.services = new JButton("Remove");
		services.addActionListener(this);
		
		
		 
		this.giveBill.setBounds(260,80,200,40);
		this.giveBill.setBounds(280,80,200,40);
		
		this.panel.add(this.services);
		this.getBack = new JButton("Return");
		 this.panel.add(this.getBack);
		 this.getBack.addActionListener(this);
	
		
		
		this.add(this.panel);
		this.setSize(200, 200);
		this.setTitle("Residents");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getActionCommand() == "Add")
		{
			
			CalculateBill calculatebill = new CalculateBill();
				calculatebill.setVisible(true);
				this.setVisible(false);
		     
			
		}
		else if(ae.getActionCommand() == "Remove")
		{
			
			AllBills allbills = new AllBills();
				allbills.setVisible(true);
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
