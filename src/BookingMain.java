import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class BookingMain extends JFrame implements ActionListener
{
	private JPanel panel;
	private JButton services, bills,giveBill;
	private JButton getBack;
	
	public BookingMain() 
	{
		this.InitializeComponents();
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
	
		this.giveBill = new JButton("Додати");
	
		this.panel.add(this.giveBill);
		giveBill.addActionListener(this);
		
		this.bills =  new JButton("Редагувати");
		this.panel.add(this.bills);
		bills.addActionListener(this);
		
		this.services = new JButton("Видалити");
		services.addActionListener(this);
		
		
		 
		this.giveBill.setBounds(260,80,200,40);
		this.giveBill.setBounds(280,80,200,40);
		this.panel.add(this.bills);
		this.panel.add(this.services);
		this.getBack = new JButton("Повернутись");
		 this.panel.add(this.getBack);
		 this.getBack.addActionListener(this);
	
		
		
		this.add(this.panel);
		this.setSize(200, 200);
		this.setTitle("Бронювання");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getActionCommand() == "Додати")
		{
			
			
			
		}
		else if(ae.getActionCommand() == "Редавгувати")
		{
			
			AllBills allbills = new AllBills();
				allbills.setVisible(true);
				this.setVisible(false);
		     
			
		}
		else if(ae.getActionCommand() == "Видалити")
		{
			
			Services mainpage = new Services();
				mainpage.setVisible(true);
				this.setVisible(false);
		     
			
		}
		else if(ae.getActionCommand() == "Повернутись")
			{
			 MainPage mainpage = new MainPage();
				mainpage.setVisible(true);
				this.setVisible(false);
			}
		
	}

}
