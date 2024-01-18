package trial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentUpdate extends JFrame {
	String user;
   
	DefaultTableModel model;
	Connection con ;
	PreparedStatement pst ;
	ResultSet rs ;


			 JPanel contentPane;
			 JTextField textid;
			 JTextField textphone;
			 JTextField textemail;
			 JTextField textaddress;
			 JTextField textuser;
			 JTextField textpass;
		     JTextField textname;
			 JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentUpdate frame = new StudentUpdate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}
	
	
	
	public void  excequteSql(String query,String message) {
		try {
			pst = con.prepareStatement(query);
			if(pst.executeUpdate()== 1) {
				try {
					
					String quary="select ID, Student_ID, Student_Name,Phone_Number, Student_email,Address, Password, UserName from student  where Student_ID='"+textid.getText()+"';";
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
				textpass.setText("");
				textuser.setText("");
				
			}else {
				JOptionPane.showMessageDialog(null, "Record  not "+ message );
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
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
 

	/**
	 * Create the frame.
	 */
 
	public StudentUpdate() {
		conect();
		
		
		Image icon = new ImageIcon(this.getClass().getResource("/icon.jpg")).getImage();
		setIconImage(icon);
		setTitle("Student Information Update Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 878, 220);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblid = new JLabel("Student_ID");
		lblid.setForeground(Color.WHITE);
		lblid.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		lblid.setBounds(10, 11, 87, 21);
		panel.add(lblid);
		
		JLabel lblname = new JLabel("Stdent_Name");
		lblname.setForeground(Color.WHITE);
		lblname.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		lblname.setBounds(10, 43, 119, 21);
		panel.add(lblname);
		
		JLabel lblphone = new JLabel("Phone_No");
		lblphone.setForeground(Color.WHITE);
		lblphone.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		lblphone.setBounds(10, 68, 87, 20);
		panel.add(lblphone);
		
		JLabel lblemail = new JLabel("Student_email");
		lblemail.setForeground(Color.WHITE);
		lblemail.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		lblemail.setBounds(10, 99, 119, 20);
		panel.add(lblemail);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setForeground(Color.WHITE);
		lbladdress.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		lbladdress.setBounds(10, 130, 87, 20);
		panel.add(lbladdress);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		lblUsername.setBounds(10, 161, 87, 20);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		lblPassword.setBounds(10, 192, 87, 17);
		panel.add(lblPassword);
		
		textid = new JTextField();
		textid.setBounds(173, 6, 197, 20);
		panel.add(textid);
		textid.setColumns(10);
		
		textphone = new JTextField();
		textphone.setColumns(10);
		textphone.setBounds(173, 63, 197, 20);
		panel.add(textphone);
		
		textemail = new JTextField();
		textemail.setColumns(10);
		textemail.setBounds(173, 94, 197, 20);
		panel.add(textemail);
		
		textaddress = new JTextField();
		textaddress.setColumns(10);
		textaddress.setBounds(173, 125, 197, 20);
		panel.add(textaddress);
		
		textuser = new JTextField();
		textuser.setColumns(10);
		textuser.setBounds(173, 156, 197, 20);
		panel.add(textuser);
		
		textpass = new JTextField();
		textpass.setColumns(10);
		textpass.setBounds(173, 187, 197, 20);
		panel.add(textpass);
		
		textname = new JTextField();
		textname.setColumns(10);
		textname.setBounds(173, 36, 197, 20);
		panel.add(textname);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
	            conect();
				
				String quary="update student set   Student_Name='"+textname.getText()+"',Phone_Number='"+textphone.getText()+"', Student_email='"+textemail.getText()+"'"
						+ ",Address='"+textaddress.getText()+"', Password='"+textpass.getText()+"', UserName='"+textuser.getText()+"' where Student_ID='"+textid.getText()+"';";
				 excequteSql(quary,"updated succucefully");		
				
				
			}
		});
		btnNewButton.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnNewButton.setBounds(507, 42, 89, 23);
		panel.add(btnNewButton);
		
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
		btnexit.setBounds(507, 99, 89, 23);
		panel.add(btnexit);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user s = new user();
				s.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnNewButton_2.setBounds(507, 153, 89, 23);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 221, 878, 215);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 858, 180);
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
				"Studdent_ID", "Student_Name", "Phone_No", "Student_email", "Address", "UserName", "Password"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/studentupdate.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		lblNewLabel_2.setBounds(0, 0, 878, 215);
		panel_1.add(lblNewLabel_2);
		
		textaddress.setText(textuser.getText());
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 878, 220);
		Image img1 = new ImageIcon(this.getClass().getResource("/studentupdate.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		panel.add(lblNewLabel);
		
		
	}
}
