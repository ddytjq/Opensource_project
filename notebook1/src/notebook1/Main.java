package notebook1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Main extends JFrame implements ActionListener{
	private JLabel id;
	private JLabel pw;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JPanel p1;
	private Font font = new Font("궁서", Font.PLAIN, 22);
	private JLabel lblNewLabel;
	public Main(){
		button1 = new JButton();
		button1.setIcon(new ImageIcon(Main.class.getResource("/notebook1/picture/ENROLL.png")));
		button1.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		button1.setBackground(Color.WHITE);
		button1.setForeground(Color.BLACK);
		button2 = new JButton();
		button2.setIcon(new ImageIcon(Main.class.getResource("/notebook1/picture/DELETE.png")));
		button2.setForeground(Color.BLACK);
		button2.setBackground(Color.WHITE);
		button2.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		button3 = new JButton();
		button3.setIcon(new ImageIcon(Main.class.getResource("/notebook1/picture/CHANGE.png")));
		button3.setForeground(Color.BLACK);
		button3.setFont(new Font("Sitka Text", Font.PLAIN, 13));
		button4 = new JButton();
		button4.setIcon(new ImageIcon(Main.class.getResource("/notebook1/picture/CHECK.png")));
		button4.setForeground(Color.BLACK);
		button4.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		p1.setLayout(null);
		p1.add(button1);
		p1.add(button2);
		p1.add(button3);
		p1.add(button4);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button1.setBounds(74,333,98,48);
		button2.setBounds(199,333,98,48);
		button3.setBounds(74,393,98,48);
		button4.setBounds(199,393,98,48);

		getContentPane().add(p1);
		
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		Image img1 = new ImageIcon(this.getClass().getResource("/notebook1/picture/다운로드.jpg")).getImage();
		Image change1 = img1.getScaledInstance(110, 110, Image.SCALE_SMOOTH);
		label1.setIcon(new ImageIcon(change1));
		Image img2 = new ImageIcon(this.getClass().getResource("/notebook1/picture/더하기.jpg")).getImage();
		Image change2 = img2.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		label2.setIcon(new ImageIcon(change2));
		Image img3 = new ImageIcon(this.getClass().getResource("/notebook1/picture/학생증.jpg")).getImage();
		Image change3 = img3.getScaledInstance(80, 70, Image.SCALE_SMOOTH);
		label3.setIcon(new ImageIcon(change3));
		p1.add(label1);
		p1.add(label2);
		p1.add(label3);
		label1.setBounds(50, 160, 110, 114);
		label2.setBounds(178, 213, 31, 38);
		label3.setBounds(223, 185, 80, 89);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(0, 0, 362, 101);
		p1.add(panel);
		
		panel.setLayout(null);
		lblNewLabel = new JLabel("Student ID Management System!");
		lblNewLabel.setBackground(new Color(51, 102, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Brush Script MT", Font.BOLD, 25));
		panel.add(lblNewLabel);
		lblNewLabel.setBounds(14,12,333,78);
		setSize(380,520);
		setTitle("System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		


        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = d.width/2 - this.getWidth()/2,
            y = d.height/2 - this.getHeight()/2;
        setLocation(x, y);	

	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(button1)){
			new Enroll();
		}
		else if(e.getSource().equals(button2)){
			new Delete();
		}
		else if(e.getSource().equals(button3)){
			new Form().setVisible(true);
		}
		else if(e.getSource().equals(button4)){
			new Form().setVisible(true);
		}

	}
}

