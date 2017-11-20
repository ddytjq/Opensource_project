package notebook1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

//main
public class Delete extends JFrame implements ActionListener {
	private JLabel col;
	private JLabel dpt;
	private JLabel name;
	private JLabel id;
	private JLabel phone;
	private JTextField nametext;
	private JTextField idtext;
	private JButton button1;
	private JButton button2;
	private JPanel p1;
	private JPanel panel;
	private JLabel lblDelete;
	private Connection mysqlCon = null;

	private final String database = "notebook";
	private final String tableName = database + ".student_card";
	private final String mysqlPass = "";

	private final String DELETE_STMT = "DELETE FROM " + tableName + " WHERE (STUDENT_ID=? AND NAME=?)";

	public Delete() {
		button1 = new JButton("OK");
		button1.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		button2 = new JButton("Cancel");
		button2.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		p1 = new JPanel();
		p1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		p1.setBackground(new Color(255, 255, 255));
		p1.setForeground(new Color(255, 255, 255));
		p1.setLayout(null);
		p1.add(button1);
		p1.add(button2);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button1.setBounds(75, 394, 90, 42);
		button2.setBounds(203, 394, 90, 42);
		getContentPane().add(p1);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(204, 255, 255));
		panel.setLayout(null);
		panel.setBounds(0, 0, 362, 71);
		p1.add(panel);

		lblDelete = new JLabel("Delete");
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setFont(new Font("Brush Script MT", Font.PLAIN, 36));
		lblDelete.setBounds(57, 20, 239, 39);
		panel.add(lblDelete);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		panel_1.setLayout(null);
		panel_1.setBounds(14, 136, 334, 180);
		p1.add(panel_1);
		panel_1.setLayout(null);
		name = new JLabel("Name : ");
		name.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		panel_1.add(name);
		nametext = new JTextField(10);
		panel_1.add(nametext);
		id = new JLabel("Student ID : ");
		id.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		panel_1.add(id);
		idtext = new JTextField(10);
		panel_1.add(idtext);
		id.setBounds(43, 38, 99, 50);
		idtext.setBounds(137, 48, 154, 30);
		name.setBounds(43, 89, 70, 50);
		nametext.setBounds(137, 100, 154, 30);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));

		setSize(380, 508);
		setTitle("Delete");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = d.width / 2 - this.getWidth() / 2, y = d.height / 2 - this.getHeight() / 2;
		setLocation(x, y);

	}

	// ACTION
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button1)) {
			load();
			try {
				if (isEmpty())
					throw new Exception("Please enter all data!!");

				boolean success = delete();
				if (success) {
					JOptionPane.showMessageDialog(this, "DELETE");
					new Main();
					dispose();
				} else
					throw new Exception("An error occure at inserting!!");

			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
		} else if (e.getSource().equals(button2)) {
			JOptionPane.showMessageDialog(this, "Cancel");
			new Main();
			dispose();
		}
	}

	// DELETE
	private boolean delete() throws Exception {
		PreparedStatement pstm = mysqlCon.prepareStatement(DELETE_STMT);

		pstm.setObject(1, idtext.getText().trim());
		pstm.setObject(2, nametext.getText().trim());

		int result = pstm.executeUpdate();

		return (result > 0);
	}

	// 중복검사
	private boolean isEmpty() {
		boolean emptyname = nametext.getText().equals("");
		boolean emptyid = idtext.getText().equals("");

		return (emptyid || emptyname);
	}

	// db연동
	private void load() {
		try {
			// found jdbc driver for mysql
			Class.forName("com.mysql.jdbc.Driver");
			// create connection to mysql
			String url = "jdbc:mysql://localhost:3306/", uname = "root", upass = "0813"; // mysql password

			mysqlCon = DriverManager.getConnection(url, uname, upass);

			button1.setEnabled(true);

			// set database
			mysqlCon.setCatalog(database);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "An error occur!!" + e.getMessage());
		}
	}
}
