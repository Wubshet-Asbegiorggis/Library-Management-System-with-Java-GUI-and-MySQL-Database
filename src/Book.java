package trial;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TextAction;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Book extends JFrame {

	private JPanel contentPane,panel_1;
	private JTextField textid;
	private JTextField textname;
	private JTextField textauthor;
	private JTextField textdate;
	private JTextField texttype;
	private JTextField textprice;
	private JTextField textno;
	private JTable table;
	private JTextArea textdescription;
	/**
	 * Launch the application.
	 */
     DefaultTableModel model;
	Connection con ;
	PreparedStatement pst ;
	ResultSet rs ;
	
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
				
				JOptionPane.showMessageDialog(null, "Record is " +message );
				
				textid.setText("");
				textname.setText("");
				textauthor.setText("");
				textdate.setText("");
				texttype.setText("");
				textprice.setText("");
				textdescription.setText("");
				textno.setText("");
				
			}else {
				JOptionPane.showMessageDialog(null, "Record  not "+ message );
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	
	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book frame = new Book();
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
	public Book() {
		setTitle("Book Information");
		Image icon = new ImageIcon(this.getClass().getResource("/icon.jpg")).getImage();
		setIconImage(icon);
		conect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1029, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(1, 0, 1007, 247);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel ilbl = new JLabel("Book_Id");
		ilbl.setForeground(Color.WHITE);
		ilbl.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		ilbl.setBounds(10, 11, 84, 24);
		panel.add(ilbl);
		
		JLabel Nlbl = new JLabel("Books_name");
		Nlbl.setForeground(Color.WHITE);
		Nlbl.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		Nlbl.setBounds(10, 45, 111, 24);
		panel.add(Nlbl);
		
		JLabel Albl = new JLabel("Book_author");
		Albl.setForeground(Color.WHITE);
		Albl.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		Albl.setBounds(10, 80, 111, 24);
		panel.add(Albl);
		
		JLabel Dlbl = new JLabel("Publication_date");
		Dlbl.setForeground(Color.WHITE);
		Dlbl.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		Dlbl.setBounds(10, 111, 139, 24);
		panel.add(Dlbl);
		
		JLabel Tlbl = new JLabel("Book_type");
		Tlbl.setForeground(Color.WHITE);
		Tlbl.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		Tlbl.setBounds(10, 144, 84, 24);
		panel.add(Tlbl);
		
		JLabel Plbl = new JLabel("Book_price");
		Plbl.setForeground(Color.WHITE);
		Plbl.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		Plbl.setBounds(10, 177, 84, 24);
		panel.add(Plbl);
		
		JLabel lblBookdescription = new JLabel("Book_description");
		lblBookdescription.setForeground(Color.WHITE);
		lblBookdescription.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblBookdescription.setBounds(383, 35, 139, 24);
		panel.add(lblBookdescription);
		
		textid = new JTextField();
		textid.setBounds(131, 13, 222, 22);
		panel.add(textid);
		textid.setColumns(10);
		
		textname = new JTextField();
		textname.setBounds(131, 46, 222, 22);
		panel.add(textname);
		textname.setColumns(10);
		
		textauthor = new JTextField();
		textauthor.setColumns(10);
		textauthor.setBounds(131, 79, 222, 22);
		panel.add(textauthor);
		
		textdate = new JTextField();
		textdate.setColumns(10);
		textdate.setBounds(166, 112, 187, 22);
		panel.add(textdate);
		
		texttype = new JTextField();
		texttype.setColumns(10);
		texttype.setBounds(131, 145, 222, 22);
		panel.add(texttype);
		
		textprice = new JTextField();
		textprice.setColumns(10);
		textprice.setBounds(131, 178, 222, 22);
		panel.add(textprice);
		
		textdescription = new JTextArea();
		textdescription.setBounds(520, 13, 197, 59);
		
		
		JButton btnADD = new JButton("ADD");
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textid.requestFocus(); 
				String query ="insert into  Book(Book_Id,Book_Name, Book_Author, Publication_Date, Book_Type, Book_Price,Total_No,Book_description)values('"+textid.getText()+"','"
	                      +textname.getText()+"','"+textauthor.getText()+"','"+textdate.getText()+"','"+texttype.getText()+"','"+textprice.getText()+"','"+textdescription.getText()+"')";
					 excequteSql(query,"Add succucefully");
					conect();		
			}
		});
		btnADD.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnADD.setBounds(783, 8, 97, 31);
		panel.add(btnADD);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quary="select  Book_Id,Book_Name, Book_Author, Publication_Date, Book_Type, Book_Price,Total_No,Book_description from Book  where Book_ID='"+textid.getText()+"';";
				 
				try {
					pst = con.prepareStatement(quary);
					rs = pst.executeQuery();
					
					String Book_ID,Book_Name, Book_Author, Publication_Date, Book_Type, Book_Price,Total_No,Book_description;
					while(rs.next()) {
						Book_ID=rs.getString(1);
						Book_Name=rs.getString(2);
						Book_Author=rs.getString(3);
						Publication_Date=rs.getString(4);
						Book_Type=rs.getString(5);
						Book_Price=rs.getString(6);
						Total_No=rs.getString(7);
						Book_description=rs.getString(8);
						
			 
						textid.setText(Book_ID);
						textname.setText(Book_Name);
						textauthor.setText(Book_Author);
						textdate.setText(Publication_Date);
						texttype.setText(Book_Type);
						textprice.setText(Book_Price);
						textno.setText(Total_No);
						textdescription.setText(Book_description);
					
			}
					}
				catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
					
				}
			}
		});
		btnSearch.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnSearch.setBounds(783, 42, 97, 31);
		panel.add(btnSearch);
		
		JButton btnCheack = new JButton("CHEACK");
		btnCheack.setFont(new Font("Sylfaen", Font.ITALIC, 15));
		btnCheack.setBounds(783, 174, 97, 31);
		panel.add(btnCheack);
		
		JButton btnNAME = new JButton("UPDATE");
		btnNAME.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                   conect();
              
				String quary="update Book set   Book_Name='"+textname.getText()+"',Book_Price='"+textprice.getText()+"',Book_Description='"+textdescription.getText()+"'"
						+ ",Book_Author='"+textauthor.getText()+"', Publication_date='"+textdate.getText()+"',Total_No='"+textno.getText()+"', Book_Type='"+texttype.getText()+"' where Book_ID ='"+textid.getText()+"';";
				 excequteSql(quary,"updated succucefully");
			
			}
		});
		btnNAME.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnNAME.setBounds(783, 84, 97, 31);
		panel.add(btnNAME);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quary ="Delete from Book where Book_ID='"+textid.getText()+"'";
				excequteSql(quary,"Deleted succucefully");
			}
		});
		btnDelete.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnDelete.setBounds(783, 126, 97, 31);
		panel.add(btnDelete);
		
		JButton btnNewButton_5 = new JButton("Clear");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textno.setText("");
				textname.setText("");
				textid.setText("");
				textauthor.setText("");
				textdate.setText("");
				textprice.setText("");
				texttype.setText("");
				textdescription.setText("");
			}
		});
		btnNewButton_5.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnNewButton_5.setBounds(783, 216, 97, 31);
		panel.add(btnNewButton_5);
		
		
		
		panel.add(textdescription);
		
		textno = new JTextField();
		textno.setColumns(10);
		textno.setBounds(166, 211, 187, 22);
		panel.add(textno);
		
		JLabel lblTotalbook = new JLabel("TOTAL_BOOK");
		lblTotalbook.setForeground(Color.WHITE);
		lblTotalbook.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblTotalbook.setBounds(10, 212, 128, 24);
		panel.add(lblTotalbook);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin L = new admin();
				L.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnNewButton.setBounds(919, 81, 78, 23);
		panel.add(btnNewButton);
		
		JButton btnexit = new JButton("EXIT");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("EXIT");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want Exite","EXIT",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}}
		});
		btnexit.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		btnexit.setBounds(919, 112, 78, 23);
		panel.add(btnexit);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/book3.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 1007, 247);
		panel.add(lblNewLabel);
		
		
		
		
	    panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(3, 3, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(1, 249, 1007, 227);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel rt = (DefaultTableModel)table.getModel();
				int se =table.getSelectedRow();
				textid.setText(rt.getValueAt(se,1).toString());
				textname.setText(rt.getValueAt(se,2).toString());
				textauthor.setText(rt.getValueAt(se,3).toString());
				textdate.setText(rt.getValueAt(se,4).toString());
				textprice.setText(rt.getValueAt(se,5).toString());
				textno.setText(rt.getValueAt(se,6).toString());
				textdescription.setText(rt.getValueAt(se,7).toString());
				
			}
		});
		scrollPane.setBounds(10, 11, 987, 205);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel rt = (DefaultTableModel)table.getModel();
				int se =table.getSelectedRow();
				textid.setText(rt.getValueAt(se,1).toString());
				textname.setText(rt.getValueAt(se,2).toString());
				textauthor.setText(rt.getValueAt(se,3).toString());
				textdate.setText(rt.getValueAt(se,4).toString());
				texttype.setText(rt.getValueAt(se,5).toString());
				textprice.setText(rt.getValueAt(se,6).toString());
				textno.setText(rt.getValueAt(se,8).toString());
				textdescription.setText(rt.getValueAt(se,7).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Book_Id", "Book_Name", "Book_Author", "Publication date", "Book_Type", "Book_Price", "Total_No", "Description"
			}
		));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 1007, 227);
		Image img1 = new ImageIcon(this.getClass().getResource("/book3.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img1));
		panel_1.add(lblNewLabel_2);
		
		
		try {
			String quary ="select * from Book;";
			pst = con.prepareStatement(quary);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			String Book_Id,Book_Name, Book_Author, Publication_Date, Book_Type, Book_Price,Total_No,Book_description;
			while(rs.next()) {
				 Book_Id=rs.getString(1);
				 Book_Name=rs.getString(2);
				 Book_Author=rs.getString(3);
				 Publication_Date=rs.getString(4);
				 Book_Type=rs.getString(5);
				 Book_Price=rs.getString(6);
				 Total_No=rs.getString(7);
				 Book_description=rs.getString(7);
				
				
				 model.addRow(new Object[] {Book_Id,Book_Name, Book_Author, Publication_Date, Book_Type, Book_Price,Total_No,Book_description});
				
	}
			}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
