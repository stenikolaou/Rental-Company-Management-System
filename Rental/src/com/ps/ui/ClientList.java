package com.ps.ui;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ClientList extends JFrame {

	private JPanel contentPane;
	static JTable clientListTable;

	/**
	 * Create the frame.
	 */
	public ClientList() {
		setTitle("Client list");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientList.class.getResource("/Clients16-icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 65, 1010, 510);
		contentPane.add(scrollPane);
		
		clientListTable = new JTable();
		scrollPane.setViewportView(clientListTable);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setBounds(392, 586, 64, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Stefanos Nikolaou, 2020");
		lblNewLabel.setIcon(new ImageIcon(ClientList.class.getResource("/Copyright16-icon.png")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 12));
		lblNewLabel.setBounds(459, 586, 173, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setIcon(new ImageIcon(ClientList.class.getResource("/Close16-icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(442, 20, 150, 35);
		contentPane.add(btnNewButton);
	}

}
