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

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class librarianU extends JFrame {
	String user;

	DefaultTableModel model;
	Connection con ;
	PreparedStatement pst ;
	ResultSet rs ;
	
	private JPanel contentPane;
	private JTextField textid;
	private JTextField textname;
	private JTextField textphone;
	private JTextField textemail;
	private JTextField textaddress;
	private JTextField textuser;
	private JTextField textpass;
	         JTable table;

	/**
	 * Launch the application.
	 */
	        
	         
	         public void  excequteSql(String query,String message) {
	     		try {
	     			pst = con.prepareStatement(query);
	     			if(pst.executeUpdate()== 1) {
	     				try {
	     					String quary ="select * from librarian where Librarian_ID ='"+textid.getText()+"';";
	     					pst = con.prepareStatement(quary);
	     					rs = pst.executeQuery();
	     					table.setModel(DbUtils.resultSetToTableModel(rs));
	     					
	     					String Librarian_ID, Librarian_Name, Phone_No, Librarian_email, Address, UserName, Password;
	     					while(rs.next()) {
	     						Librarian_ID=rs.getString(1);
	     						Librarian_Name=rs.getString(2);
	     						Phone_No=rs.getString(3);
	     						Librarian_email=rs.getString(4);
	     						Address=rs.getString(5);
	     						Password=rs.getString(6);
	     						UserName=rs.getString(7);
	        					 model.addRow(new Object[] {Librarian_ID,Librarian_Name,Phone_No,Librarian_email,Address,Password,UserName});
	     					
	     				
	     				}
	     					
	     					
	     					}
	     				catch (SQLException e) {
	     					JOptionPane.showMessageDialog(null,e.getMessage());
	     				}
	     				
	     				JOptionPane.showMessageDialog(null, "Record is " +message );
	     				
	     				textid.setText("");
	     				textname.setText("");
	     				textphone.setText("");
	     				textaddress.setText("");
	     				textemail.setText("");
	     				textpass.setText("");
	     				textuser.setText("");
	     				
	     			}else {
	     				JOptionPane.showMessageDialog(null, "Record  not "+ message );
	     			}
	     			
	     		}catch(Exception e){
	     			e.printStackTrace();
	     			
	     		}
	     		
	     		
	     		
	     		
	     	}
	         
	        
	         
	         public void display() {
	        	 try {
						String quary ="select * from librarian where username ='"+user+"';";
						pst = con.prepareStatement(quary);
						rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						String Student_ID,Student_Name,Phone_Number,Student_email,Address,Password,UserName;
						while(rs.next()) {
							Student_ID=rs.getString(1);
							Student_Name=rs.getString(2);
							Phone_Number=rs.getString(3);
							Student_email=rs.getString(4);
							Address=rs.getString(5);
							Password=rs.getString(6);
							UserName=rs.getString(7);
							
							
							
							 model.addRow(new Object[] {Student_ID,Student_Name,Phone_Number,Student_email,Address,Password,UserName});
							
				}
						}
					catch (SQLException e1) {
						System.out.println(e1.getMessage());
					}
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

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					librarianU frame = new librarianU();
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
	public librarianU() {
		Image icon = new ImageIcon(this.getClass().getResource("/icon.jpg")).getImage();
		setIconImage(icon);
		setTitle("Librarian Information Update Page");
		conect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 970, 243);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblid = new JLabel("Librarian_ID");
		lblid.setForeground(Color.WHITE);
		lblid.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblid.setBounds(10, 11, 103, 20);
		panel.add(lblid);
		
		JLabel lblname = new JLabel("Librarian_Name");
		lblname.setForeground(Color.WHITE);
		lblname.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblname.setBounds(10, 42, 130, 20);
		panel.add(lblname);
		
		JLabel lblPhoneno = new JLabel("Phone_No");
		lblPhoneno.setForeground(Color.WHITE);
		lblPhoneno.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblPhoneno.setBounds(10, 74, 103, 20);
		panel.add(lblPhoneno);
		
		JLabel lblLibrarianemail = new JLabel("Librarian_email");
		lblLibrarianemail.setForeground(Color.WHITE);
		lblLibrarianemail.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblLibrarianemail.setBounds(10, 106, 122, 20);
		panel.add(lblLibrarianemail);
		
		JLabel lblLibrarianaddress = new JLabel("Librarian_Address");
		lblLibrarianaddress.setForeground(Color.WHITE);
		lblLibrarianaddress.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblLibrarianaddress.setBounds(10, 139, 146, 20);
		panel.add(lblLibrarianaddress);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblUsername.setBounds(10, 169, 103, 20);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblPassword.setBounds(10, 200, 103, 20);
		panel.add(lblPassword);
		
		textid = new JTextField();
		textid.setBounds(166, 9, 203, 20);
		panel.add(textid);
		textid.setColumns(10);
		
		textname = new JTextField();
		textname.setColumns(10);
		textname.setBounds(166, 40, 203, 20);
		panel.add(textname);
		
		textphone = new JTextField();
		textphone.setColumns(10);
		textphone.setBounds(166, 72, 203, 20);
		panel.add(textphone);
		
		textemail = new JTextField();
		textemail.setColumns(10);
		textemail.setBounds(166, 104, 203, 20);
		panel.add(textemail);
		
		textaddress = new JTextField();
		textaddress.setColumns(10);
		textaddress.setBounds(166, 137, 203, 20);
		panel.add(textaddress);
		
		textuser = new JTextField();
		textuser.setColumns(10);
		textuser.setBounds(166, 167, 203, 20);
		panel.add(textuser);
		
		textpass = new JTextField();
		textpass.setColumns(10);
		textpass.setBounds(166, 198, 203, 20);
		panel.add(textpass);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quary1="update Librarian set   Librarian_Name='"+textname.getText()+"',Phone_Nol='"+textphone.getText()+"', Librarian_email='"+textemail.getText()+"'"
						+ ",Librarian_Address='"+textaddress.getText()+"', Password='"+textpass.getText()+"', UserName='"+textuser.getText()+"' where Librarian_ID='"+textid.getText()+"';";
				 excequteSql(quary1,"updated succucefully");	
				
				
			}
	         
				
			
		});
		btnNewButton.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnNewButton.setBounds(589, 39, 111, 34);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("EXIT");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want Exite","EXIT",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnNewButton_1.setBounds(589, 103, 111, 34);
		panel.add(btnNewButton_1);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin L = new admin();
				L.setVisible(true);
				dispose();
			}
		});
		btnback.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnback.setBounds(599, 153, 101, 34);
		panel.add(btnback);
		
		JLabel lblNewLabel = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/librarianu.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(0, 0, 970, 243);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 243, 970, 194);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 11, 950, 172);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
				int SelectedRows = table.getSelectedRow(); 
				textid.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
				textname.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
				textphone.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
				textemail.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
				textaddress.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
				textpass.setText(RecordTable.getValueAt(SelectedRows, 6).toString());
				textuser.setText(RecordTable.getValueAt(SelectedRows, 7).toString());
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Librarian_ID", "Librarian_Nme", "Phone_No", "Librarian_email", "Address", "UserName", "Password"
			}
		));
		scrollPane.setViewportView(table);
		
		

		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/librarianu.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 970, 194);
		panel_1.add(lblNewLabel_1);
		
		try {
			String quary ="select * from librarian;";
			pst = con.prepareStatement(quary);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			String Student_ID,Student_Name,Phone_Number,Student_email,Address,Password,UserName;
			while(rs.next()) {
				Student_ID=rs.getString(1);
				Student_Name=rs.getString(2);
				Phone_Number=rs.getString(3);
				Student_email=rs.getString(4);
				Address=rs.getString(5);
				Password=rs.getString(6);
				UserName=rs.getString(7);
		
				
				 model.addRow(new Object[] {Student_ID,Student_Name,Phone_Number,Student_email,Address,Password,UserName});
				
	}
			}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		display();
		
	}
}
