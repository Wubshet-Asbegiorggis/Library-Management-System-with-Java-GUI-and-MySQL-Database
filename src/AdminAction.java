package trial;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class AdminAction extends JFrame {
	
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
	private JTextField textu;
	private JTable table;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAction frame = new AdminAction();
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
	
	public void  excequteSql(String query,String message) {
		try {
			pst = con.prepareStatement(query);
			if(pst.executeUpdate()== 1) {
				
				JOptionPane.showMessageDialog(null, "Record is" +message );
			}else {
				JOptionPane.showMessageDialog(null, "Record not"+ message );
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
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
				
				String[] sar = { Student_ID,Student_Name,Phone_Number,Student_email,Address,Password,UserName};
				
				 model.addRow(new Object[] {Student_ID,Student_Name,Phone_Number,Student_email,Address,Password,UserName});
				
	}
			}
		catch (SQLException e) {
			System.out.println(e.getMessage());
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
	
	
	
	public AdminAction() {
		Image icon = new ImageIcon(this.getClass().getResource("/icon.jpg")).getImage();
		setIconImage(icon);
		setTitle("Librarian Detale");
		conect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 981, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 965, 287);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblid = new JLabel("Librarian_ID");
		lblid.setForeground(Color.WHITE);
		lblid.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		lblid.setBounds(10, 11, 109, 24);
		panel.add(lblid);
		
		textid = new JTextField();
		textid.setBounds(185, 5, 221, 26);
		panel.add(textid);
		textid.setColumns(10);
		
		textname = new JTextField();
		textname.setBounds(185, 40, 221, 26);
		panel.add(textname);
		textname.setColumns(10);
		
		textphone = new JTextField();
		textphone.setBounds(185, 79, 221, 26);
		panel.add(textphone);
		textphone.setColumns(10);
		
		textemail = new JTextField();
		textemail.setBounds(185, 113, 221, 26);
		panel.add(textemail);
		textemail.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(185, 241, 221, 20);
		panel.add(passwordField);
		
		
		textaddress = new JTextField();
		textaddress.setBounds(185, 152, 221, 26);
		panel.add(textaddress);
		textaddress.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 288, 965, 205);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(20, 11, 935, 183);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel   model1 = (DefaultTableModel) table.getModel();
			    int SelectedRows = table.getSelectedRow();
			    
			  textname.setText(model1.getValueAt(SelectedRows, 2).toString());
				textid.setText(model1.getValueAt(SelectedRows, 1).toString());
				textphone.setText(model1.getValueAt(SelectedRows, 3).toString());
				textemail.setText(model1.getValueAt(SelectedRows, 4).toString());
				textaddress.setText(model1.getValueAt(SelectedRows, 5).toString());
				passwordField.setText(model1.getValueAt(SelectedRows, 6).toString());
				 textu.setText(model1.getValueAt(SelectedRows, 7).toString());
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"Librarian_ID", "Librarian_Name", "Phone_No", "Librarian_email", "Librarian_Address", "Password", "UserName"};
		final Object[] row =new Object[7];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnadd = new JButton("ADD");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					textid.requestFocus(); 
				String query ="insert into Librarian ( Librarian_ID, Librarian_Name,Phone_Nol, Librarian_email,Librarian_Address, Password, UserName)values('"+textid.getText()+"','"
                          +textname.getText()+"','"+textphone.getText()+"','"+textemail.getText()+"','"+textaddress.getText()+"','"+passwordField.getText()+"','"+textu.getText()+"')";
					 excequteSql(query,"Add succucefully");
					conect();		
				
			}
			
			 
		});
			
		
		btnadd.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnadd.setBounds(590, 9, 89, 23);
		panel.add(btnadd);
		
		JButton btnupdate = new JButton("UPDATE");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
						conect();
						
						String quary="update Librarian set   Librarian_Name='"+textname.getText()+"',Phone_Nol='"+textphone.getText()+"', Librarian_email='"+textemail.getText()+"'"
								+ ",Librarian_Address='"+textaddress.getText()+"', Password='"+passwordField.getText()+"', UserName='"+textu.getText()+"' where Librarian_ID='"+textid.getText()+"';";
						 excequteSql(quary,"updated succucefully");
					
				}
			
		});
		btnupdate.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnupdate.setBounds(590, 83, 98, 23);
		panel.add(btnupdate);
		
		JButton btndelete = new JButton("DELETE");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quary ="Delete from librarian where Librarian_ID='"+textid.getText()+"'";
				excequteSql(quary,"Deleted succucefully");
				
			}
			
		});
		btndelete.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btndelete.setBounds(590, 225, 98, 23);
		panel.add(btndelete);
		
		JButton btnsearch = new JButton("SEARCH");
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quary="select  Librarian_ID, Librarian_Name,Phone_Nol, Librarian_email,Librarian_Address, Password, UserName  from librarian  where Librarian_ID='"+textid.getText()+"';";
				 
				
				
				try {
					pst = con.prepareStatement(quary);
					rs = pst.executeQuery();
					
					String  Librarian_ID, Librarian_Name,Phone_No, Librarian_email,Librarian_Address, Password, UserName ;
					while(rs.next()) {
						 Librarian_ID=rs.getString(1);
						 Librarian_Name=rs.getString(2);
						 Phone_No=rs.getString(3);
						 Librarian_email=rs.getString(4);
						 Librarian_Address=rs.getString(5);
						Password=rs.getString(6);
						UserName=rs.getString(7);
						
			 
						textid.setText(Librarian_ID);
						textname.setText(Librarian_Name);
						textphone.setText(Phone_No);
						textemail.setText(Librarian_email);
						textaddress.setText(Librarian_Address);
						passwordField.setText(Password);
						textu.setText(UserName);
					
			}
					}
				catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
					
				}
			}
		});
		btnsearch.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnsearch.setBounds(590, 156, 98, 23);
		panel.add(btnsearch);
		
		JButton btnback = new JButton("BACK");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin a = new admin();
				a.setVisible(true);
				dispose();			}
		});
		btnback.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnback.setBounds(788, 83, 89, 23);
		panel.add(btnback);
		
		JLabel lblLibrarianname_1 = new JLabel("Librarian_Name");
		lblLibrarianname_1.setForeground(Color.WHITE);
		lblLibrarianname_1.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		lblLibrarianname_1.setBounds(10, 46, 136, 24);
		panel.add(lblLibrarianname_1);
		
		JLabel lblPhoneno = new JLabel("Phone_No");
		lblPhoneno.setForeground(Color.WHITE);
		lblPhoneno.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		lblPhoneno.setBounds(10, 85, 109, 24);
		panel.add(lblPhoneno);
		
		JLabel lblLibrarianemail = new JLabel("Librarian_email");
		lblLibrarianemail.setForeground(Color.WHITE);
		lblLibrarianemail.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		lblLibrarianemail.setBounds(10, 119, 136, 24);
		panel.add(lblLibrarianemail);
		
		JLabel lblLibrariana = new JLabel("Librarian_Address");
		lblLibrariana.setForeground(Color.WHITE);
		lblLibrariana.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		lblLibrariana.setBounds(10, 158, 136, 24);
		panel.add(lblLibrariana);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		lblUsername.setBounds(10, 197, 109, 24);
		panel.add(lblUsername);
		
		JLabel lblLibrarianname = new JLabel("Password");
		lblLibrarianname.setForeground(Color.WHITE);
		lblLibrarianname.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		lblLibrarianname.setBounds(10, 241, 109, 24);
		panel.add(lblLibrarianname);
		
		textu = new JTextField();
		textu.setColumns(10);
		textu.setBounds(185, 197, 221, 26);
		panel.add(textu);
		
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
		btnExit.setBounds(788, 134, 89, 23);
		panel.add(btnExit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textid.setText("");
				textname.setText("");
				textphone.setText("");
				textaddress.setText("");
				textemail.setText("");
				passwordField.setText("");
				textu.setText("");
			}
		});
		btnClear.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnClear.setBounds(779, 223, 98, 23);
		panel.add(btnClear);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/adminaction1.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 965, 287);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/adminaction1.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(0, 0, 965, 205);
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
				
				String[] sar = { Student_ID,Student_Name,Phone_Number,Student_email,Address,Password,UserName};
				
				 model.addRow(new Object[] {Student_ID,Student_Name,Phone_Number,Student_email,Address,Password,UserName});
				
	}
			}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	
	}
}
