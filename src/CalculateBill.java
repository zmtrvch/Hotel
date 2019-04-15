import java.awt.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.event.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class CalculateBill extends JFrame implements ActionListener, ItemListener
{
	private JPanel panel;
	private JLabel surname;
	private JDateChooser chooser;
	private JButton getRes;
	//private DataConnection dc;
	private JComboBox comboboxSurname;
	private JButton getBack;
	
	public CalculateBill() 
	{
		this.InitializeComponents();
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
		
		//DataConnection dc = new DataConnection(); //клас з під'єднанням до бази даний
		//this.dc = dc;
		this.setTitle("Розрахувати гостя");
		
		
	    this.surname = new JLabel("Прізвище");
	    this.panel.add(this.surname);
	    
	    //this.comboboxSurname = new JComboBox(dc.getRoomNumber());
		this.comboboxSurname.setBounds(250, 200, 100, 20);
		this.comboboxSurname.addItemListener((ItemListener) this);
		this.comboboxSurname.addItemListener(this);
		this.panel.add(this.comboboxSurname);
	  
       
		this.chooser = new JDateChooser();
		this.chooser.setLocale(Locale.US);
		this.chooser.setDateFormatString("yyyy-MM-dd");
		this.panel.add(this.chooser);
		

		
		this.panel.add(new JLabel("Оберіть дату:"));
		panel.add(chooser);
		
		
		this.getRes = new JButton("Отримати рахунок");
		 this.panel.add(this.getRes);
		 getRes.addActionListener(this);
		 this.getBack = new JButton("Повернутись");
		 this.panel.add(this.getBack);
		 this.getBack.addActionListener(this);
		
		this.add(this.panel);
		this.setSize(250, 300);
		this.setTitle("Отримання рахунку");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		
		
	 if(ae.getActionCommand() == "Повернутись")
		{
		 MainPage addroom = new MainPage();
			addroom.setVisible(true);
			this.setVisible(false);
		}
	
	 else if(ae.getActionCommand() == "Отримати рахунок")
			{
		 
		        // занеення інформації в базу, після створення екземпляру класу GiveBill - вікно, де буде виводитись інформація про надений рахунок
				/*String surname = (String) this.comboboxSurname.getSelectedItem();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String date = df.format(chooser.getDate());
				
				BillsData BillData = new BillsData();
				BillData.setResident(surname);
				BillData.setDate(date);
				
				if(dc.InsertBill(BillData,surname) == true)
				{
					GiveCurrentBill bill = new GiveCurrentBill(); 
					bill.setVisible(true);
				     this.setVisible(false); 
			    }
				else 
				{
					JOptionPane.showMessageDialog(null, "Оберіть прізвище та дату!");
				}*/
			}
	 
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
