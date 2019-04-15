import java.awt.*;

import javax.swing.*;

import database.DbUtils;

import java.awt.event.*;

public class ClientPhysical extends JFrame implements ActionListener
{
	private JPanel panel;
	private JButton submit;
	private JButton getBack;
	private JTextField textField;
	private JTextField textField_1;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	
	public ClientPhysical() 
	{
		this.InitializeComponents();
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
			
		this.setBounds(100, 100, 490, 490);
		
		textField = new JTextField();
		textField.setBounds(178, 28, 250, 20);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Surname");
		lblName.setBounds(45, 31, 46, 20);
		this.getContentPane().add(lblName);
		
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(45, 68, 250, 20);
		this.getContentPane().add(lblPhone);
		
		textField_1 = new JTextField();
		textField_1.setBounds(178, 65, 250, 20);
		this.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Email");
		lblEmailId.setBounds(45, 115, 46, 20);
		this.getContentPane().add(lblEmailId);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(45, 234, 46, 14);
		this.getContentPane().add(lblSex);
		
		JLabel lblMale = new JLabel("Male");
		lblMale.setBounds(128, 228, 80, 30);
		this.getContentPane().add(lblMale);
		
		JLabel lblFemale = new JLabel("Female");
		lblFemale.setBounds(292, 228, 46, 30);
		this.getContentPane().add(lblFemale);
		
		radioButton = new JRadioButton("");
		radioButton.setBounds(337, 227, 109, 23);
		this.getContentPane().add(radioButton);
		
		radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(187, 227, 109, 23);
		this.getContentPane().add(radioButton_1);

		
		this.submit = new JButton("Create");
		submit.setBounds(120, 387, 100, 50);
		this.getContentPane().add(submit);
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addNewUser();
				
			}
		});	
		 
		this.getBack = new JButton("Return");
		getBack.setBounds(240, 387, 100, 50);
		this.getContentPane().add(getBack);
		getBack.addActionListener(this);

	
		
		
		this.add(this.panel);
		this.setSize(500, 500);
		this.setTitle("Physical Client");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addNewUser()
	{
		String surName = textField.getText();
		String phone = textField_1.getText();
		
		int male = radioButton_1.isSelected() ? 1 : 0;

		String insertAccount = "insert into `client` (`phone`) values ('" + phone + "')";
		int accountId = DbUtils.insertAndGetId(insertAccount);
		String insertClient = String.format("insert into `individual` values ('%s', '%s', '%s')", accountId, surName, male);
		DbUtils.ExecuteQuery(insertClient);
		
		 ClientsMain clientsmain = new ClientsMain();
		 clientsmain.setVisible(true);
			this.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		
		if(ae.getActionCommand() == "Create")
		{


			
		}
		else if(ae.getActionCommand() == "Return")
		{
			
			 ClientsMain clientsmain = new ClientsMain();
			 clientsmain.setVisible(true);
				this.setVisible(false);
		     
			
		}
		
		
	}

}
