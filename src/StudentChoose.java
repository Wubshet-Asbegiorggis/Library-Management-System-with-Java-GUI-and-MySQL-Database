package trial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextField;

public class StudentChoose extends JFrame {
	String user;
	private JPanel contentPane;
	JLabel lblNewLabel,lbl1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentChoose frame = new StudentChoose();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public StudentChoose( ) {
	//	textField.setText(user);
		Image icon = new ImageIcon(this.getClass().getResource("/icon.jpg")).getImage();
		setIconImage(icon);
		setTitle("Student Action Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 506, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnupdate = new JButton("Update My Info");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentUpdate s = new StudentUpdate();
				try {
					String quary="select ID, Student_ID, Student_Name,Phone_Number, Student_email,Address, Password, UserName from student  where UserName='"+user+"';";
					s.pst = s.con.prepareStatement(quary);
					s.rs = s.pst.executeQuery();
					s.table.setModel(DbUtils.resultSetToTableModel(s.rs));
					
					String Student_ID,Student_Name,Phone_Number,Student_email,Address,Password,UserName;
					while(s.rs.next()) {
						Student_ID=s.rs.getString(1);
						Student_Name=s.rs.getString(2);
						Phone_Number=s.rs.getString(3);
						Student_email=s.rs.getString(4);
						Address=s.rs.getString(5);
						Password=s.rs.getString(6);
						UserName=s.rs.getString(7);
						
						 s.model.addRow(new Object[] {Student_ID,Student_Name,Phone_Number,Student_email,Address,Password,UserName});
					
						
						s.textid.setText(Student_ID);
						s.textname.setText(Student_Name);
						s.textphone.setText(Phone_Number);
						s.textemail.setText(Student_email);
						s.textaddress.setText(Address);
						s.textpass.setText(Password);
						s.textuser.setText(UserName);
						
				}
					}
				catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
				s.setVisible(true);
				dispose();
			}
		});
		btnupdate.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		btnupdate.setBounds(116, 50, 235, 43);
		panel.add(btnupdate);
		
		JButton btnborrow = new JButton("To Borrow Book's");
		btnborrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentBook b = new StudentBook();
				b.user=user;
				b.setVisible(true);
				dispose();
			}
		});
		btnborrow.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnborrow.setBounds(116, 116, 235, 43);
		panel.add(btnborrow);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user u = new user();
				u.setVisible(true);
				dispose();
			}
		});
		btnback.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnback.setBounds(407, 227, 89, 23);
		panel.add(btnback);
		
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
		btnExit.setBounds(10, 227, 89, 23);
		panel.add(btnExit);
		 Image img = new ImageIcon(this.getClass().getResource("/studentcoose.jpg")).getImage();
		 
		 JLabel lbl1 = new JLabel("");
		 lbl1.setBounds(36, 11, 46, 14);
		 panel.add(lbl1);
		 
		 
		  lblNewLabel = new JLabel("");
		  lblNewLabel.setBounds(0, 0, 506, 261);
		  panel.add(lblNewLabel);
		  lblNewLabel.setIcon(new ImageIcon(img));
		
	
		
	}
}
