package trial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Librarian extends JFrame {
	String user;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Librarian frame = new Librarian();
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
	public Librarian() {
		setTitle("Librarian Action Page");
		Image icon = new ImageIcon(this.getClass().getResource("/icon.jpg")).getImage();
		setIconImage(icon);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 642, 336);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnsinfo = new JButton("To Alter Student Info");
		btnsinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student s = new Student();
				s.setVisible(true);
				dispose();
			}
		});
		btnsinfo.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnsinfo.setBounds(174, 88, 265, 38);
		panel.add(btnsinfo);
		
		JButton btnbinfo = new JButton("To Alter Book Info");
		btnbinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book b = new  Book();
				b.setVisible(true);
				dispose();
			}
		});
		btnbinfo.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnbinfo.setBounds(210, 185, 190, 38);
		panel.add(btnbinfo);
		
		JButton btnlinfo = new JButton("To Alter Librarian Info");
		btnlinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.equals("hayle12")) {
					AdminAction a = new AdminAction();
					a.setVisible(true);
					dispose();
				}
				else {
				librarianU l = new librarianU();
				l.setVisible(true);
				//l.user=user;
				try {
					String quary ="select * from librarian where username ='"+user+"';";
					l.pst = l.con.prepareStatement(quary);
					l.rs = l.pst.executeQuery();
					l.table.setModel(DbUtils.resultSetToTableModel(l.rs));
					
					String Student_ID,Student_Name,Phone_Number,Student_email,Address,Password,UserName;
					while(l.rs.next()) {
						Student_ID=l.rs.getString(1);
						Student_Name=l.rs.getString(2);
						Phone_Number=l.rs.getString(3);
						Student_email=l.rs.getString(4);
						Address=l.rs.getString(5);
						Password=l.rs.getString(6);
						UserName=l.rs.getString(7);
						
						
						
						 l.model.addRow(new Object[] {Student_ID,Student_Name,Phone_Number,Student_email,Address,Password,UserName});
						
			}
					}
				catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
				dispose();
				}
			}
		});
		btnlinfo.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnlinfo.setBounds(190, 136, 235, 38);
		panel.add(btnlinfo);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin a = new admin();
				a.setVisible(true);
				dispose();
			}
		});
		btnback.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnback.setBounds(543, 302, 89, 23);
		panel.add(btnback);
		
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
		btnexit.setBounds(10, 302, 89, 23);
		panel.add(btnexit);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/librarian1.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 642, 336);
		panel.add(lblNewLabel);
		
		
		
		
	}
}
