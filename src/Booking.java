import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Booking extends JFrame implements ActionListener {

	private JTable clientTable;
	private JTable roomTable;
	ClientPhysicalTableModel clientModel;
	RoomTableModel roomModel;
	private JTextField bookDateField;
	private JTextField checkInDateField;
	private JTextField durationField;
	private JButton submit;
	private JButton getBack;

	private ClientLogic clientLogic = new ClientLogic();
	private RoomLogic roomLogic = new RoomLogic();
	private BookingLogic bookingLogic = new BookingLogic();
	
	public Booking() {
		render();
	}
	
	public void render() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		setContentPane(panel);
		
		getContentPane().add(new JLabel("Select a client:"));
		List<PhysicalClientEditModel> clients = clientLogic.getAll();
		clientModel = new ClientPhysicalTableModel(clients);
		clientTable = new JTable(clientModel);
		clientTable.createDefaultColumnsFromModel();
		getContentPane().add(new JScrollPane(clientTable));
		
		getContentPane().add(new JLabel("Select a room:"));
		List<RoomItem> rooms = roomLogic.getAll();
		roomModel = new RoomTableModel(rooms);
		roomTable = new JTable(roomModel);
		roomTable.createDefaultColumnsFromModel();
		getContentPane().add(new JScrollPane(roomTable));
		
		JPanel p1 = new JPanel();
		JLabel bookDateLabel = new JLabel("Book date");
		bookDateField = new JTextField(20);
		p1.add(bookDateLabel);
		p1.add(bookDateField);
		getContentPane().add(p1);
		
		JPanel p2 = new JPanel();
		JLabel checkInDateLabel = new JLabel("Check in date");
		checkInDateField = new JTextField(20);
		p2.add(checkInDateLabel);
		p2.add(checkInDateField);
		getContentPane().add(p2);
		
		JPanel p3 = new JPanel();
		JLabel durationLabel = new JLabel("Duration");
		durationField = new JTextField(20);
		p3.add(durationLabel);
		p3.add(durationField);
		getContentPane().add(p3);
		
		JPanel p4 = new JPanel();
		submit = new JButton("Submit");
		submit.addActionListener(this);
		getBack = new JButton("Return");
		getBack.addActionListener(this);
		p4.add(submit);
		p4.add(getBack);
		getContentPane().add(p4);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Return") {
			MainPage mainPage = new MainPage();
			mainPage.setVisible(true);
			this.setVisible(false);
		} else if (e.getActionCommand() == "Submit") {
			SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
			int clientSelectedRow = clientTable.getSelectedRow();
			int roomSelectedRow = roomTable.getSelectedRow();
			if (clientSelectedRow == -1 || roomSelectedRow == -1)
				return;
			int clientId = clientModel.getItem(clientSelectedRow).getId();
			int roomId = roomModel.getItem(roomSelectedRow).getId();
			Date bookDate = null;
			try {
				bookDate = format.parse(bookDateField.getText());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Date checkInDate = null;
			try {
				checkInDate = format.parse(checkInDateField.getText());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int duration = Integer.parseInt(durationField.getText());
			
			bookingLogic.addBooking(clientId, roomId, bookDate, checkInDate, duration);
		}
	}

	
	
}
