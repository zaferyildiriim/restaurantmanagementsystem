package restaurantmanagementsystem;

import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class tables extends JFrame{
	private JPanel contentPane;
	private JTextField urunismi;
	private JTextField urunfiyati;
	private JTextField txtMasaTutari;
	private JTable table;
	public void getTable(int no) throws IOException {
		ArrayList<Menu> tatli=new ArrayList<Menu>();
		
		ArrayList<Menu> icecek=new ArrayList<Menu>();
		ArrayList<Menu> yemek=new ArrayList<Menu>();
		ArrayList<Menu> paket=new ArrayList<Menu>();
		ArrayList<Menu> genel=new ArrayList<Menu>();
		JFrame jftable1=new JFrame("MASA-"+no);
		jftable1.setSize(545,600);
		jftable1.setLocation(100,200);
		jftable1.getContentPane().setLayout(null);
		//jftable1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jftable1.setResizable(false);
		jftable1.setVisible(true);
		
		ArrayList<String> orders=new ArrayList<String>();
		String tablefile = "Table"+no+".txt";
		
		File file = new File(tablefile);
		BufferedReader objReader = new BufferedReader(new FileReader(file));
		String line;
		String[] split = new String[5];
		while ((line = objReader.readLine()) != null) {
			orders.add(line);
		}
		Collections.sort(orders);
		String[][] array = new String[orders.size()][5];
		for (int j = 0; j < orders.size(); j++) {

			split = orders.get(j).split(",");

			for (int j2 = 0; j2 < 5; j2++) {

				array[j][j2] = split[j2];
			}
		}
		String[] columnNames = { "Tur", "Urun ismi","Siparis adeti", "Birim fiyat", "Toplam fiyat" };
		JTable table = new JTable(array, columnNames);
		table.setBounds(172, 82, 38, 42);
		File file2 = new File("Menu.txt");
		BufferedReader objReader2 = new BufferedReader(new FileReader(file2));
		String line2;
		String[] split2 = new String[3];
		while ((line2 = objReader2.readLine()) != null) {
			split2=line2.split(",");
			double a = Double.parseDouble(split2[2]);
			genel.add(new Menu(split2[0],split2[1],a));
			if(split2[0].equals("Tatli"))
			{
				a = Double.parseDouble(split2[2]);
				tatli.add(new Menu(split2[0],split2[1],a));
			}
			else if(split2[0].equals("Icecek"))
			{
				a = Double.parseDouble(split2[2]);
				icecek.add(new Menu(split2[0],split2[1],a));
			}
			else if(split2[0].equals("Yemek"))
			{
				a = Double.parseDouble(split2[2]);
				yemek.add(new Menu(split2[0],split2[1],a));
			}
			else if(split2[0].equals("Paket"))
			{
				a = Double.parseDouble(split2[2]);
				paket.add(new Menu(split2[0],split2[1],a));
			}
		}
		
		
			
				JButton tableclosebutton=new JButton("MASAYI KAPAT");
				tableclosebutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<String> profit=new ArrayList<String>();
					File file=new File("profit.txt");
					BufferedReader objReader = null;
					try {
						objReader = new BufferedReader(new FileReader(file));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					String line;
					String[] split = new String[3];
					try {
						while ((line = objReader.readLine()) != null) {
							profit.add(line);
						}
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						FileWriter fw=new FileWriter(file);
						String newLine="Gelir"+","+"table"+no+" satis"+","+txtMasaTutari.getText();
						profit.add(newLine);
						for(int i=0;i<profit.size();i++)
						{
							fw.write(profit.get(i)+"\n");
						}
						txtMasaTutari.setText("0");
						for(int i=0;i<orders.size();i++)
						{
							orders.remove(i);
						}
						File file2=new File("table"+String.valueOf(no)+".txt");
						FileWriter fw2=new FileWriter(file2);
						for(int i=0;i<orders.size();i++)
						{
							fw2.write(orders.get(i));
						}
						jftable1.setVisible(false);
						fw.close();
						getTable(no);
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});	
				tableclosebutton.setBounds(10, 99, 140, 20);
				jftable1.getContentPane().add(tableclosebutton);
				
				JComboBox comboBox = new JComboBox();
				comboBox.addItem("Select");
				comboBox.addItem("Icecek");
				comboBox.addItem("Yemek");
				comboBox.addItem("Tatli");
				comboBox.addItem("Paket");			
				comboBox.setBounds(160, 36, 120, 20);
				jftable1.getContentPane().add(comboBox);
				JComboBox comboBox_1 = new JComboBox();	
				comboBox.addActionListener (new ActionListener () {
				    public void actionPerformed(ActionEvent e) {
				    	comboBox_1.removeAllItems();
				        if(comboBox.getSelectedItem().equals("Yemek"))
				        {	
				        	for(int i=0;i<yemek.size();i++)
				        	{
				        		comboBox_1.addItem(yemek.get(i).getName());

				        	}
				        }
				        else if(comboBox.getSelectedItem().equals("Tatli"))
				        {		
				        	for(int i=0;i<tatli.size();i++)
				        	{
				        		comboBox_1.addItem(tatli.get(i).getName());
				        	}				        	
				        }
				        else if(comboBox.getSelectedItem().equals("Icecek"))
				        {
				        	for(int i=0;i<icecek.size();i++)
				        	{
				        		comboBox_1.addItem(icecek.get(i).getName());
				        	}
				        }
				        else  if(comboBox.getSelectedItem().equals("Paket"))
				        {
				        	for(int i=0;i<paket.size();i++)
				        	{
				        		comboBox_1.addItem(paket.get(i).getName());
				        	}
				        }
				    }
				});
				
				comboBox_1.setBounds(290, 36, 170, 20);
				jftable1.getContentPane().add(comboBox_1);
				JTextField urunadeti=new JTextField();
				jftable1.getContentPane().add(urunadeti);
				urunadeti.setBounds(465, 36, 50, 20);
				
				urunismi = new JTextField();
				urunismi.setBounds(290, 68, 241, 20);
				jftable1.getContentPane().add(urunismi);
				urunismi.setColumns(10);
				
				urunfiyati = new JTextField();
				urunfiyati.setBounds(290, 99, 86, 20);
				jftable1.getContentPane().add(urunfiyati);
				urunfiyati.setColumns(10);
				JLabel adet=new JLabel("Adet");
				adet.setBounds(465, 15, 50, 20);
				jftable1.getContentPane().add(adet);
				JTextPane txtpnUrun = new JTextPane();
				txtpnUrun.setBackground(SystemColor.control);
				txtpnUrun.setText("Urun");
				txtpnUrun.setBounds(235, 68, 45, 20);
				jftable1.getContentPane().add(txtpnUrun);
				
				JTextPane txtpnFiyat = new JTextPane();
				txtpnFiyat.setBackground(SystemColor.control);
				txtpnFiyat.setText("Fiyat");
				txtpnFiyat.setBounds(235, 99, 45, 20);
				jftable1.getContentPane().add(txtpnFiyat);
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						urunismi.setText((String) table.getValueAt(table.getSelectedRow(), 1));
						urunfiyati.setText((String) table.getValueAt(table.getSelectedRow(), 3));
					}
				});
				JButton tablesetbutton=new JButton("SIPARIS IPTAL");
				tablesetbutton.setBounds(391, 99, 140, 20);
				jftable1.getContentPane().add(tablesetbutton);
					tablesetbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String[] splitdelete=new String[5];
						for(int i=0;i<orders.size();i++)
						{
							splitdelete=orders.get(i).split(",");
							if(urunismi.getText().equals(splitdelete[1]))
							{
								orders.remove(i);
								break;
							}
				
						}
						File file=new File("table"+String.valueOf(no)+".txt");
						FileWriter fw = null;
						try {
							fw = new FileWriter(file);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						for(int i=0;i<orders.size();i++)
						{
							try {
								fw.write(orders.get(i)+"\n");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						try {
							jftable1.setVisible(false);
							fw.close();
							getTable(no);
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});	
				txtMasaTutari = new JTextField();
				txtMasaTutari.setBounds(409, 540, 120, 20);
				jftable1.getContentPane().add(txtMasaTutari);
				txtMasaTutari.setColumns(10);
				String[] splitmasatutari=new String[5];
				JTextPane txtpnMasaTutari = new JTextPane();
				txtpnMasaTutari.setBackground(SystemColor.control);
				txtpnMasaTutari.setText("   MASA TUTARI");
				txtpnMasaTutari.setBounds(311, 540, 93, 20);
				jftable1.getContentPane().add(txtpnMasaTutari);
				
				JScrollPane tablescrollpane = new JScrollPane();
				tablescrollpane.setBounds(10, 150, 519, 379);
				jftable1.getContentPane().add(tablescrollpane);
				JButton tableaddbutton=new JButton("SIPARIS EKLEME");
				
					tableaddbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String temp=(String)comboBox_1.getSelectedItem();
						double count=0;
						for(int i=0;i<genel.size();i++)
						{
							if(temp.equals(genel.get(i).getName()))
							{
								count= genel.get(i).getSalecost();
								break;
							}
						}
						int multi=Integer.parseInt(urunadeti.getText());
						String newLine=comboBox.getSelectedItem()+","+comboBox_1.getSelectedItem()+","+urunadeti.getText()+","+count+","+multi*count;
						orders.add(newLine);
						File file=new File("table"+String.valueOf(no)+".txt");
						FileWriter fw = null;
						try {
							fw = new FileWriter(file);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						for(int i=0;i<orders.size();i++)
						{
							try {
								fw.write(orders.get(i)+"\n");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						try {
							jftable1.setVisible(false);
							fw.close();
							getTable(no);
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
					tableaddbutton.setBounds(10, 35, 140, 20);
					jftable1.getContentPane().add(tableaddbutton);
				

				tablescrollpane.setViewportView(table);
				//jftable1.getContentPane().add(table);
					tableclosebutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						
					}
				});
					double masatutari=0;
					for(int i=0;i<orders.size();i++)
					{
						splitmasatutari=orders.get(i).split(",");
						try {
							double x=Double.parseDouble(splitmasatutari[4]);
							masatutari=masatutari+x;
						} catch (Exception e) {
							
						}
							

						
						
						
				
					}
					txtMasaTutari.setText(String.valueOf(masatutari));
	}
	

	
}
