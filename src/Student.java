package trial;
import javax.swing.*;
import java.awt.event.*;
//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableColumnModel;

import javax.swing.table.DefaultTableModel;

//import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;

//  import net.proteanit.sql.DbUtils;

import javax.sql.RowSetMetaData;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class Student extends JFrame {

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
	private JTable table;
	private JTextField textuser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
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
	
	//====================================================function========================================================
	
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
		
			
	
			public void  excequteSql(String query,String message) {
				try {
					pst = con.prepareStatement(query);
					if(pst.executeUpdate()== 1) {
						try {
							String quary ="select * from student;";
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
								
								String[] sar = { Student_ID,Student_Name,Phone_Number,Student_email,Address,Password,UserName};
								
								 model.addRow(new Object[] {Student_ID,Student_Name,Phone_Number,Student_email,Address,Password,UserName});
								
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
						passwordField.setText("");
						textuser.setText("");
						
					}else {
						JOptionPane.showMessageDialog(null, "Record  not "+ message );
					}
					
				}catch(Exception e){
					e.printStackTrace();
					
				}
		
			}
			
			
			//=======================================================function============================================================
	public Student() {
		Image icon = new ImageIcon(this.getClass().getResource("/icon.jpg")).getImage();
		setIconImage(icon);
		setTitle("Librarian Access For Student Informaton Page ");
		 conect(); 
		 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel =  new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(0, 4, 847, 268);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel ilbl = new JLabel("student_id");
		ilbl.setForeground(Color.WHITE);
		ilbl.setBackground(Color.BLACK);
		ilbl.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		ilbl.setBounds(10, 11, 113, 25);
		panel.add(ilbl);
		
		textid = new JTextField();
		textid.setBounds(164, 11, 238, 25);
		panel.add(textid);
		textid.setColumns(10);
		
		JLabel Nlbl = new JLabel("Name");
		Nlbl.setForeground(Color.WHITE);
		Nlbl.setBackground(Color.BLACK);
		Nlbl.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		Nlbl.setBounds(10, 45, 113, 25);
		panel.add(Nlbl);
		
		textname = new JTextField();
		textname.setColumns(10);
		textname.setBounds(164, 47, 238, 25);
		panel.add(textname);
		
		JLabel Plbl = new JLabel("Phone_No");
		Plbl.setForeground(Color.WHITE);
		Plbl.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		Plbl.setBackground(Color.BLACK);
		Plbl.setBounds(10, 81, 113, 25);
		panel.add(Plbl);
		
		JLabel Elbl = new JLabel("Student_email");
		Elbl.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		Elbl.setForeground(Color.WHITE);
		Elbl.setBackground(Color.BLACK);
		Elbl.setBounds(10, 117, 113, 25);
		panel.add(Elbl);
		
		JLabel Albl = new JLabel("student_address");
		Albl.setForeground(Color.WHITE);
		Albl.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		Albl.setBackground(Color.BLACK);
		Albl.setBounds(10, 153, 126, 25);
		panel.add(Albl);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(164, 232, 238, 20);
		panel.add(passwordField);
		
		JLabel lblNewLabel_2_3 = new JLabel("Password");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2_3.setBackground(Color.BLACK);
		lblNewLabel_2_3.setBounds(10, 232, 113, 25);
		panel.add(lblNewLabel_2_3);
		
		textuser = new JTextField();
		textuser.setColumns(10);
		textuser.setBounds(164, 194, 238, 20);
		panel.add(textuser);
		
		textphone = new JTextField();
		textphone.setColumns(10);
		textphone.setBounds(164, 83, 238, 25);
		panel.add(textphone);
		
		textemail = new JTextField();
		textemail.setColumns(10);
		textemail.setBounds(164, 119, 238, 25);
		panel.add(textemail);
		
		textaddress = new JTextField();
		textaddress.setColumns(10);
		textaddress.setBounds(164, 155, 238, 25);
		panel.add(textaddress);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(2, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(0, 272, 847, 196);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 827, 174);
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
				passwordField.setText(RecordTable.getValueAt(SelectedRows, 6).toString());
				textuser.setText(RecordTable.getValueAt(SelectedRows, 7).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student_ID", "Student_Name", "Phone_Number", "Student_email", "Address", "Password", "UserName"
			}
		));
		scrollPane.setViewportView(table);
		
		
		JButton btnadd = new JButton("ADD");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textid.requestFocus(); 
			String query ="insert into  student(Student_ID,Student_Name,Phone_Number,Student_email,Address,Password,UserName)values('"+textid.getText()+"','"
                      +textname.getText()+"','"+textphone.getText()+"','"+textemail.getText()+"','"+textaddress.getText()+"','"+passwordField.getText()+"','"+textuser.getText()+"')";
				 excequteSql(query,"Add succucefully");
				conect();		
			
			}
		});
				

		btnadd.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnadd.setBackground(UIManager.getColor("CheckBox.background"));
		btnadd.setBounds(601, 9, 97, 29);
		panel.add(btnadd);
		
		JButton btnupdate = new JButton("UPDATE");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				conect();
				
				String quary="update student set   Student_Name='"+textname.getText()+"',Phone_Number='"+textphone.getText()+"', Student_email='"+textemail.getText()+"'"
						+ ",Address='"+textaddress.getText()+"', Password='"+passwordField.getText()+"', UserName='"+textuser.getText()+"' where Student_ID='"+textid.getText()+"';";
				 excequteSql(quary,"updated succucefully");
			
			}});
		btnupdate.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnupdate.setBounds(601, 97, 97, 29);
		panel.add(btnupdate);
		
		JButton btncheck = new JButton("CHECK");
		btncheck.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btncheck.setBounds(601, 171, 97, 29);
		panel.add(btncheck);
		
		JButton btnback = new JButton("BACK");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin L = new admin();
				L.setVisible(true);
				dispose();
			}
		});
		btnback.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnback.setBounds(740, 76, 97, 27);
		panel.add(btnback);
		
		JButton btnclear = new JButton("CLEAR");
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textid.setText("");
				textname.setText("");
				textphone.setText("");
				textaddress.setText("");
				textemail.setText("");
				passwordField.setText("");
				textuser.setText("");
				
			}
		});
		btnclear.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnclear.setBounds(601, 210, 97, 23);
		panel.add(btnclear);
		
		JButton btndelete = new JButton("DELETE");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quary ="Delete from student where Student_ID='"+textid.getText()+"'";
				excequteSql(quary,"Deleted succucefully");
			}
		});
		btndelete.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btndelete.setBounds(601, 137, 97, 23);
		panel.add(btndelete);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quary="select  Student_ID, Student_Name,Phone_Number, Student_email,Address, Password, UserName from student  where Student_ID='"+textid.getText()+"';";
				 
							try {
								pst = con.prepareStatement(quary);
								rs = pst.executeQuery();
								
								String Student_ID,Student_Name,Phone_Number,Student_email,Address,Password,UserName;
								while(rs.next()) {
									Student_ID=rs.getString(1);
									Student_Name=rs.getString(2);
									Phone_Number=rs.getString(3);
									Student_email=rs.getString(4);
									Address=rs.getString(5);
									Password=rs.getString(6);
									UserName=rs.getString(7);
									
						 
									textid.setText(Student_ID);
									textname.setText(Student_Name);
									textphone.setText(Phone_Number);
									textemail.setText(Student_email);
									textaddress.setText(Address);
									passwordField.setText(Password);
									textuser.setText(UserName);
								
						}
								}
							catch (SQLException e1) {
								JOptionPane.showMessageDialog(null,e1.getMessage());
								
							}
				
				
	
				
			}
						
		});
		btnSearch.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnSearch.setBounds(601, 61, 97, 23);
		panel.add(btnSearch);
		
		JLabel lbluser = new JLabel("UserName");
		lbluser.setForeground(Color.WHITE);
		lbluser.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lbluser.setBackground(Color.BLACK);
		lbluser.setBounds(10, 196, 113, 25);
		panel.add(lbluser);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("EXIT");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want Exite","EXIT",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnExit.setBounds(740, 120, 97, 27);
		panel.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/student.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 847, 268);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/student.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(0, 0, 847, 196);
		panel_1.add(lblNewLabel_1);
		
		try {
			String quary ="select * from student;";
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
		
		
		try {
			String quary ="select * from student;";
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
		
		
	}
}
