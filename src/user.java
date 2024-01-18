package trial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

//import com.mysql.cj.protocol.Resultset;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class user extends JFrame {
	
	
	
	Connection con ;
	PreparedStatement pst ;
	ResultSet rs ;

	private JPanel contentPane;
	private JTextField textuser;
	private JPasswordField passfiled;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user frame = new user();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void conect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/library","root","Kid12@1993");
		}  
		catch(ClassNotFoundException ex) {
			
		}
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	

	/**
	 * Create the frame.
	 */
	public user() {
		setTitle("LIBRARY MANAGEMENT SYSTEM");
		Image icon = new ImageIcon(this.getClass().getResource("/icon.jpg")).getImage();
		setIconImage(icon);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 691, 346);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(154, 146, 399, 156);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Input username and password ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(10, 11, 214, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lbluser = new JLabel("Username :");
		lbluser.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lbluser.setBounds(128, 51, 96, 23);
		panel_2.add(lbluser);
		
		JLabel lblpass = new JLabel("Password :");
		lblpass.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblpass.setBounds(128, 85, 84, 23);
		panel_2.add(lblpass);
		
		textuser = new JTextField();
		textuser.setBounds(218, 50, 96, 20);
		panel_2.add(textuser);
		textuser.setColumns(10);
		
		passfiled = new JPasswordField();
		passfiled.setBounds(222, 84, 150, 20);
		panel_2.add(passfiled);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  String userName = textuser.getText();
	                String password = passfiled.getText();
	                try {
	                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Library",
	                        "root", "Kid12@1993");

	                    Statement pst = con.createStatement();
	                    String check = "select * from Student where UserName='"+textuser.getText()+"' and Password='"+passfiled.getText()+"'";
	             
	                    ResultSet rs = pst.executeQuery(check);
	                    if (rs.next()) {
	                        dispose();
	                        StudentChoose st = new  StudentChoose();
	                        st.user=userName;
	                        st.setVisible(true);
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

		 
		btnlogin.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 13));
		btnlogin.setBounds(232, 115, 82, 23);
		panel_2.add(btnlogin);
		
		JButton btnback = new JButton("BACK");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				image i = new image();
				i.setVisible(true);
				dispose();
				}
		});
		btnback.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnback.setBounds(138, 115, 86, 23);
		panel_2.add(btnback);
		
		JLabel lblNewLabel_7 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login.jpg")).getImage();
		lblNewLabel_7.setIcon(new ImageIcon(img));
		lblNewLabel_7.setBounds(0, 0, 399, 156);
		panel_2.add(lblNewLabel_7);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(154, 123, 399, 23);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("LOGIN");
		lblNewLabel_3.setForeground(new Color(165, 42, 42));
		lblNewLabel_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(0, 0, 71, 23);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/user.jpg")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img1));
		lblNewLabel_6.setBounds(0, 25, 689, 319);
		panel.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(0, 0, 689, 21);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("USER'S LOGIN INTERFACE");
		lblNewLabel_4.setForeground(new Color(165, 42, 42));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setBounds(209, 0, 241, 21);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(0, 346, 691, 34);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("ADDIS ABABA UNIVERCITY LIBRARY MANAGEMENT SYSTEM");
		lblNewLabel_5.setForeground(new Color(165, 42, 42));
		lblNewLabel_5.setFont(new Font("Sylfaen", Font.ITALIC, 11));
		lblNewLabel_5.setBounds(10, 11, 389, 14);
		panel_4.add(lblNewLabel_5);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("EXIT");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want Exite","EXIT",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnExit.setBounds(569, 0, 74, 25);
		panel_4.add(btnExit);
		
		
	}
}
