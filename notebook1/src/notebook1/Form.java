package notebook1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

public class Form extends JFrame implements ActionListener {
	private static final String COLLEGE = null;
	private static final String DEPARTMENT = null;
	private static final String STUDENT_ID = null;
	private static final String NAME = null;
	private static final String PHONE = null;
	private JButton button1;
	private JButton button2;
	private JPanel p1;
	private JPanel panel;
	private JLabel lblDelete;
	private JLabel photo;
	private ImageIcon image;
	private JFileChooser jf = new JFileChooser();
	private JPanel panel_1;
	private BufferedImage big;
	private JTextField searchtext;
	private JButton searchbutton;
	private JTable table;
	private DefaultTableModel model;
	private String title[] = { "COL", "DEP", "ID", "NAME", "TEL" };
	private String arr[] = new String[5];
	private JRadioButton rdbtnCollage;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnStudentId;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;

	private Connection mysqlCon = null;

	private final String database = "notebook";
	private final String tableName = database + ".student_card";
	private final String mysqlPass = "";
	String str = null;
	String a;
	int i;
	private JRadioButton rdbtnAll;

	public Form() {
		model = new DefaultTableModel(title, 0);
		button1 = new JButton("Again");
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
		panel.setBackground(new Color(204, 255, 153));
		panel.setLayout(null);
		panel.setBounds(0, 0, 362, 71);
		p1.add(panel);

		lblDelete = new JLabel("Search");
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setFont(new Font("Brush Script MT", Font.PLAIN, 36));
		lblDelete.setBounds(63, 20, 239, 39);
		panel.add(lblDelete);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(204, 255, 204));
		panel_1.setLayout(null);
		panel_1.setBounds(14, 212, 334, 170);
		p1.add(panel_1);
		table = new JTable(model);
		table.setModel(model);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane.setBounds(14, 12, 306, 140);
		scrollPane.setViewportView(table);
		panel_1.add(scrollPane);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(204, 255, 204));
		panel_2.setLayout(null);
		panel_2.setBounds(14, 85, 334, 115);
		p1.add(panel_2);

		JLabel lblSearch = new JLabel("Search :");
		lblSearch.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		lblSearch.setBounds(36, 67, 80, 48);
		panel_2.add(lblSearch);
		searchbutton = new JButton("IN");
		searchbutton.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		searchbutton.setBounds(254, 77, 45, 30);
		searchbutton.addActionListener(this);
		panel_2.add(searchbutton);
		searchtext = new JTextField(10);
		searchtext.setBounds(105, 78, 135, 28);
		panel_2.add(searchtext);

		rdbtnCollage = new JRadioButton("collage");
		rdbtnCollage.setBackground(new Color(204, 255, 204));
		rdbtnCollage.setBounds(10, 8, 75, 27);
		panel_2.add(rdbtnCollage);

		rdbtnNewRadioButton = new JRadioButton("department");
		rdbtnNewRadioButton.setBackground(new Color(204, 255, 204));
		rdbtnNewRadioButton.setBounds(105, 8, 104, 27);
		panel_2.add(rdbtnNewRadioButton);

		rdbtnStudentId = new JRadioButton("student ID");
		rdbtnStudentId.setBackground(new Color(204, 255, 204));
		rdbtnStudentId.setBounds(223, 8, 101, 27);
		panel_2.add(rdbtnStudentId);

		rdbtnNewRadioButton_1 = new JRadioButton("name");
		rdbtnNewRadioButton_1.setBackground(new Color(204, 255, 204));
		rdbtnNewRadioButton_1.setBounds(10, 39, 80, 27);
		panel_2.add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton_2 = new JRadioButton("phone");
		rdbtnNewRadioButton_2.setBackground(new Color(204, 255, 204));
		rdbtnNewRadioButton_2.setBounds(105, 39, 88, 27);
		panel_2.add(rdbtnNewRadioButton_2);

		rdbtnAll = new JRadioButton("all");
		rdbtnAll.setBackground(new Color(204, 255, 204));
		rdbtnAll.setBounds(223, 42, 139, 27);
		panel_2.add(rdbtnAll);
		setSize(380, 508);
		setTitle("Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = d.width / 2 - this.getWidth() / 2, y = d.height / 2 - this.getHeight() / 2;
		setLocation(x, y);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button1)) {
			searchtext.setText("");
			rdbtnCollage.setSelected(false);
			rdbtnNewRadioButton.setSelected(false);
			rdbtnStudentId.setSelected(false);
			rdbtnNewRadioButton_1.setSelected(false);
			rdbtnNewRadioButton_2.setSelected(false);
			rdbtnAll.setSelected(false);
		}

		else if (e.getSource().equals(button2)) {
			JOptionPane.showMessageDialog(this, "Cancel");
			new Main();
			dispose();
		}

		else if (e.getSource().equals(searchbutton)) {
			load();
			String sqlStr;
			ResultSet result;
			PreparedStatement pstm = null;
			try {
				if (isEmpty2()) {
					model.setNumRows(0);
					sqlStr = "SELECT COLLEGE, DEPARTMENT, STUDENT_ID, NAME, PHONE FROM " + tableName;
					pstm = this.mysqlCon.prepareStatement(sqlStr);
				} else {
					model.setNumRows(0);
					sqlStr = "SELECT COLLEGE, DEPARTMENT, STUDENT_ID, NAME, PHONE FROM " + tableName
							+ " WHERE (COLLEGE = ? or DEPARTMENT = ? or STUDENT_ID = ? or NAME = ? or PHONE = ?)";
					pstm = this.mysqlCon.prepareStatement(sqlStr);
					pstm.setObject(1, searchtext.getText());
					pstm.setObject(2, searchtext.getText());
					pstm.setObject(3, searchtext.getText());
					pstm.setObject(4, searchtext.getText());
					pstm.setObject(5, searchtext.getText());

				}

				result = pstm.executeQuery();

				while (result.next()) {
					str = result.getString(1);

					arr[0] = str;
					for (i = 2; i < 6; i++) {
						a = result.getString(i);
						arr[i - 1] = a + "";
					}
					model.addRow(arr);
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
		}

	}

	private boolean isEmpty2() { 
		boolean emptysearch = searchtext.getText().equals("");

		return (emptysearch);
	}

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