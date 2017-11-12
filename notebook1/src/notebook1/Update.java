package notebook1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;



public class Update extends JFrame implements ActionListener{
	private JLabel col;
	private JLabel dpt;
	private JLabel name;
	private JLabel id;
	private JLabel phone;
	private JTextField coltext;
	private JTextField dpttext;
	private JTextField nametext;
	private JTextField idtext;
	private JTextField phonetext;
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


	public Update(){
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
		button1.setBounds(75,394,90,42);
		button2.setBounds(203,394,90,42);
		getContentPane().add(p1);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 192, 203));
		panel.setLayout(null);
		panel.setBounds(0, 0, 362, 71);
		p1.add(panel);

		lblDelete = new JLabel("Update");
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setFont(new Font("Brush Script MT", Font.PLAIN, 36));
		lblDelete.setBounds(63, 20, 239, 39);
		panel.add(lblDelete);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(255, 240, 245));
		panel_1.setLayout(null);
		panel_1.setBounds(14, 145, 334, 237);
		p1.add(panel_1);
		col = new JLabel("College : ");
		col.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		panel_1.add(col);
		dpt = new JLabel("Department : ");
		dpt.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		panel_1.add(dpt);
		dpttext = new JTextField(10);
		panel_1.add(dpttext);
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
		phone = new JLabel("Phone : ");
		phone.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		panel_1.add(phone);
		phonetext = new JTextField(10);
		panel_1.add(phonetext);
		col.setBounds(43,11,70,50);
		dpt.setBounds(43,54,88,50);
		dpttext.setBounds(137,148,154,30);
		id.setBounds(43,96,99,50);
		idtext.setBounds(137,106,154,30);
		phone.setBounds(43,179,70,50);
		phonetext.setBounds(137,64,154,30);
		name.setBounds(43,137,70,50);
		nametext.setBounds(137,190,154,30);
		searchtext = new JTextField(10);
		searchtext.setBounds(137, 22, 154, 28);
		panel_1.add(searchtext);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(new Color(255, 240, 245));
		panel_2.setLayout(null);
		panel_2.setBounds(14, 85, 334, 48);
		p1.add(panel_2);

		JLabel lblSearch = new JLabel("Search : ");
		lblSearch.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		lblSearch.setBounds(43,0,70,48);
		panel_2.add(lblSearch);
		coltext = new JTextField(10);
		coltext.setBounds(137, 10, 116, 28);
		searchbutton = new JButton("IN");
		searchbutton.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		searchbutton.setBounds(261,9,45,30);
		searchbutton.addActionListener(this);
		panel_2.add(searchbutton);
		panel_2.add(coltext);
		setSize(380,508);
		setTitle("Enroll");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = d.width/2 - this.getWidth()/2,
				y = d.height/2 - this.getHeight()/2;
		setLocation(x, y);	

	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(button1)){

		}
		else if(e.getSource().equals(button2)){
			JOptionPane.showMessageDialog(this, "Cancel!!!!");
			new Main();
		}
		else if(e.getSource().equals(searchbutton)){
		}
	}
}

