package com.ps.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

@SuppressWarnings("serial")
public class ControlPanel extends JFrame {
	
	private JPanel contentPane;
	private JTextField cityIdTf;
	private JTextField cityNameTf;
	private JTable vehicleTable;
	private JTable clientTable;
	private JTable rentalTable;
	private JTextField storeIdTf;
	private JTextField storeNameTf;
	private JTable cityTable;
	private JTable storeTable;
	private JTextField vehicleLicenceNoTf;
	private JTextField clientIdTf;
	private JTextField clientNameTf;
	private JTextField clientSurnameTf;
	private JTextField clientDrivingLicenceTf;
	private JTextField clientAdressTf;
	private JTextField clientEmailTf;
	private JTextField clientTelephoneNoTf;
	private JTextField vehicleModelTf;
	private JTextField vehicleCapacityTf;
	private JTextField vehicleRentalCostTf;
	private JTextField cityIdTf2;
	private JTextField vehicleSeatHeightTF;
	private JTextField vehicleLuggageSupportTf;
	private JTextField vehicleDoorNumberTf;
	private JTextField vehicleSeatNoTf;
	private JTextField rentalIdTf;
	private JTextField storeIdTf2;
	private JTextField vehicleFuelTf;
	private JTextField vehicleTypeTf;
	private JTextField vehicleLicenceNoTf2;
	private JTextField clientIdTf2;
	private JTextField rentalPickupLocationTf;
	private JTextField rentalReturnLocationTf;
	private JTextField rentalTotalCostTf;
	private JTextField generalTypeTf;
	private JTextField rentalPickupDateTf;
	private JTextField rentalReturnDateTf;
			
	public ControlPanel() {
						
		setIconImage(Toolkit.getDefaultToolkit().getImage(ControlPanel.class.getResource("/Panel16-icon.png")));
		setTitle("Admin Control Panel");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1155, 751);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabbedPane.setBounds(10, 42, 1120, 639);
		contentPane.add(tabbedPane);
		
		JPanel citypanel = new JPanel();
		citypanel.setBackground(new Color(47, 79, 79));
		tabbedPane.addTab("Cities", null, citypanel, null);
		citypanel.setLayout(null);
		
		JScrollPane cityScrollPane = new JScrollPane();
		cityScrollPane.setBounds(254, 10, 850, 528);
		citypanel.add(cityScrollPane);
		
		cityTable = new JTable();
		cityTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)cityTable.getModel();
				int rowIndex = cityTable.getSelectedRow();
				
				cityIdTf.setText(model.getValueAt(rowIndex, 0).toString());
				cityNameTf.setText(model.getValueAt(rowIndex, 1).toString());
			}
		});
		cityTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cityTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		cityScrollPane.setViewportView(cityTable);
		
		JPanel panel = new JPanel();
		panel.setBounds(230, 269, -216, -231);
		citypanel.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(956, 556, -847, -248);
		citypanel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(254, 549, 850, 45);
		citypanel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton addCityBtn = new JButton("Add");
		addCityBtn.setBounds(50, 5, 150, 35);
		panel_2.add(addCityBtn);
		addCityBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addCityBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Add16-icon.png")));
		
		JButton deleteCityBtn = new JButton("Delete");
		deleteCityBtn.setBounds(250, 5, 150, 35);
		panel_2.add(deleteCityBtn);
		deleteCityBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteCityBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Delete16-icon.png")));
		
		JButton viewCitiesBtn = new JButton("View");
		viewCitiesBtn.setBounds(450, 5, 150, 35);
		panel_2.add(viewCitiesBtn);
		viewCitiesBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewCitiesBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/View16-icon.png")));
		
		JButton updateCityBtn = new JButton("Update");
		updateCityBtn.setBounds(650, 5, 150, 35);
		panel_2.add(updateCityBtn);
		updateCityBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateCityBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Update16-icon.png")));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBounds(10, 10, 230, 166);
		citypanel.add(panel_5);
		panel_5.setLayout(null);
		
		cityNameTf = new JTextField();
		cityNameTf.setBounds(15, 121, 200, 35);
		panel_5.add(cityNameTf);
		cityNameTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cityNameTf.setColumns(10);
		
		JLabel cityIdLbl = new JLabel("City Id");
		cityIdLbl.setBounds(15, 11, 85, 25);
		panel_5.add(cityIdLbl);
		cityIdLbl.setForeground(new Color(255, 255, 255));
		cityIdLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		cityIdTf = new JTextField();
		cityIdTf.setBounds(15, 43, 200, 35);
		panel_5.add(cityIdTf);
		cityIdTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cityIdTf.setColumns(10);
		
		JLabel cityNameLbl = new JLabel("City Name");
		cityNameLbl.setBounds(15, 89, 100, 25);
		panel_5.add(cityNameLbl);
		cityNameLbl.setForeground(new Color(255, 255, 255));
		cityNameLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton clearCityBtn = new JButton("Clear");
		clearCityBtn.setBounds(55, 187, 140, 35);
		citypanel.add(clearCityBtn);
		clearCityBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cityIdTf.setText(null);
				cityNameTf.setText(null);
			}
		});
		clearCityBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Clear16-icon.png")));
		clearCityBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		addCityBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == addCityBtn) {
					try {
						URL url = new URL ("http://localhost:8080/RentalCompany/cities/create?cityId="+cityIdTf.getText()+"&cityName="+cityNameTf.getText()+"");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("POST");
						conn.setRequestProperty("Accept", "application/json");
						
						if (conn.getResponseCode()!=200) {
							throw new RuntimeException("Failed: HTTP error code: "+conn.getResponseCode());
						}
						
						BufferedReader br = new BufferedReader (new InputStreamReader(conn.getInputStream()));
						
						@SuppressWarnings("unused")
						String output;
						System.out.println("Outptut from Server... \n");
						while ((output=br.readLine())!=null) {
							JOptionPane.showMessageDialog(getContentPane(), "City inserted to DB");
						}
						conn.disconnect();
					} catch (MalformedURLException me) {
				} catch(IOException me) {
					me.printStackTrace();
				}
			}
			}
		});
		
		deleteCityBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == deleteCityBtn) {
					int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this city?", "Delete", JOptionPane.YES_NO_OPTION);
					if(p==0) {
					try {
						URL url = new URL ("http://localhost:8080/RentalCompany/cities/delete?cityId="+cityIdTf.getText()+"");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("DELETE");
						conn.setRequestProperty("Accept", "application/json");
						
						if (conn.getResponseCode()!=200) {
							throw new RuntimeException("Failed: HTTP error code: "+conn.getResponseCode());
						}
											
						@SuppressWarnings("unused")
						BufferedReader br = new BufferedReader (new InputStreamReader(conn.getInputStream()));
						
						JOptionPane.showMessageDialog(getContentPane(), "Successfully deleted city");	
						conn.disconnect();
					} catch (MalformedURLException me) {
						
				} catch(IOException me) {
					me.printStackTrace();
				}
			}
			}
			}
		});
		
		viewCitiesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentaldb","root","");
					String sql="Select * from city";
					java.sql.PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					cityTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		
		updateCityBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == updateCityBtn) {
					try {
						URL url = new URL ("http://localhost:8080/RentalCompany/cities/update?cityId="+cityIdTf.getText()+"&cityName="+cityNameTf.getText()+"");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("PUT");
						conn.setRequestProperty("Accept", "application/json");
						
						if (conn.getResponseCode()!=200) {
							throw new RuntimeException("Failed: HTTP error code: "+conn.getResponseCode());
						}
						
						BufferedReader br = new BufferedReader (new InputStreamReader(conn.getInputStream()));
						
						@SuppressWarnings("unused")
						String output;
						System.out.println("Outptut from Server... \n");
						while ((output=br.readLine())!=null) {
							JOptionPane.showMessageDialog(getContentPane(), "City successfully updated");
						}
						conn.disconnect();
					} catch (MalformedURLException me) {
				} catch(IOException me) {
					me.printStackTrace();
				}
			}
			}
		});
						
		JPanel storepanel = new JPanel();
		storepanel.setBackground(new Color(47, 79, 79));
		tabbedPane.addTab("Stores", null, storepanel, null);
		storepanel.setLayout(null);
		
		JScrollPane storeScrollPane = new JScrollPane();
		storeScrollPane.setBounds(254, 10, 850, 528);
		storepanel.add(storeScrollPane);
		
		storeTable = new JTable();
		storeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)storeTable.getModel();
				int rowIndex = storeTable.getSelectedRow();
				
				storeIdTf.setText(model.getValueAt(rowIndex, 0).toString());
				cityIdTf2.setText(model.getValueAt(rowIndex, 1).toString());
				storeNameTf.setText(model.getValueAt(rowIndex, 2).toString());
			}
		});
		storeTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		storeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		storeScrollPane.setViewportView(storeTable);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setLayout(null);
		panel_3.setBounds(254, 549, 850, 45);
		storepanel.add(panel_3);
		
		JButton addStoreBtn = new JButton("Add");
		addStoreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cityid = cityIdTf2.getText();
				if (e.getSource() == addStoreBtn && cityid.equals("ATH")) {
					try {
						URL url = new URL ("http://localhost:8080/RentalCompany/stores/createATH?storeId="+storeIdTf.getText()+"&storeName="+storeNameTf.getText()+"");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("POST");
						conn.setRequestProperty("Accept", "application/json");
						
						if (conn.getResponseCode()!=200) {
							throw new RuntimeException("Failed: HTTP error code: "+conn.getResponseCode());
						}
						
						BufferedReader br = new BufferedReader (new InputStreamReader(conn.getInputStream()));
						
						@SuppressWarnings("unused")
						String output;
						System.out.println("Outptut from Server... \n");
						while ((output=br.readLine())!=null) {
							JOptionPane.showMessageDialog(getContentPane(), "Store inserted to DB");
						}
						conn.disconnect();
					} catch (MalformedURLException me) {
				} catch(IOException me) {
					me.printStackTrace();
				}
			}
				if (e.getSource() == addStoreBtn && cityid.equals("SKG")) {
					try {
						URL url = new URL ("http://localhost:8080/RentalCompany/stores/createSKG?storeId="+storeIdTf.getText()+"&storeName="+storeNameTf.getText()+"");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("POST");
						conn.setRequestProperty("Accept", "application/json");
						
						if (conn.getResponseCode()!=200) {
							throw new RuntimeException("Failed: HTTP error code: "+conn.getResponseCode());
						}
						
						BufferedReader br = new BufferedReader (new InputStreamReader(conn.getInputStream()));
						
						@SuppressWarnings("unused")
						String output;
						System.out.println("Outptut from Server... \n");
						while ((output=br.readLine())!=null) {
							JOptionPane.showMessageDialog(getContentPane(), "Store inserted to DB");
						}
						conn.disconnect();
					} catch (MalformedURLException me) {
				} catch(IOException me) {
					me.printStackTrace();
				}
			}
			}
		});
		addStoreBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Add16-icon.png")));
		addStoreBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addStoreBtn.setBounds(50, 5, 150, 35);
		panel_3.add(addStoreBtn);
		
		JButton deleteStoreBtn = new JButton("Delete");
		deleteStoreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == deleteStoreBtn) {
					int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this store?", "Delete", JOptionPane.YES_NO_OPTION);
					if(p==0) {
					try {
						URL url = new URL ("http://localhost:8080/RentalCompany/stores/delete?storeId="+storeIdTf.getText()+"");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("DELETE");
						conn.setRequestProperty("Accept", "application/json");
						
						if (conn.getResponseCode()!=200) {
							throw new RuntimeException("Failed: HTTP error code: "+conn.getResponseCode());
						}
						
						@SuppressWarnings("unused")
						BufferedReader br = new BufferedReader (new InputStreamReader(conn.getInputStream()));
						
						JOptionPane.showMessageDialog(getContentPane(), "Successfully deleted store");
							
						conn.disconnect();
					} catch (MalformedURLException me) {
				} catch(IOException me) {
					me.printStackTrace();
				}
			}
			}
			}
		});
		deleteStoreBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Delete16-icon.png")));
		deleteStoreBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteStoreBtn.setBounds(250, 5, 150, 35);
		panel_3.add(deleteStoreBtn);
		
		JButton viewStoresBtn = new JButton("View");
		viewStoresBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentaldb","root","");
					String sql="Select * from store";
					java.sql.PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					storeTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		viewStoresBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/View16-icon.png")));
		viewStoresBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewStoresBtn.setBounds(450, 5, 150, 35);
		panel_3.add(viewStoresBtn);
		
		JButton updateStoreBtn = new JButton("Update");
		updateStoreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == updateStoreBtn) {
					try {
						URL url = new URL ("http://localhost:8080/RentalCompany/stores/update?storeId="+storeIdTf.getText()+"&storeName="+storeNameTf.getText()+"");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("PUT");
						conn.setRequestProperty("Accept", "application/json");
						
						if (conn.getResponseCode()!=200) {
							throw new RuntimeException("Failed: HTTP error code: "+conn.getResponseCode());
						}
						
						BufferedReader br = new BufferedReader (new InputStreamReader(conn.getInputStream()));
						
						@SuppressWarnings("unused")
						String output;
						System.out.println("Outptut from Server... \n");
						while ((output=br.readLine())!=null) {
							JOptionPane.showMessageDialog(getContentPane(), "Store successfully updated");
						}
						conn.disconnect();
					} catch (MalformedURLException me) {
				} catch(IOException me) {
					me.printStackTrace();
				}
			}
			}
		});
		updateStoreBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Update16-icon.png")));
		updateStoreBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateStoreBtn.setBounds(650, 5, 150, 35);
		panel_3.add(updateStoreBtn);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBounds(10, 10, 230, 226);
		storepanel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel storeIdLbl = new JLabel("Store Id");
		storeIdLbl.setBounds(15, 6, 120, 25);
		panel_6.add(storeIdLbl);
		storeIdLbl.setForeground(new Color(255, 255, 255));
		storeIdLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		storeIdTf = new JTextField();
		storeIdTf.setBounds(15, 37, 200, 35);
		panel_6.add(storeIdTf);
		storeIdTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		storeIdTf.setColumns(10);
		
		JLabel cityIdLbl2 = new JLabel("City Id");
		cityIdLbl2.setBounds(15, 78, 120, 25);
		panel_6.add(cityIdLbl2);
		cityIdLbl2.setForeground(new Color(255, 255, 255));
		cityIdLbl2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		cityIdTf2 = new JTextField();
		cityIdTf2.setBounds(15, 109, 200, 35);
		panel_6.add(cityIdTf2);
		cityIdTf2.setToolTipText("ATH - Athens, SKG - Thessaloniki");
		cityIdTf2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cityIdTf2.setColumns(10);
		
		JLabel storeNameLbl = new JLabel("Store Name");
		storeNameLbl.setBounds(15, 150, 100, 25);
		panel_6.add(storeNameLbl);
		storeNameLbl.setForeground(new Color(255, 255, 255));
		storeNameLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		storeNameTf = new JTextField();
		storeNameTf.setBounds(15, 181, 200, 35);
		panel_6.add(storeNameTf);
		storeNameTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		storeNameTf.setColumns(10);
		
		JButton clearStoreBtn = new JButton("Clear");
		clearStoreBtn.setBounds(55, 247, 140, 35);
		storepanel.add(clearStoreBtn);
		clearStoreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				storeIdTf.setText(null);
				cityIdTf2.setText(null);
				storeNameTf.setText(null);
			}
		});
		clearStoreBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Clear16-icon.png")));
		clearStoreBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel clientpanel = new JPanel();
		clientpanel.setBackground(new Color(47, 79, 79));
		tabbedPane.addTab("Clients", null, clientpanel, null);
		clientpanel.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(254, 10, 850, 528);
		clientpanel.add(scrollPane_3);
		
		clientTable = new JTable();
		clientTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)clientTable.getModel();
				int rowIndex = clientTable.getSelectedRow();
				
				clientIdTf.setText(model.getValueAt(rowIndex, 0).toString());
				clientNameTf.setText(model.getValueAt(rowIndex, 1).toString());
				clientSurnameTf.setText(model.getValueAt(rowIndex, 2).toString());
				clientDrivingLicenceTf.setText(model.getValueAt(rowIndex, 3).toString());
				clientAdressTf.setText(model.getValueAt(rowIndex, 4).toString());
				clientEmailTf.setText(model.getValueAt(rowIndex, 5).toString());
				clientTelephoneNoTf.setText(model.getValueAt(rowIndex, 6).toString());
			}
		});
		clientTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clientTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_3.setViewportView(clientTable);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(254, 549, 850, 45);
		panel_4.setLayout(null);
		clientpanel.add(panel_4);
		
		JButton addClientBtn = new JButton("Add");
		addClientBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == addClientBtn) {
					try {
						URL url = new URL ("http://localhost:8080/RentalCompany/clients/create?clientId="+clientIdTf.getText()+"&clientName="+clientNameTf.getText()+""
								+ "&clientSurname="+clientSurnameTf.getText()+"&clientDrivingLicense="+clientDrivingLicenceTf.getText()+"&clientAdress="+clientAdressTf.getText()+
								"&clientEmail="+clientEmailTf.getText()+"&clientTelephoneNo="+clientTelephoneNoTf.getText()+"");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("POST");
						conn.setRequestProperty("Accept", "application/json");
						
						if (conn.getResponseCode()!=200) {
							throw new RuntimeException("Failed: HTTP error code: "+conn.getResponseCode());
						}
						
						BufferedReader br = new BufferedReader (new InputStreamReader(conn.getInputStream()));
						
						@SuppressWarnings("unused")
						String output;
						System.out.println("Outptut from Server... \n");
						while ((output=br.readLine())!=null) {
							JOptionPane.showMessageDialog(getContentPane(), "Client inserted to DB");
						}
						conn.disconnect();
					} catch (MalformedURLException me) {
				} catch(IOException me) {
					me.printStackTrace();
				}
			}
			}
		});
		addClientBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Add16-icon.png")));
		addClientBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addClientBtn.setBounds(50, 5, 150, 35);
		panel_4.add(addClientBtn);
		
		JButton deleteClientBtn = new JButton("Delete");
		deleteClientBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == deleteClientBtn) {
					int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this client?", "Delete", JOptionPane.YES_NO_OPTION);
					if(p==0) {
					try {
						
						URL url = new URL ("http://localhost:8080/RentalCompany/clients/delete?clientId="+clientIdTf.getText()+"");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("DELETE");
						conn.setRequestProperty("Accept", "application/json");
						
						if (conn.getResponseCode()!=200) {
							throw new RuntimeException("Failed: HTTP error code: "+conn.getResponseCode());
						}
						
						@SuppressWarnings("unused")
						BufferedReader br = new BufferedReader (new InputStreamReader(conn.getInputStream()));
											
						JOptionPane.showMessageDialog(null, "Successfully deleted client");
					
						conn.disconnect();
					} catch (MalformedURLException me) {
				} catch(IOException me) {
					me.printStackTrace();
				}
			}
			}
			}
		});
		deleteClientBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Delete16-icon.png")));
		deleteClientBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteClientBtn.setBounds(250, 5, 150, 35);
		panel_4.add(deleteClientBtn);
		
		JButton viewClientsBtn = new JButton("View");
		viewClientsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentaldb","root","");
					String sql="Select * from client";
					java.sql.PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					clientTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		viewClientsBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/View16-icon.png")));
		viewClientsBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewClientsBtn.setBounds(450, 5, 150, 35);
		panel_4.add(viewClientsBtn);
		
		JButton updateClientBtn = new JButton("Update");
		updateClientBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == updateClientBtn) {
					try {
						URL url = new URL ("http://localhost:8080/RentalCompany/clients/update?clientId="+clientIdTf.getText()+"&clientName="+clientNameTf.getText()+""
								+ "&clientSurname="+clientSurnameTf.getText()+"&clientDrivingLicense="+clientDrivingLicenceTf.getText()+"&clientAdress="+clientAdressTf.getText()+
								"&clientEmail="+clientEmailTf.getText()+"&clientTelephoneNo="+clientTelephoneNoTf.getText()+"");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("PUT");
						conn.setRequestProperty("Accept", "application/json");
						
						if (conn.getResponseCode()!=200) {
							throw new RuntimeException("Failed: HTTP error code: "+conn.getResponseCode());
						}
						
						BufferedReader br = new BufferedReader (new InputStreamReader(conn.getInputStream()));
						
						@SuppressWarnings("unused")
						String output;
						System.out.println("Outptut from Server... \n");
						while ((output=br.readLine())!=null) {
							JOptionPane.showMessageDialog(getContentPane(), "Client successfully updated");
						}
						conn.disconnect();
					} catch (MalformedURLException me) {
				} catch(IOException me) {
					me.printStackTrace();
				}
			}
			}
		});
		updateClientBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Update16-icon.png")));
		updateClientBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateClientBtn.setBounds(650, 5, 150, 35);
		panel_4.add(updateClientBtn);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.setBounds(10, 11, 230, 527);
		clientpanel.add(panel_7);
		panel_7.setLayout(null);
		
		clientIdTf = new JTextField();
		clientIdTf.setBounds(15, 39, 200, 35);
		panel_7.add(clientIdTf);
		clientIdTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clientIdTf.setColumns(10);
		
		clientNameTf = new JTextField();
		clientNameTf.setBounds(15, 113, 200, 35);
		panel_7.add(clientNameTf);
		clientNameTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clientNameTf.setColumns(10);
		
		clientSurnameTf = new JTextField();
		clientSurnameTf.setBounds(15, 187, 200, 35);
		panel_7.add(clientSurnameTf);
		clientSurnameTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clientSurnameTf.setColumns(10);
		
		clientDrivingLicenceTf = new JTextField();
		clientDrivingLicenceTf.setBounds(15, 261, 200, 35);
		panel_7.add(clientDrivingLicenceTf);
		clientDrivingLicenceTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clientDrivingLicenceTf.setColumns(10);
		
		clientAdressTf = new JTextField();
		clientAdressTf.setBounds(15, 335, 200, 35);
		panel_7.add(clientAdressTf);
		clientAdressTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clientAdressTf.setColumns(10);
		
		clientEmailTf = new JTextField();
		clientEmailTf.setBounds(15, 409, 200, 35);
		panel_7.add(clientEmailTf);
		clientEmailTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clientEmailTf.setColumns(10);
		
		clientTelephoneNoTf = new JTextField();
		clientTelephoneNoTf.setBounds(15, 483, 200, 35);
		panel_7.add(clientTelephoneNoTf);
		clientTelephoneNoTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clientTelephoneNoTf.setColumns(10);
		
		JLabel clientIdLbl = new JLabel("Client Id");
		clientIdLbl.setBounds(15, 7, 120, 25);
		panel_7.add(clientIdLbl);
		clientIdLbl.setForeground(new Color(255, 255, 255));
		clientIdLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblClientName = new JLabel("Client name");
		lblClientName.setBounds(15, 81, 120, 25);
		panel_7.add(lblClientName);
		lblClientName.setForeground(new Color(255, 255, 255));
		lblClientName.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblClientSurname = new JLabel("Client Surname");
		lblClientSurname.setBounds(15, 155, 150, 25);
		panel_7.add(lblClientSurname);
		lblClientSurname.setForeground(new Color(255, 255, 255));
		lblClientSurname.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblClientDrivingLicence = new JLabel("Client Driving Licence");
		lblClientDrivingLicence.setBounds(15, 229, 205, 25);
		panel_7.add(lblClientDrivingLicence);
		lblClientDrivingLicence.setForeground(new Color(255, 255, 255));
		lblClientDrivingLicence.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblClientAdress = new JLabel("Client Adress");
		lblClientAdress.setBounds(15, 303, 120, 25);
		panel_7.add(lblClientAdress);
		lblClientAdress.setForeground(new Color(255, 255, 255));
		lblClientAdress.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblClientEmail = new JLabel("Client Email");
		lblClientEmail.setBounds(15, 377, 120, 25);
		panel_7.add(lblClientEmail);
		lblClientEmail.setForeground(new Color(255, 255, 255));
		lblClientEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblClientTelephoneNo = new JLabel("Client Telephone No");
		lblClientTelephoneNo.setBounds(15, 451, 205, 25);
		panel_7.add(lblClientTelephoneNo);
		lblClientTelephoneNo.setForeground(new Color(255, 255, 255));
		lblClientTelephoneNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton clearClientBtn = new JButton("Clear");
		clearClientBtn.setBounds(55, 549, 140, 35);
		clientpanel.add(clearClientBtn);
		clearClientBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientIdTf.setText(null);
				clientNameTf.setText(null);
				clientSurnameTf.setText(null);
				clientDrivingLicenceTf.setText(null);
				clientAdressTf.setText(null);
				clientEmailTf.setText(null);
				clientTelephoneNoTf.setText(null);
			}
		});
		clearClientBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Clear16-icon.png")));
		clearClientBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel vehiclepanel = new JPanel();
		vehiclepanel.setBackground(new Color(47, 79, 79));
		tabbedPane.addTab("Vehicles", null, vehiclepanel, null);
		vehiclepanel.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(254, 10, 850, 528);
		vehiclepanel.add(scrollPane_2);
		
		vehicleTable = new JTable();
		vehicleTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel)vehicleTable.getModel();
				int rowIndex = vehicleTable.getSelectedRow();
				
				vehicleLicenceNoTf.setText(model.getValueAt(rowIndex, 0).toString());
				storeIdTf2.setText(model.getValueAt(rowIndex, 1).toString());
				vehicleModelTf.setText(model.getValueAt(rowIndex, 2).toString());
				vehicleFuelTf.setText(model.getValueAt(rowIndex, 3).toString());
				vehicleCapacityTf.setText(model.getValueAt(rowIndex, 4).toString());
				vehicleRentalCostTf.setText(model.getValueAt(rowIndex, 5).toString());
				vehicleTypeTf.setText(model.getValueAt(rowIndex, 6).toString());
				vehicleSeatHeightTF.setText(model.getValueAt(rowIndex, 7).toString());
				vehicleLuggageSupportTf.setText(model.getValueAt(rowIndex, 8).toString());
				vehicleSeatNoTf.setText(model.getValueAt(rowIndex, 9).toString());
				vehicleDoorNumberTf.setText(model.getValueAt(rowIndex, 10).toString());
				generalTypeTf.setText(model.getValueAt(rowIndex, 11).toString());	
			}
		});
		vehicleTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vehicleTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_2.setViewportView(vehicleTable);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_1.setLayout(null);
		panel_4_1.setBounds(254, 549, 850, 45);
		vehiclepanel.add(panel_4_1);
		
		JButton addVehicleBtn = new JButton("Add");
		addVehicleBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Add16-icon.png")));
		addVehicleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentaldb","root","");
					cs = con.prepareCall("{ CALL CreateVehicleSP(?,?,?,?,?,?,?,?,?,?,?,?)}");
					
					cs.setString(1, vehicleLicenceNoTf.getText());
					cs.setString(2, storeIdTf2.getText());
					cs.setString(3, vehicleModelTf.getText());
					cs.setString(4, vehicleFuelTf.getText());
					cs.setString(5, vehicleCapacityTf.getText());
					cs.setInt(6, Integer.parseInt(vehicleRentalCostTf.getText()));	
					cs.setString(7, vehicleTypeTf.getText());
					cs.setInt(8, Integer.parseInt(vehicleSeatHeightTF.getText()));	
					cs.setString(9, vehicleLuggageSupportTf.getText());
					cs.setInt(10, Integer.parseInt(vehicleSeatNoTf.getText()));
					cs.setInt(11, Integer.parseInt(vehicleDoorNumberTf.getText()));
					cs.setString(12, generalTypeTf.getText());
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Vehicle successfully inserted to DB");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		addVehicleBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addVehicleBtn.setBounds(25, 5, 140, 35);
		panel_4_1.add(addVehicleBtn);
		
		JButton deleteVehicleBtn = new JButton("Delete");
		deleteVehicleBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Delete16-icon.png")));
		deleteVehicleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == deleteVehicleBtn) {
					int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this vehicle?", "Delete", JOptionPane.YES_NO_OPTION);
					if(p==0) {
					try {
						
						URL url = new URL ("http://localhost:8080/RentalCompany/vehicles/delete?vehicleLicenceNo="+vehicleLicenceNoTf.getText()+"");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("DELETE");
						conn.setRequestProperty("Accept", "application/json");
						
						if (conn.getResponseCode()!=200) {
							throw new RuntimeException("Failed: HTTP error code: "+conn.getResponseCode());
						}
						
						@SuppressWarnings("unused")
						BufferedReader br = new BufferedReader (new InputStreamReader(conn.getInputStream()));
											
						JOptionPane.showMessageDialog(null, "Successfully deleted vehicle");
					
						conn.disconnect();
					} catch (MalformedURLException me) {
				} catch(IOException me) {
					me.printStackTrace();
				}
			}
			}
			}
		});
		deleteVehicleBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteVehicleBtn.setBounds(190, 5, 140, 35);
		panel_4_1.add(deleteVehicleBtn);
		
		JButton viewVehiclesBtn = new JButton("View");
		viewVehiclesBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/View16-icon.png")));
		viewVehiclesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentaldb","root","");
					String sql="Select * from vehicle";
					java.sql.PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					vehicleTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		viewVehiclesBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewVehiclesBtn.setBounds(355, 5, 140, 35);
		panel_4_1.add(viewVehiclesBtn);
		
		JButton updateVehicleBtn = new JButton("Update");
		updateVehicleBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Update16-icon.png")));
		updateVehicleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentaldb","root","");
					cs = con.prepareCall("{ CALL UpdateVehicleSP(?,?,?,?,?,?,?,?,?,?,?,?)}");
					
					cs.setString(1, vehicleLicenceNoTf.getText());
					cs.setString(2, storeIdTf2.getText());
					cs.setString(3, vehicleModelTf.getText());
					cs.setString(4, vehicleFuelTf.getText());
					cs.setString(5, vehicleCapacityTf.getText());
					cs.setInt(6, Integer.parseInt(vehicleRentalCostTf.getText()));	
					cs.setString(7, vehicleTypeTf.getText());
					cs.setInt(8, Integer.parseInt(vehicleSeatHeightTF.getText()));	
					cs.setString(9, vehicleLuggageSupportTf.getText());
					cs.setInt(10, Integer.parseInt(vehicleSeatNoTf.getText()));
					cs.setInt(11, Integer.parseInt(vehicleDoorNumberTf.getText()));
					cs.setString(12, generalTypeTf.getText());
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Vehicle successfully updated");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		updateVehicleBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateVehicleBtn.setBounds(520, 5, 140, 35);
		panel_4_1.add(updateVehicleBtn);
		
		JButton clearVehicleBtn = new JButton("Clear");
		clearVehicleBtn.setBounds(685, 5, 140, 35);
		panel_4_1.add(clearVehicleBtn);
		clearVehicleBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Clear16-icon.png")));
		clearVehicleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vehicleLicenceNoTf.setText(null);
				storeIdTf2.setText(null);
				vehicleModelTf.setText(null);
				vehicleFuelTf.setText(null);
				vehicleCapacityTf.setText(null);
				vehicleRentalCostTf.setText(null);
				vehicleTypeTf.setText(null);
				vehicleSeatHeightTF.setText(null);
				vehicleLuggageSupportTf.setText(null);
				vehicleSeatNoTf.setText(null);
				vehicleDoorNumberTf.setText(null);	
				generalTypeTf.setText(null);
			}
		});
		clearVehicleBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_8.setBounds(10, 10, 230, 584);
		vehiclepanel.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblVehicleLicenceNo = new JLabel("Vehicle Licence No");
		lblVehicleLicenceNo.setBounds(15, 11, 132, 20);
		panel_8.add(lblVehicleLicenceNo);
		lblVehicleLicenceNo.setForeground(new Color(255, 255, 255));
		lblVehicleLicenceNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		vehicleLicenceNoTf = new JTextField();
		vehicleLicenceNoTf.setBounds(15, 33, 200, 25);
		panel_8.add(vehicleLicenceNoTf);
		vehicleLicenceNoTf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vehicleLicenceNoTf.setColumns(10);
		
		JLabel lblStoreId = new JLabel("Store Id");
		lblStoreId.setBounds(15, 58, 70, 20);
		panel_8.add(lblStoreId);
		lblStoreId.setForeground(Color.WHITE);
		lblStoreId.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		storeIdTf2 = new JTextField();
		storeIdTf2.setBounds(15, 80, 200, 25);
		panel_8.add(storeIdTf2);
		storeIdTf2.setToolTipText("ATH01 - Athens Airport, SKG01 - Thessaloniki Airport");
		storeIdTf2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		storeIdTf2.setColumns(10);
		
		JLabel lblVehicleModel = new JLabel("Vehicle Model");
		lblVehicleModel.setBounds(15, 105, 106, 20);
		panel_8.add(lblVehicleModel);
		lblVehicleModel.setForeground(Color.WHITE);
		lblVehicleModel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		vehicleModelTf = new JTextField();
		vehicleModelTf.setBounds(15, 127, 200, 25);
		panel_8.add(vehicleModelTf);
		vehicleModelTf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vehicleModelTf.setColumns(10);
		
		JLabel lblVehicleFuel = new JLabel("Vehicle Fuel");
		lblVehicleFuel.setBounds(15, 152, 97, 20);
		panel_8.add(lblVehicleFuel);
		lblVehicleFuel.setForeground(Color.WHITE);
		lblVehicleFuel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		vehicleFuelTf = new JTextField();
		vehicleFuelTf.setBounds(15, 174, 200, 25);
		panel_8.add(vehicleFuelTf);
		vehicleFuelTf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vehicleFuelTf.setColumns(10);
		
		JLabel lblVehicleCapacity = new JLabel("Vehicle Capacity");
		lblVehicleCapacity.setBounds(15, 199, 132, 20);
		panel_8.add(lblVehicleCapacity);
		lblVehicleCapacity.setForeground(Color.WHITE);
		lblVehicleCapacity.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		vehicleCapacityTf = new JTextField();
		vehicleCapacityTf.setBounds(15, 221, 200, 25);
		panel_8.add(vehicleCapacityTf);
		vehicleCapacityTf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vehicleCapacityTf.setColumns(10);
		
		JLabel lblVehicleRentalCost = new JLabel("Vehicle Rental Cost");
		lblVehicleRentalCost.setBounds(15, 246, 142, 20);
		panel_8.add(lblVehicleRentalCost);
		lblVehicleRentalCost.setForeground(Color.WHITE);
		lblVehicleRentalCost.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		vehicleRentalCostTf = new JTextField();
		vehicleRentalCostTf.setBounds(15, 268, 200, 25);
		panel_8.add(vehicleRentalCostTf);
		vehicleRentalCostTf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vehicleRentalCostTf.setColumns(10);
		
		JLabel lblVehicleType = new JLabel("Vehicle Type");
		lblVehicleType.setBounds(15, 293, 106, 20);
		panel_8.add(lblVehicleType);
		lblVehicleType.setForeground(Color.WHITE);
		lblVehicleType.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		vehicleTypeTf = new JTextField();
		vehicleTypeTf.setBounds(15, 315, 200, 25);
		panel_8.add(vehicleTypeTf);
		vehicleTypeTf.setFont(new Font("Dialog", Font.PLAIN, 14));
		vehicleTypeTf.setColumns(10);
		
		JLabel lblVehicleSeatHeight = new JLabel("Vehicle Seat Height");
		lblVehicleSeatHeight.setBounds(15, 340, 142, 20);
		panel_8.add(lblVehicleSeatHeight);
		lblVehicleSeatHeight.setForeground(Color.WHITE);
		lblVehicleSeatHeight.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		vehicleSeatHeightTF = new JTextField();
		vehicleSeatHeightTF.setBounds(15, 362, 200, 25);
		panel_8.add(vehicleSeatHeightTF);
		vehicleSeatHeightTF.setFont(new Font("Dialog", Font.PLAIN, 14));
		vehicleSeatHeightTF.setColumns(10);
		
		vehicleLuggageSupportTf = new JTextField();
		vehicleLuggageSupportTf.setBounds(15, 409, 200, 25);
		panel_8.add(vehicleLuggageSupportTf);
		vehicleLuggageSupportTf.setFont(new Font("Dialog", Font.PLAIN, 14));
		vehicleLuggageSupportTf.setColumns(10);
		
		JLabel lblVehicleLuggageSupport = new JLabel("Vehicle Luggage Support");
		lblVehicleLuggageSupport.setBounds(15, 387, 182, 20);
		panel_8.add(lblVehicleLuggageSupport);
		lblVehicleLuggageSupport.setForeground(Color.WHITE);
		lblVehicleLuggageSupport.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblVehicleSeatNo = new JLabel("Vehicle Seat No");
		lblVehicleSeatNo.setBounds(15, 434, 132, 20);
		panel_8.add(lblVehicleSeatNo);
		lblVehicleSeatNo.setForeground(Color.WHITE);
		lblVehicleSeatNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		vehicleSeatNoTf = new JTextField();
		vehicleSeatNoTf.setBounds(15, 456, 200, 25);
		panel_8.add(vehicleSeatNoTf);
		vehicleSeatNoTf.setFont(new Font("Dialog", Font.PLAIN, 14));
		vehicleSeatNoTf.setColumns(10);
		
		JLabel lblVehicleDoorNumber = new JLabel("Vehicle Door Number");
		lblVehicleDoorNumber.setBounds(15, 481, 159, 20);
		panel_8.add(lblVehicleDoorNumber);
		lblVehicleDoorNumber.setForeground(Color.WHITE);
		lblVehicleDoorNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		vehicleDoorNumberTf = new JTextField();
		vehicleDoorNumberTf.setBounds(15, 503, 200, 25);
		panel_8.add(vehicleDoorNumberTf);
		vehicleDoorNumberTf.setFont(new Font("Dialog", Font.PLAIN, 14));
		vehicleDoorNumberTf.setColumns(10);
		
		JLabel lblGeneralType = new JLabel("General Type");
		lblGeneralType.setBounds(15, 528, 97, 20);
		panel_8.add(lblGeneralType);
		lblGeneralType.setForeground(Color.WHITE);
		lblGeneralType.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		generalTypeTf = new JTextField();
		generalTypeTf.setBounds(15, 550, 200, 25);
		panel_8.add(generalTypeTf);
		generalTypeTf.setFont(new Font("Dialog", Font.PLAIN, 14));
		generalTypeTf.setColumns(10);
		
		/***Button to add a client***/
		
		/***Button to view clients***/
		
		JPanel rentalpanel = new JPanel();
		rentalpanel.setBackground(new Color(47, 79, 79));
		tabbedPane.addTab("Rentals", null, rentalpanel, null);
		rentalpanel.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(254, 10, 850, 485);
		rentalpanel.add(scrollPane_4);
		
		rentalTable = new JTable();
		rentalTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel)rentalTable.getModel();
				int rowIndex = rentalTable.getSelectedRow();
				
				rentalIdTf.setText(model.getValueAt(rowIndex, 0).toString());
				vehicleLicenceNoTf2.setText(model.getValueAt(rowIndex, 1).toString());
				clientIdTf2.setText(model.getValueAt(rowIndex, 2).toString());
				rentalPickupLocationTf.setText(model.getValueAt(rowIndex, 3).toString());
				rentalPickupDateTf.setText(model.getValueAt(rowIndex, 4).toString());
				rentalReturnLocationTf.setText(model.getValueAt(rowIndex, 5).toString());
				rentalReturnDateTf.setText(model.getValueAt(rowIndex, 6).toString());
				rentalTotalCostTf.setText(model.getValueAt(rowIndex, 7).toString());
			}
		});
		rentalTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		rentalTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_4.setViewportView(rentalTable);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_2.setLayout(null);
		panel_4_2.setBounds(254, 506, 450, 88);
		rentalpanel.add(panel_4_2);
		
		JButton addRentalBtn = new JButton("Add");
		addRentalBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Add16-icon.png")));
		addRentalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentaldb","root","");
					cs = con.prepareCall("{ CALL CreateRentalSP(?,?,?,?,?,?,?,?)}");
					
					cs.setString(1, rentalIdTf.getText());
					cs.setString(2, vehicleLicenceNoTf2.getText());
					cs.setString(3, clientIdTf2.getText());
					cs.setString(4, rentalPickupLocationTf.getText());
					cs.setString(5, rentalPickupDateTf.getText());
					cs.setString(6, rentalReturnLocationTf.getText());	
					cs.setString(7, rentalReturnDateTf.getText());
					cs.setInt(8, Integer.parseInt(rentalTotalCostTf.getText()));	
						
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Rental reservation successfully inserted to DB");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		addRentalBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addRentalBtn.setBounds(50, 6, 150, 35);
		panel_4_2.add(addRentalBtn);
		
		JButton deleteRentalBtn = new JButton("Delete");
		deleteRentalBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Delete16-icon.png")));
		deleteRentalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this rental?", "Delete", JOptionPane.YES_NO_OPTION);
				if(p==0) {
				try {
					URL url = new URL ("http://localhost:8080/RentalCompany/rentals/delete?rentalId="+rentalIdTf.getText()+"");
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("DELETE");
					conn.setRequestProperty("Accept", "application/json");
					
					if (conn.getResponseCode()!=200) {
						throw new RuntimeException("Failed: HTTP error code: "+conn.getResponseCode());
					}
					
					@SuppressWarnings("unused")
					BufferedReader br = new BufferedReader (new InputStreamReader(conn.getInputStream()));
					
					JOptionPane.showMessageDialog(getContentPane(), "Successfully deleted rental");
						
					conn.disconnect();
				} catch (MalformedURLException me) {
			} catch(IOException me) {
				me.printStackTrace();
			}
		}
			}
		});
		deleteRentalBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteRentalBtn.setBounds(250, 6, 150, 35);
		panel_4_2.add(deleteRentalBtn);
		
		JButton viewRentalsBtn = new JButton("View");
		viewRentalsBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/View16-icon.png")));
		viewRentalsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentaldb","root","");
					String sql="Select * from rental";
					java.sql.PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					rentalTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		viewRentalsBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewRentalsBtn.setBounds(50, 47, 150, 35);
		panel_4_2.add(viewRentalsBtn);
		
		JButton updateRentalBtn = new JButton("Update");
		updateRentalBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Update16-icon.png")));
		updateRentalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					URL url = new URL ("http://localhost:8080/RentalCompany/rentals/update?rentalId="+rentalIdTf.getText()+"&rentalPickupLocation="+rentalPickupLocationTf.getText()+""
							+ "&rentalPickupDate="+rentalPickupDateTf.getText()+"&rentalReturnLocation="+rentalReturnLocationTf.getText()+"&rentalReturnDate="+rentalReturnDateTf.getText()+
							"&rentalTotalCost="+rentalTotalCostTf.getText()+"");
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("PUT");
					conn.setRequestProperty("Accept", "application/json");
					
					if (conn.getResponseCode()!=200) {
						throw new RuntimeException("Failed: HTTP error code: "+conn.getResponseCode());
					}
					
					BufferedReader br = new BufferedReader (new InputStreamReader(conn.getInputStream()));
					
					@SuppressWarnings("unused")
					String output;
					System.out.println("Outptut from Server... \n");
					while ((output=br.readLine())!=null) {
						JOptionPane.showMessageDialog(getContentPane(), "Researvation successfully updated");
					}
					conn.disconnect();
				} catch (MalformedURLException me) {
			} catch(IOException me) {
				me.printStackTrace();
			}
			}
		});
		updateRentalBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateRentalBtn.setBounds(250, 47, 150, 35);
		panel_4_2.add(updateRentalBtn);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(10, 10, 230, -15);
		rentalpanel.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_10.setBounds(10, 10, 230, 485);
		rentalpanel.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblRentalId = new JLabel("Rental Id");
		lblRentalId.setBounds(15, 0, 200, 25);
		panel_10.add(lblRentalId);
		lblRentalId.setForeground(Color.WHITE);
		lblRentalId.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		rentalIdTf = new JTextField();
		rentalIdTf.setBounds(15, 25, 200, 35);
		panel_10.add(rentalIdTf);
		rentalIdTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rentalIdTf.setColumns(10);
		
		JLabel lblVehicleLicenceNo_1 = new JLabel("Vehicle Licence No");
		lblVehicleLicenceNo_1.setBounds(15, 60, 200, 25);
		panel_10.add(lblVehicleLicenceNo_1);
		lblVehicleLicenceNo_1.setForeground(Color.WHITE);
		lblVehicleLicenceNo_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		vehicleLicenceNoTf2 = new JTextField();
		vehicleLicenceNoTf2.setBounds(15, 85, 200, 35);
		panel_10.add(vehicleLicenceNoTf2);
		vehicleLicenceNoTf2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		vehicleLicenceNoTf2.setColumns(10);
		
		JLabel lblClientId = new JLabel("Client Id");
		lblClientId.setBounds(15, 120, 200, 25);
		panel_10.add(lblClientId);
		lblClientId.setForeground(Color.WHITE);
		lblClientId.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		clientIdTf2 = new JTextField();
		clientIdTf2.setBounds(15, 145, 200, 35);
		panel_10.add(clientIdTf2);
		clientIdTf2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clientIdTf2.setColumns(10);
		
		JLabel lblRentalPickupLocation = new JLabel("Rental Pickup Location");
		lblRentalPickupLocation.setBounds(15, 180, 200, 25);
		panel_10.add(lblRentalPickupLocation);
		lblRentalPickupLocation.setForeground(Color.WHITE);
		lblRentalPickupLocation.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		rentalPickupLocationTf = new JTextField();
		rentalPickupLocationTf.setToolTipText("Athens_Airport, Thessaloniki_Airport");
		rentalPickupLocationTf.setBounds(15, 205, 200, 35);
		panel_10.add(rentalPickupLocationTf);
		rentalPickupLocationTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rentalPickupLocationTf.setColumns(10);
		
		JLabel lblRentalPickupDate = new JLabel("Rental Pickup Date");
		lblRentalPickupDate.setBounds(15, 240, 200, 25);
		panel_10.add(lblRentalPickupDate);
		lblRentalPickupDate.setForeground(Color.WHITE);
		lblRentalPickupDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		rentalPickupDateTf = new JTextField();
		rentalPickupDateTf.setToolTipText("yyyy-mm-dd");
		rentalPickupDateTf.setBounds(15, 265, 200, 35);
		panel_10.add(rentalPickupDateTf);
		rentalPickupDateTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rentalPickupDateTf.setColumns(10);
		
		JLabel lblRentalReturnlocation = new JLabel("Rental Return Location");
		lblRentalReturnlocation.setBounds(15, 300, 200, 25);
		panel_10.add(lblRentalReturnlocation);
		lblRentalReturnlocation.setForeground(Color.WHITE);
		lblRentalReturnlocation.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		rentalReturnLocationTf = new JTextField();
		rentalReturnLocationTf.setToolTipText("Athens_Airport, Thessaloniki_Airport");
		rentalReturnLocationTf.setBounds(15, 325, 200, 35);
		panel_10.add(rentalReturnLocationTf);
		rentalReturnLocationTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rentalReturnLocationTf.setColumns(10);
		
		JLabel lblRentalReturnDate = new JLabel("Rental Return Date");
		lblRentalReturnDate.setBounds(15, 360, 200, 25);
		panel_10.add(lblRentalReturnDate);
		lblRentalReturnDate.setForeground(Color.WHITE);
		lblRentalReturnDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		rentalReturnDateTf = new JTextField();
		rentalReturnDateTf.setToolTipText("yyyy-mm-dd");
		rentalReturnDateTf.setBounds(15, 385, 200, 35);
		panel_10.add(rentalReturnDateTf);
		rentalReturnDateTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rentalReturnDateTf.setColumns(10);
		
		JLabel lblRentalTotalCost = new JLabel("Rental Total Cost");
		lblRentalTotalCost.setBounds(15, 420, 200, 25);
		panel_10.add(lblRentalTotalCost);
		lblRentalTotalCost.setForeground(Color.WHITE);
		lblRentalTotalCost.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		rentalTotalCostTf = new JTextField();
		rentalTotalCostTf.setBounds(15, 445, 200, 35);
		panel_10.add(rentalTotalCostTf);
		rentalTotalCostTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rentalTotalCostTf.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_11.setBounds(714, 506, 190, 88);
		rentalpanel.add(panel_11);
		panel_11.setLayout(null);
		
		JButton availabilityBtn = new JButton("Show vehicle list");
		availabilityBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/AvailableCar16-icon.png")));
		availabilityBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		availabilityBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AvailableVehicles availableVehicles = new AvailableVehicles();
				availableVehicles.setLocationRelativeTo(null);
				availableVehicles.setVisible(true);
			}
		});
		availabilityBtn.setBounds(10, 42, 170, 35);
		panel_11.add(availabilityBtn);
		
		JLabel lblNewLabel_4 = new JLabel("Available vehicles");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 11, 170, 20);
		panel_11.add(lblNewLabel_4);
		
		JButton clearRentalBtn = new JButton("Clear");
		clearRentalBtn.setBounds(54, 506, 140, 35);
		rentalpanel.add(clearRentalBtn);
		clearRentalBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Clear16-icon.png")));
		clearRentalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rentalIdTf.setText(null);
				vehicleLicenceNoTf2.setText(null);
				clientIdTf2.setText(null);
				rentalPickupLocationTf.setText(null);
				rentalPickupDateTf.setText(null);
				rentalReturnLocationTf.setText(null);
				rentalReturnDateTf.setText(null);
				rentalTotalCostTf.setText(null);
			}
		});
		clearRentalBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_11_1 = new JPanel();
		panel_11_1.setLayout(null);
		panel_11_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_11_1.setBounds(914, 506, 190, 88);
		rentalpanel.add(panel_11_1);
		
		JButton availabilityBtn_1 = new JButton("Show client list");
		availabilityBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClientList clientList = new ClientList();
				clientList.setLocationRelativeTo(null);
				clientList.setVisible(true);
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentaldb","root","");
					String sql="Select * from client";
					java.sql.PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					ClientList.clientListTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		availabilityBtn_1.setIcon(new ImageIcon(ControlPanel.class.getResource("/Clients16-icon.png")));
		availabilityBtn_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		availabilityBtn_1.setBounds(10, 42, 170, 35);
		panel_11_1.add(availabilityBtn_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Client list");
		lblNewLabel_4_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4_1.setBounds(10, 11, 170, 20);
		panel_11_1.add(lblNewLabel_4_1);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		logoutBtn.setBounds(1019, 8, 110, 40);
		contentPane.add(logoutBtn);
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login adminLogin = new Login();
				adminLogin.setVisible(true);
				adminLogin.setLocationRelativeTo(null);
				dispose();
			}
		});
		logoutBtn.setIcon(new ImageIcon(ControlPanel.class.getResource("/Cancel16-icon.png")));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ControlPanel.class.getResource("/Car64-icon.png")));
		lblNewLabel.setBounds(26, 0, 64, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ControlPanel.class.getResource("/Motorcycle64-icon.png")));
		lblNewLabel_1.setBounds(100, 0, 64, 64);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rent-a-Vehicle Management System");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(218, 165, 32));
		lblNewLabel_2.setBounds(368, 11, 402, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(ControlPanel.class.getResource("/Van64-icon.png")));
		lblNewLabel_1_1.setBounds(174, 0, 64, 64);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Stefanos Nikolaou, 2020");
		lblNewLabel_3.setForeground(new Color(218, 165, 32));
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.BOLD, 12));
		lblNewLabel_3.setIcon(new ImageIcon(ControlPanel.class.getResource("/Copyright16-icon.png")));
		lblNewLabel_3.setBounds(531, 676, 173, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("Copyright");
		lblNewLabel_2_1.setForeground(new Color(218, 165, 32));
		lblNewLabel_2_1.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2_1.setBounds(464, 676, 64, 25);
		contentPane.add(lblNewLabel_2_1);
		
		
	}
}
