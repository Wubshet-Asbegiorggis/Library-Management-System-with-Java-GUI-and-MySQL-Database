package trial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class admin extends JFrame {

	private JPanel contentPane;
	private JTextField textuser;
	private JPasswordField passField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public admin() {
		Image icon = new ImageIcon(this.getClass().getResource("/icon.jpg")).getImage();
		setIconImage(icon);
		setTitle("LIBRARY MANAGEMENT SYSTEM");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 726, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 710, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Label1 = new JLabel("ADMIN'S LOGIN INTERFACE");
		Label1.setForeground(new Color(0, 51, 0));
		Label1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		Label1.setBounds(166, 11, 260, 20);
		panel.add(Label1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 33, 716, 295);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(150, 67, 425, 177);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Input username and password");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(10, 11, 250, 14);
		panel_3.add(lblNewLabel_2);
		
		JLabel lbluser = new JLabel("Username :");
		lbluser.setForeground(Color.BLACK);
		lbluser.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lbluser.setBounds(147, 45, 102, 22);
		panel_3.add(lbluser);
		
		JLabel lblpass = new JLabel("Password :");
		lblpass.setForeground(Color.BLACK);
		lblpass.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblpass.setBounds(147, 82, 102, 22);
		panel_3.add(lblpass);
		
		textuser = new JTextField();
		textuser.setBounds(243, 44, 130, 22);
		panel_3.add(textuser);
		textuser.setColumns(10);
		
		passField = new JPasswordField();
		passField.setBounds(243, 78, 172, 26);
		panel_3.add(passField);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		  String userName = textuser.getText();
	                try {
	                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Library",
	                        "root", "Kid12@1993");

	                    Statement pst = con.createStatement();
	                    String check = "select * from librarian where UserName='"+textuser.getText()+"' and Password='"+passField.getText()+"'";
	         
	                    ResultSet rs = pst.executeQuery(check);
	                    if (rs.next()) {
	                       
	                        Librarian L = new    Librarian();
	                        L.user=userName;
 	                        L.setVisible(true);
	                        dispose();
	                        JOptionPane.showMessageDialog(btnlogin, "You have successfully logged in");
	                    } else {
	                        JOptionPane.showMessageDialog(btnlogin, "Wrong Username & Password");
	                    }
	                    con.close();
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
	            }
		
		});
		btnlogin.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnlogin.setBounds(272, 124, 80, 23);
		panel_3.add(btnlogin);
		
		JButton btnback = new JButton("BACK");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				image i = new image();
				i.setVisible(true);
				dispose();
			}
		});
		btnback.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnback.setBounds(166, 124, 80, 23);
		panel_3.add(btnback);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 425, 177);
		panel_3.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(150, 43, 425, 24);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setForeground(new Color(51, 51, 51));
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(0, 0, 97, 40);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		lblNewLabel_6.setBounds(0, 0, 714, 295);
		Image img1 = new ImageIcon(this.getClass().getResource("/admin.jpg")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img1));
		panel_1.add(lblNewLabel_6);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 328, 710, 30);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("ADDIS ABABA UNIVERSITY LIBRARY MANAGEMENT SYSTEM");
		lblNewLabel_5.setForeground(new Color(51, 51, 51));
		lblNewLabel_5.setFont(new Font("Sitka Text", Font.ITALIC, 12));
		lblNewLabel_5.setBounds(10, 11, 366, 15);
		panel_2.add(lblNewLabel_5);
		
		JButton btnexit = new JButton("Exit");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("EXIT");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want Exite","EXIT",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnexit.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnexit.setBounds(601, 5, 80, 23);
		panel_2.add(btnexit);
	}
}
