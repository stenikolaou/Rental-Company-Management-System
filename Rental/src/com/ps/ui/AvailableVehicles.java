package com.ps.ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class AvailableVehicles extends JFrame {

	private JPanel contentPane;
	private JTable availableVehTable;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public AvailableVehicles() {
		setTitle("Available Vehicles");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AvailableVehicles.class.getResource("/AvailableCar16-icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(147, 112, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 65, 1010, 510);
		contentPane.add(scrollPane);
		
		availableVehTable = new JTable();
		scrollPane.setViewportView(availableVehTable);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(AvailableVehicles.class.getResource("/Close16-icon.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(442, 20, 150, 35);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("Copyright");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setBounds(392, 586, 64, 25);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel = new JLabel("Stefanos Nikolaou, 2020");
		lblNewLabel.setIcon(new ImageIcon(AvailableVehicles.class.getResource("/Copyright16-icon.png")));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 12));
		lblNewLabel.setBounds(459, 586, 173, 25);
		contentPane.add(lblNewLabel);
	}
}
