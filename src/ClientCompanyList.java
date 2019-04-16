import database.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Vector;

public class ClientCompanyList extends JFrame implements ActionListener, KeyListener {


    public ClientCompanyList()
    {
        this.initializeComponents();
    }

    private void initializeComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String query = "select id_client_legal as id, name, business, contact\r\n" +
                "from legal i\r\n" +
                "inner join `client`\r\n" +
                "on `client`.id_client = i.id_client_legal";

        List<ClientCompanyItem> items = DbUtils.GetMapped(query, ClientCompanyItem.class);
        ClientCompanyItem[] arr = items.toArray(new ClientCompanyItem[items.size()]);

        ClientCompanyTableModel model = new ClientCompanyTableModel(items);
        JTable table = new JTable(model);
        table.createDefaultColumnsFromModel();

        JButton jb = new JButton("Delete");
        jb.setBounds(50, 107, 100, 50);
        this.getContentPane().add(jb);
        jb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                model.Delete(row);

            }
        });

        JButton hb2 = new JButton("Return");
        hb2.setBounds(200, 107, 100, 50);
        this.getContentPane().add(hb2);
        hb2.addActionListener(this);


        this.add(jb);

        this.add(new JScrollPane(table));

        this.setSize(700, 300);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {

        if(ae.getActionCommand() == "Return")
        {
            ClientsMain clientsmain = new ClientsMain();
            clientsmain.setVisible(true);
            this.setVisible(false);
        }
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }



    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}
