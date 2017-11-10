package notebook1;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Main extends JFrame implements ActionListener{
	private JLabel id;
	private JLabel pw;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JPanel p1;
	private JLabel main;
	private Font font = new Font("궁서", Font.PLAIN, 23);
	
	public Main(){
		main = new JLabel("학생증 관리 시스템");
		button1 = new JButton("등록 ");
		button2 = new JButton("삭제");
		button3 = new JButton("조회");
		button4 = new JButton("NULL");
		p1 = new JPanel();
		p1.add(main);
		p1.setLayout(null);
		p1.add(button1);
		p1.add(button2);
		p1.add(button3);
		p1.add(button4);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		main.setFont(font);
		main.setBounds(85,100,200,100);
		button1.setBounds(89,230,90,38);
		button2.setBounds(189,230,90,38);
		button3.setBounds(89,280,90,38);
		button4.setBounds(189,280,90,38);

		add(p1);
		setSize(380,520);
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);


        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = d.width/2 - this.getWidth()/2,
            y = d.height/2 - this.getHeight()/2;
        setLocation(x, y);	

	}
	public void actionPerformed(ActionEvent e){
		ResultSet result = null;
		if(e.getSource().equals(button1)){
			new Form().setVisible(true);
		}
		else if(e.getSource().equals(button2)){
			JOptionPane.showMessageDialog(this, "취소하였습니다.");
			System.exit(0);
		}
		else if(e.getSource().equals(button3)){
			new Form().setVisible(true);
		}
		else if(e.getSource().equals(button4)){
			new Form().setVisible(true);
		}

	}
}

