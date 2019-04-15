import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class ClientPhysical extends JFrame implements ActionListener
{
	private JPanel panel;
	private JButton submit;
	private JButton getBack;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	
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
		
		JLabel lblName = new JLabel("Ім'я");
		lblName.setBounds(45, 31, 46, 20);
		this.getContentPane().add(lblName);
		
		
		JLabel lblPhone = new JLabel("Номер телефону");
		lblPhone.setBounds(45, 68, 250, 20);
		this.getContentPane().add(lblPhone);
		
		textField_1 = new JTextField();
		textField_1.setBounds(178, 65, 250, 20);
		this.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Email");
		lblEmailId.setBounds(45, 115, 46, 20);
		this.getContentPane().add(lblEmailId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(178, 112, 250, 20);
		this.getContentPane().add(textField_2);
		textField_2.setColumns(10);
			
		
		JLabel lblSex = new JLabel("Стать");
		lblSex.setBounds(45, 234, 46, 14);
		this.getContentPane().add(lblSex);
		
		JLabel lblMale = new JLabel("Чоловіча");
		lblMale.setBounds(128, 228, 80, 30);
		this.getContentPane().add(lblMale);
		
		JLabel lblFemale = new JLabel("Жіноча");
		lblFemale.setBounds(292, 228, 46, 30);
		this.getContentPane().add(lblFemale);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(337, 227, 109, 23);
		this.getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(187, 227, 109, 23);
		this.getContentPane().add(radioButton_1);
		
		
		
		this.submit = new JButton("Створити");
		submit.setBounds(120, 387, 100, 50);
		this.getContentPane().add(submit);
		submit.addActionListener(this);
		
		
		 
		this.getBack = new JButton("Повернутись");
		getBack.setBounds(240, 387, 100, 50);
		this.getContentPane().add(getBack);
		getBack.addActionListener(this);

	
		
		
		this.add(this.panel);
		this.setSize(500, 500);
		this.setTitle("Фізичний клієнт");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		
		if(ae.getActionCommand() == "Створити")
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
