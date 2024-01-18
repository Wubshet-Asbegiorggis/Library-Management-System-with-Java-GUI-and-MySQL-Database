package trial;

import java.awt.BorderLayout;
import javax.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class StudentBook extends JFrame {
	String user,id;
	
	
DefaultTableModel model;
	
	Connection con ;
	PreparedStatement pst ;
	ResultSet rs ;


	private JPanel contentPane, panel_1;
	private JTextField textid;
	private JTextField textname;
	private JTextField textauthor;
	private JTextField textdate;
	         JTextField texttype;
	private JTable table;
	JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentBook frame = new StudentBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void  excequteSql(String query,String mesage) {
		try {
			pst = con.prepareStatement(query);
			if(pst.executeUpdate()== 1) {
				try {
					String quary ="select * from Book;";
					pst = con.prepareStatement(quary);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					String id , name,author,date,price,type,no,description,total_No;
					while(rs.next()) {
						id=rs.getString(1);
						name=rs.getString(2);
						author=rs.getString(3);
						date=rs.getString(4);
						price=rs.getString(5);
						type=rs.getString(6);
						no=rs.getString(7);
						description=rs.getString(7);
					
						 model.addRow(new Object[] { id , name,author,date,price,type,no,description});
						
			}
					}
				catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
				JOptionPane.showMessageDialog(null, mesage);
				
				textid.setText("");
				textname.setText("");
				textauthor.setText("");
				textdate.setText("");
				texttype.setText("");
			
				
			}else {
				JOptionPane.showMessageDialog(null, " Not "+ mesage);
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
	public StudentBook() {
		setTitle("Student Access To Book");
		Image icon = new ImageIcon(this.getClass().getResource("/icon.jpg")).getImage();
		setIconImage(icon);
		conect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 853, 253);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblid = new JLabel("Book_ID");
		lblid.setForeground(Color.WHITE);
		lblid.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblid.setBounds(10, 11, 86, 20);
		panel.add(lblid);
		
		JLabel lblBookname = new JLabel("Book_Name");
		lblBookname.setForeground(Color.WHITE);
		lblBookname.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblBookname.setBounds(10, 42, 98, 24);
		panel.add(lblBookname);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setForeground(Color.WHITE);
		lblAuthor.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblAuthor.setBounds(10, 77, 86, 20);
		panel.add(lblAuthor);
		
		JLabel lblPuctiondate = new JLabel("Puction_Date");
		lblPuctiondate.setForeground(Color.WHITE);
		lblPuctiondate.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblPuctiondate.setBounds(10, 116, 121, 23);
		panel.add(lblPuctiondate);
		
		JLabel lblBooktype = new JLabel("Book_Type");
		lblBooktype.setForeground(Color.WHITE);
		lblBooktype.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblBooktype.setBounds(10, 150, 98, 20);
		panel.add(lblBooktype);
		
		textid = new JTextField();
		textid.setBounds(141, 6, 214, 20);
		panel.add(textid);
		textid.setColumns(10);
		
		textname = new JTextField();
		textname.setColumns(10);
		textname.setBounds(141, 37, 214, 20);
		panel.add(textname);
		
		textauthor = new JTextField();
		textauthor.setColumns(10);
		textauthor.setBounds(141, 72, 214, 20);
		panel.add(textauthor);
		
		textdate = new JTextField();
		textdate.setColumns(10);
		textdate.setBounds(141, 111, 214, 20);
		panel.add(textdate);
		
		texttype = new JTextField();
		texttype.setColumns(10);
		texttype.setBounds(141, 145, 214, 20);
		panel.add(texttype);
		
		JButton btnsearch = new JButton("Search");
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               String quary="select  Book_Id,Book_Name, Book_Author, Publication_Date, Book_Type, Book_Price,Total_No,Book_description from Book  where Book_ID='"+textid.getText()+"';";
			
				try {
					pst = con.prepareStatement(quary);
					rs = pst.executeQuery();
					
					String Book_ID,Book_Name, Book_Author, Publication_Date, Book_Type;
					while(rs.next()) {
						Book_ID=rs.getString(1);
						Book_Name=rs.getString(2);
						Book_Author=rs.getString(3);
						Publication_Date=rs.getString(4);
						Book_Type=rs.getString(5);
						
						
			 
						textid.setText(Book_ID);
						textname.setText(Book_Name);
						textauthor.setText(Book_Author);
						textdate.setText(Publication_Date);
						texttype.setText(Book_Type);
						
					
			}
					}
				catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
					
				}
			
			}
		});
		btnsearch.setForeground(Color.BLACK);
		btnsearch.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 15));
		btnsearch.setBounds(461, 77, 127, 49);
		panel.add(btnsearch);
		
		JButton btnbtnBorrow = new JButton("Borrow");
		btnbtnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int no=0,result=0;
					
					try {
						String quary1="select Total_No from Book where Book_ID='"+textid.getText()+"';";
						pst = con.prepareStatement(quary1);
						
						rs = pst.executeQuery();
						while(rs.next()) {
						no=Integer.parseInt(rs.getString(1));
						}
						if(no>0) {
						result=no-1;
						String quary="update Book set  Total_No='"+result+"' where Book_ID='"+textid.getText()+"' ;";
						excequteSql(quary,"Borrowed Successfuly");
						}else {
							JOptionPane.showMessageDialog(null,"The Book Is Not Avalable Now");
						}
					}
						
					catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,e1.getMessage());
						
					}
					
					
					
				
				
			
		}});
		btnbtnBorrow.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		btnbtnBorrow.setBounds(568, 11, 127, 49);
		panel.add(btnbtnBorrow);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user s = new user();
				s.setVisible(true);
				dispose();
			}
		});
		btnback.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		btnback.setBounds(754, 230, 89, 23);
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
		btnexit.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		btnexit.setBounds(10, 230, 89, 23);
		panel.add(btnexit);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no = 0,result;
				try {
					String quary1="select Total_No from Book where Book_ID='"+textid.getText()+"';";
					pst = con.prepareStatement(quary1);
					
					rs = pst.executeQuery();
					while(rs.next()) {
					no=Integer.parseInt(rs.getString(1));
					}
					result=no+1;

					String quary="update Book set  Total_No='"+result+"' where Book_ID='"+textid.getText()+"' ;";
					excequteSql(quary,"Returned Successfuly");
					
					
					String quary11 ="select Book_Id,Book_Name,Book_Author,Student_ID,Student_Name,Student_email from student,Book where Book_ID='"+id+"' and username='"+user+"';";
					pst = con.prepareStatement(quary11);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					String Book_ID,Book_Name, Book_Author, Student_ID,Student_Name,Student_email;
					while(rs.next()) {
						Book_ID=rs.getString(1);
						Book_Name=rs.getString(2);
						Book_Author=rs.getString(3);
						Student_ID=rs.getString(4);
						Student_Name=rs.getString(5);
						Student_email=rs.getString(6);
						
						 model.addRow(new Object[] {Book_ID,Book_Name,Book_Author,Student_ID,Student_Name,Student_email});
					}
			 }
					
				catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
					
				}
				

				
			}
		});
		btnReturn.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		btnReturn.setBounds(680, 77, 127, 49);
		panel.add(btnReturn);
		
		JButton btnBooksThatHave = new JButton("Books that have > 15 copy");
		btnBooksThatHave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String quary="select  Book_Id,Book_Name, Book_Author, Publication_Date, Book_Type, Book_Price,Total_No,Book_description from Book  where Total_No>15;";
					
					try {
						pst = con.prepareStatement(quary);
						rs = pst.executeQuery();
							pst = con.prepareStatement(quary);
							rs = pst.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
						
							
							String Book_ID,Book_Name, Book_Author, Publication_Date,Book_Type;
							while(rs.next()) {
								Book_ID=rs.getString(1);
								Book_Name=rs.getString(2);
								Book_Author=rs.getString(3);
								Publication_Date=rs.getString(4);
								Book_Type=rs.getString(5);
								
								 model.addRow(new Object[] {Book_ID,Book_Name,Book_Author,Publication_Date,Book_Type});
								
					}}
							
						catch (SQLException e1) {
							System.out.println(e1.getMessage());
						}
				
				
				
			}
		});
		btnBooksThatHave.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		btnBooksThatHave.setBounds(495, 136, 251, 34);
		panel.add(btnBooksThatHave);
		
		JButton btnReturn_1_1 = new JButton("Books that are not in library");
		btnReturn_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String quary="select  Book_Id,Book_Name, Book_Author, Publication_Date, Book_Type, Book_Price,Total_No,Book_description from Book  where Total_No=0;";
					
					try {
						pst = con.prepareStatement(quary);
						rs = pst.executeQuery();
							pst = con.prepareStatement(quary);
							rs = pst.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
						
							
							String Book_ID,Book_Name, Book_Author, Publication_Date,Book_Type;
							while(rs.next()) {
								Book_ID=rs.getString(1);
								Book_Name=rs.getString(2);
								Book_Author=rs.getString(3);
								Publication_Date=rs.getString(4);
								Book_Type=rs.getString(5);
								
								 model.addRow(new Object[] {Book_ID,Book_Name,Book_Author,Publication_Date,Book_Type});
								
					}}
							
						catch (SQLException e1) {
							System.out.println(e1.getMessage());
						}
				
				
				
			}
		});
		btnReturn_1_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		btnReturn_1_1.setBounds(495, 180, 251, 34);
		panel.add(btnReturn_1_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String quary ="select * from Book;";
					pst = con.prepareStatement(quary);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					String Book_ID,Book_Name, Book_Author, Publication_Date,Book_Type;
					while(rs.next()) {
						Book_ID=rs.getString(1);
						Book_Name=rs.getString(2);
						Book_Author=rs.getString(3);
						Publication_Date=rs.getString(4);
						Book_Type=rs.getString(5);
						
						 model.addRow(new Object[] {Book_ID,Book_Name,Book_Author,Publication_Date,Book_Type});
						
			}
					}
				catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnReset.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		btnReset.setBounds(271, 218, 127, 24);
		panel.add(btnReset);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 853, 253);
		panel.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/studentbook.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 250, 853, 247);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 833, 223);
		panel_1.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/studentbook.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(0, 0, 853, 257);
		panel_1.add(lblNewLabel_1);
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel   model1 = (DefaultTableModel) table.getModel();
			    int SelectedRows = table.getSelectedRow();
			    
			  textname.setText(model1.getValueAt(SelectedRows, 2).toString());
				textid.setText(model1.getValueAt(SelectedRows, 1).toString());
				textauthor .setText(model1.getValueAt(SelectedRows, 3).toString());
				textdate .setText(model1.getValueAt(SelectedRows, 4).toString());
				texttype.setText(model1.getValueAt(SelectedRows, 5).toString());
				id=textid.getText();
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"Book_Id","Book_Name", "Book_Author", "Publication_Date", "Book_Type"};
		final Object[] row =new Object[7];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		try {
			String quary ="select * from Book;";
			pst = con.prepareStatement(quary);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			String Book_ID,Book_Name, Book_Author, Publication_Date,Book_Type;
			while(rs.next()) {
				Book_ID=rs.getString(1);
				Book_Name=rs.getString(2);
				Book_Author=rs.getString(3);
				Publication_Date=rs.getString(4);
				Book_Type=rs.getString(5);
				
				 model.addRow(new Object[] {Book_ID,Book_Name,Book_Author,Publication_Date,Book_Type});
				
	}
			}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		id=textid.getText();
		
		
	}
}
