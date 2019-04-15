import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class ClientCompany extends JFrame implements ActionListener
{
	private JPanel panel;
	private JButton submit;
	private JButton getBack;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	public ClientCompany() 
	{
		this.InitializeComponents();
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
			
		this.setBounds(100, 100, 490, 490);
		
		textField = new JTextField();
		textField.setBounds(200, 28, 250, 20);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Company");
		lblName.setBounds(45, 31, 250, 20);
		this.getContentPane().add(lblName);
		
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(45, 68, 250, 20);
		this.getContentPane().add(lblPhone);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 65, 250, 20);
		this.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Contact");
		lblEmailId.setBounds(45, 115, 250, 20);
		this.getContentPane().add(lblEmailId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(200, 112, 250, 20);
		this.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblBusinessId = new JLabel("Business");
		lblBusinessId.setBounds(45, 170, 250, 20);
		this.getContentPane().add(lblBusinessId);
		
		textField_3 = new JTextField();
		textField_3.setBounds(200, 170, 250, 20);
		this.getContentPane().add(textField_3);
		textField_3.setColumns(10);
			
		
;
		
		
		
		this.submit = new JButton("Create");
		submit.setBounds(120, 387, 100, 50);
		this.getContentPane().add(submit);
		submit.addActionListener(this);
		
		
		 
		this.getBack = new JButton("Return");
		getBack.setBounds(240, 387, 100, 50);
		this.getContentPane().add(getBack);
		getBack.addActionListener(this);

	
		
		
		this.add(this.panel);
		this.setSize(500, 500);
		this.setTitle("Business Client");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
