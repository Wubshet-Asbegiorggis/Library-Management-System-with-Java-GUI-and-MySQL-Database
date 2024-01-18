package trial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class image extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					image frame = new image();
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
	public image() {
		setTitle("LIBRARY MANAGEMENT SYSTEM");
		Image icon = new ImageIcon(this.getClass().getResource("/icon.jpg")).getImage();
		setIconImage(icon);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 724, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 43, 715, 323);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnstuent = new JButton("Student");
		btnstuent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user u = new user();
				u.setVisible(true);
				dispose();
			}
		});
		btnstuent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnstuent.setBounds(538, 126, 109, 26);
		panel.add(btnstuent);
		
		JButton btnLibrarian = new JButton("Librarian");
		btnLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin a = new admin();
				a.setVisible(true);
				dispose();
				
			}
		});
		btnLibrarian.setForeground(Color.BLACK);
		btnLibrarian.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		btnLibrarian.setAlignmentX(1.0f);
		btnLibrarian.setBounds(68, 125, 119, 28);
		panel.add(btnLibrarian);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 714, 323);
		Image img = new ImageIcon(this.getClass().getResource("/image.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		panel.add(lblNewLabel);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 1, 715, 41);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Label1 = new JLabel("Library Management System");
		Label1.setBounds(204, 11, 314, 20);
		Label1.setForeground(Color.BLACK);
		Label1.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 20));
		Label1.setBackground(Color.WHITE);
		panel_1.add(Label1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/image2.jpg")).getImage();
		lblNewLabel_1 .setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(0, 0, 715, 41);
		panel_1.add(lblNewLabel_1);
	}
}
