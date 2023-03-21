package restaurantmanagementsystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class adminpanel extends JInternalFrame {
	static JTable menutable;
	static String[][] array;
	static String[] split;
	static String tablecount;
	private JTextField showisim;
	private JTextField showfiyat;
	private JTextField showstok;
	private JTextField showmenufiyat;
	private JTextField showmenuisim;
	private JTextField masasayi;
	private JTextField degiseceksayi;
	private JTextField maxmasasayi;
	private JTextField aciklama;
	static ArrayList<Staff> staffs=new ArrayList<Staff>();
	private boolean costmenuflag = false, namemenuflag = true;
	private boolean stockflag = false, costflag = false;
	private boolean masasayiflag = false;
	private boolean yenisifreflag1=false,yenisifreflag2=false;
	private boolean tutarflag=false;
	static int maxmasa = 20;
	static File fileTc = new File("TableCount.txt");
	JLabel ozo=new JLabel();
	

	public adminpanel() throws IOException {
		BufferedReader objReader = new BufferedReader(new FileReader(fileTc));
		tablecount = objReader.readLine();
	}

	public void getAdminPanel() {
		JFrame jfadmin = new JFrame("    "+"YONETICI PANELI");
		jfadmin.getContentPane().setLayout(new FlowLayout());
		jfadmin.setSize(300, 300);
		jfadmin.setLocation(100, 200);
		jfadmin.setLayout(null);
		// jfadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfadmin.setResizable(false);
		jfadmin.setVisible(true);
		

		JButton menushowbutton = new JButton("      "+"MENU ISLEMLERI");
		Image imgmenu=new ImageIcon(adminpanel.class.getResource("/menu.png")).getImage();
		menushowbutton.setIcon(new ImageIcon(imgmenu));
		menushowbutton.setBounds(30, 30, 200, 20);
		jfadmin.getContentPane().add(menushowbutton);
		menushowbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					showmenu();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JButton staffbutton = new JButton("PERSONEL ISLEMLERI");
		Image imgstaf=new ImageIcon(adminpanel.class.getResource("/staf.png")).getImage();
		staffbutton.setIcon(new ImageIcon(imgstaf));
		staffbutton.setBounds(30, 60, 200, 20);
		jfadmin.getContentPane().add(staffbutton);
		staffbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				personelfunc();

			}
		});
		JButton moneyinoutbutton = new JButton("KAR-ZARAR DURUMU");
		Image img3=new ImageIcon(adminpanel.class.getResource("/karzarar.png")).getImage();
		moneyinoutbutton.setIcon(new ImageIcon(img3));
		moneyinoutbutton.setBounds(30, 90, 200, 20);
		jfadmin.getContentPane().add(moneyinoutbutton);
		moneyinoutbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					showprofit();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JButton stockbutton = new JButton("         "+"  STOK DURUMU");
		Image stockimg=new ImageIcon(adminpanel.class.getResource("/stok.png")).getImage();
		stockbutton.setIcon(new ImageIcon(stockimg));
		stockbutton.setBounds(30, 120, 200, 20);
		jfadmin.getContentPane().add(stockbutton);
		stockbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					showStock();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		JButton masabutton = new JButton("    "+"  MASA ISLEMLERI");
		Image img1=new ImageIcon(adminpanel.class.getResource("/table.png")).getImage();
		masabutton.setIcon(new ImageIcon(img1));
		masabutton.setBounds(30, 150, 200, 20);
		jfadmin.getContentPane().add(masabutton);
		masabutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					masasayisi();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		JButton sifrebutton = new JButton("    "+"SIFRE DEGISTIRME");
		Image img2=new ImageIcon(adminpanel.class.getResource("/lock.png")).getImage();
		sifrebutton.setIcon(new ImageIcon(img2));
		sifrebutton.setBounds(30, 180, 200, 20);
		jfadmin.getContentPane().add(sifrebutton);
		sifrebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				sifredegis();
			}
		});
	}


	public void showprofit() throws IOException {
		JPanel contentPane;
		JTable table;
		JTextField tutar;
		JTextPane txtpnGirdi;
		JButton btnNewButton;
		JTextField kar_zarar;
		JTextPane txtpnGuncelHesap;

		JTextPane txtpnAciklama;
		JButton btnNewButton_1;

		ArrayList<String> profit=new ArrayList<String>();
		File file = new File("profit.txt");
		BufferedReader objReader = new BufferedReader(new FileReader(file));
		String line;
		String[] split = new String[3];
		while ((line = objReader.readLine()) != null) {
			profit.add(line);
		}
		Collections.sort(profit);
		String[][] array = new String[profit.size()][4];
		for (int j = 0; j < profit.size(); j++) {

			split = profit.get(j).split(",");

			for (int j2 = 0; j2 < 3; j2++) {
				array[j][j2] = split[j2];
			}
		}
		String[] columnNames = { "Tur", "Urun icerigi", "Urun fiyati" };
		table = new JTable(array,columnNames);
		table.setBounds(230, 158, 100, 68);


		JFrame jfprofit = new JFrame("KAR ZARAR");
		jfprofit.getContentPane().setLayout(new FlowLayout());
		jfprofit.setSize(450, 350);
		jfprofit.setLocation(100, 200);
		jfprofit.setLayout(null);
		// jfadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfprofit.setResizable(false);
		jfprofit.setVisible(true);


		setBounds(100, 100, 450, 326);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 414, 162);
		jfprofit.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);


		tutar = new JTextField();
		tutar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					double i = Double.parseDouble(tutar.getText());
					tutarflag=true;
				} catch (Exception e2) {
					tutarflag=false;
				}
			}
		});
		tutar.setBounds(338, 11, 86, 20);
		jfprofit.getContentPane().add(tutar);
		tutar.setColumns(10);


		txtpnGirdi = new JTextPane();
		txtpnGirdi.setBackground(SystemColor.control);
		txtpnGirdi.setText("Tutar");
		txtpnGirdi.setBounds(300, 11, 38, 20);
		jfprofit.getContentPane().add(txtpnGirdi);

		JComboBox profitcomboBox = new JComboBox();
		profitcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Gelir", "Gider"}));
		profitcomboBox.setBounds(20, 11, 86, 21);
		jfprofit.getContentPane().add(profitcomboBox);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getValueAt(table.getSelectedRow(), 0).equals("Gelir")) {profitcomboBox.setSelectedIndex(0);}
				else profitcomboBox.setSelectedIndex(1);
				aciklama.setText(array[table.getSelectedRow()][1]);
				tutar.setText(array[table.getSelectedRow()][2]);
			}
		});

		btnNewButton = new JButton("Kaydet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tutarflag) {
					String addItem = (String) profitcomboBox.getSelectedItem() + "," + aciklama.getText() + ","
							+ tutar.getText();
					profit.add(addItem);
					File file = new File("profit.txt");
					FileWriter writer = null;
					try {
						writer = new FileWriter(file);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						for (int i = 0; i < profit.size(); i++) {
							writer.write(profit.get(i) + "\n");

						}
						writer.close();
						jfprofit.setVisible(false);
						try {
							showprofit();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Kayit Basarili");
				} else
					JOptionPane.showMessageDialog(null, "Bilgiler hatali");
			}
		});
		btnNewButton.setBounds(10, 256, 89, 23);
		jfprofit.getContentPane().add(btnNewButton);

		kar_zarar = new JTextField();
		kar_zarar.setBounds(338, 256, 86, 20);
		jfprofit.getContentPane().add(kar_zarar);
		kar_zarar.setColumns(10);
		double t=0;
		for (int i = 0; i < profit.size(); i++) {
			split = profit.get(i).split(",");
			if(split[0].equals("Gelir")) t=t+Double.parseDouble(split[2]);
			else t=t-Integer.parseInt(split[2]);
		}
		kar_zarar.setText(String.valueOf(t));
		txtpnGuncelHesap = new JTextPane();
		txtpnGuncelHesap.setBackground(SystemColor.control);
		txtpnGuncelHesap.setText("Guncel Durum");
		txtpnGuncelHesap.setBounds(247, 256, 100, 20);
		txtpnGuncelHesap.setVisible(true);
		jfprofit.getContentPane().add(txtpnGuncelHesap);


		aciklama = new JTextField();
		aciklama.setBounds(194, 11, 86, 20);
		jfprofit.getContentPane().add(aciklama);
		aciklama.setColumns(10);


		txtpnAciklama = new JTextPane();
		txtpnAciklama.setBackground(SystemColor.control);
		txtpnAciklama.setText("Aciklama");
		txtpnAciklama.setBounds(136, 11, 58, 20);
		jfprofit.getContentPane().add(txtpnAciklama);


		btnNewButton_1 = new JButton("Sil");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String delItem = (String) profitcomboBox.getSelectedItem()+","+aciklama.getText()+","+tutar.getText();
				FileWriter writer = null;
				try {
					writer = new FileWriter(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					for (int i = 0; i < profit.size(); i++) {
						if (!profit.get(i).equals(delItem)) {
							writer.write(profit.get(i) + "\n");
						}

					}
					writer.close();
					jfprofit.setVisible(false);
					try {
						showprofit();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Kayit silindi");
			}



		});
		btnNewButton_1.setBounds(109, 256, 89, 23);
		jfprofit.getContentPane().add(btnNewButton_1);
		//contentPane.add(table);
	}
	// public Object getArrayList;
	private JPanel contentPane;
	private JTextField eskisifre;
	private JTextField yenisifre1;
	private JTextField yenisifre2;
	public void sifredegis() {
		JFrame sifredegis = new JFrame();
		sifredegis.getContentPane().setLayout(new FlowLayout());
		sifredegis.setSize(400, 300);
		sifredegis.setLocation(100, 200);
		sifredegis.setLayout(null);
		// jfadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sifredegis.setResizable(false);
		sifredegis.setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JTextPane txtpnGuncelSifre = new JTextPane();
		txtpnGuncelSifre.setBackground(SystemColor.control);
		txtpnGuncelSifre.setText("GUNCEL SIFRE");
		txtpnGuncelSifre.setBounds(25, 32, 104, 20);
		sifredegis.getContentPane().add(txtpnGuncelSifre);

		JTextPane txtpnYeniSifre = new JTextPane();
		txtpnYeniSifre.setBackground(SystemColor.control);
		txtpnYeniSifre.setText("YENI SIFRE");
		txtpnYeniSifre.setBounds(25, 78, 104, 20);
		sifredegis.getContentPane().add(txtpnYeniSifre);

		JTextPane txtpnYeniSifreTekrar = new JTextPane();
		txtpnYeniSifreTekrar.setBackground(SystemColor.control);
		txtpnYeniSifreTekrar.setText("YENI SIFRE TEKRAR");
		txtpnYeniSifreTekrar.setBounds(25, 122, 104, 20);
		sifredegis.getContentPane().add(txtpnYeniSifreTekrar);

		eskisifre = new JTextField();
		eskisifre.setBounds(155, 32, 86, 20);
		sifredegis.getContentPane().add(eskisifre);
		eskisifre.setColumns(10);
		eskisifre.setText(Main.adminpassword);
		eskisifre.setEnabled(false);

		yenisifre1 = new JTextField();
		yenisifre1.setColumns(10);
		yenisifre1.setBounds(155, 78, 86, 20);
		sifredegis.getContentPane().add(yenisifre1);

		yenisifre2 = new JTextField();
		yenisifre2.setColumns(10);
		yenisifre2.setBounds(155, 122, 86, 20);
		sifredegis.getContentPane().add(yenisifre2);

		JButton btnNewButton = new JButton("ONAYLA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(yenisifre1.getText().equals(yenisifre2.getText())) {
					Main.adminpassword=yenisifre1.getText();
					JOptionPane.showMessageDialog(null, "Sifre basariyla degistirildi.\nYeni sifre : '"+Main.adminpassword+"'");
					File filep = new File("password.txt");
					FileWriter writer = null;
					try {
						writer = new FileWriter(filep);
						writer.write(String.valueOf(Main.adminpassword));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.println("bozuk");
						e1.printStackTrace();
					}
					try {
						writer.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else JOptionPane.showMessageDialog(null, "Sifreler farkli");
			}
		});
		btnNewButton.setBounds(253, 182, 89, 23);
		sifredegis.getContentPane().add(btnNewButton);
	}
	public void masasayisi() throws IOException {
		BufferedReader objReader = new BufferedReader(new FileReader(fileTc));
		tablecount = objReader.readLine();
		JFrame masasayisi = new JFrame();
		masasayisi.getContentPane().setLayout(new FlowLayout());
		masasayisi.setSize(600, 300);
		masasayisi.setLocation(100, 200);
		masasayisi.setLayout(null);
		// jfadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		masasayisi.setResizable(false);
		masasayisi.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		masasayi = new JTextField();
		masasayi.setBounds(235, 42, 31, 19);
		masasayisi.getContentPane().add(masasayi);
		masasayi.setColumns(10);
		masasayi.setText(tablecount);
		masasayi.setEnabled(false);

		maxmasasayi = new JTextField();
		maxmasasayi.setBounds(235, 10, 31, 19);
		masasayisi.getContentPane().add(maxmasasayi);
		maxmasasayi.setColumns(10);
		maxmasasayi.setText(String.valueOf(maxmasa));
		maxmasasayi.setEnabled(false);

		JTextPane txtpnmaxMasaSayisi = new JTextPane();
		txtpnmaxMasaSayisi.setEditable(false);
		txtpnmaxMasaSayisi.setBackground(SystemColor.control);
		txtpnmaxMasaSayisi.setText("Maksimum Masa Sayisi");
		txtpnmaxMasaSayisi.setBounds(35, 10, 150, 19);
		masasayisi.getContentPane().add(txtpnmaxMasaSayisi);

		JButton masacikar = new JButton("Masa Cikar");
		masacikar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a = Integer.parseInt(degiseceksayi.getText());
					masasayiflag=true;
				} catch (Exception e2) {
					masasayiflag=false;
				}
				if (masasayiflag&&Integer.parseInt(degiseceksayi.getText()) < Integer.parseInt(tablecount)) {// cikarilacak sayi
																								// mevcuttan kucukse
					int newCount = Integer.parseInt(tablecount) - Integer.parseInt(degiseceksayi.getText());

					JOptionPane.showMessageDialog(null, "Masa Sayisi Guncellendi\nLutfen programi yeniden baslatiniz.");
					FileWriter writer = null;
					try {
						writer = new FileWriter(fileTc);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						writer.write(String.valueOf(newCount));
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						writer.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					masasayisi.setVisible(false);
					try {
						masasayisi();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else
					JOptionPane.showMessageDialog(null, "Sayi hatali");
			}
		});
		masacikar.setBounds(235, 184, 120, 21);
		masasayisi.getContentPane().add(masacikar);

		// masa ekleme

		JButton MasaEkle = new JButton("Masa Ekle");
		MasaEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a = Integer.parseInt(degiseceksayi.getText());
					masasayiflag=true;
				} catch (Exception e2) {
					masasayiflag=false;
				}
				if (masasayiflag&&Integer.parseInt(degiseceksayi.getText()) > 0
						&& (maxmasa + 1 > Integer.parseInt(tablecount) + Integer.parseInt(degiseceksayi.getText()))) {// maksimum
																														// masa
																														// sayisi
																														// gecilemez
					int newCount = Integer.parseInt(tablecount) + Integer.parseInt(degiseceksayi.getText());

					JOptionPane.showMessageDialog(null, "Masa Sayisi Guncellendi\nLutfen programi yeniden baslatiniz.");
					FileWriter writer = null;
					try {
						writer = new FileWriter(fileTc);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						writer.write(String.valueOf(newCount));
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						writer.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					masasayisi.setVisible(false);
					try {
						masasayisi();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else
					JOptionPane.showMessageDialog(null, "Sayi hatali");
			}
		});

		MasaEkle.setBounds(235, 140, 120, 21);
		masasayisi.getContentPane().add(MasaEkle);

		JTextPane txtpnMasaSayisi = new JTextPane();
		txtpnMasaSayisi.setEditable(false);
		txtpnMasaSayisi.setBackground(SystemColor.control);
		txtpnMasaSayisi.setText("Guncel Masa Sayisi");
		txtpnMasaSayisi.setBounds(35, 42, 120, 19);
		masasayisi.getContentPane().add(txtpnMasaSayisi);

		degiseceksayi = new JTextField();
		degiseceksayi.setBounds(235, 95, 120, 19);
		masasayisi.getContentPane().add(degiseceksayi);

		degiseceksayi.setColumns(10);

		JTextPane txtpnMasaSayisiGir = new JTextPane();
		txtpnMasaSayisiGir.setEditable(false);
		txtpnMasaSayisiGir.setBackground(SystemColor.control);
		txtpnMasaSayisiGir.setText("Degisecek Masa Sayisi Gir");
		txtpnMasaSayisiGir.setBounds(35, 95, 154, 19);
		masasayisi.getContentPane().add(txtpnMasaSayisiGir);

	}

	public void showmenu() throws IOException {

		ArrayList<String> Menu = new ArrayList<String>();
		File file = new File("Menu.txt");
		BufferedReader objReader = new BufferedReader(new FileReader(file));
		String line;
		split = new String[3];
		while ((line = objReader.readLine()) != null) {
			Menu.add(line);
		}
		Collections.sort(Menu);
		array = new String[Menu.size()][3];
		for (int j = 0; j < Menu.size(); j++) {
			split = Menu.get(j).split(",");
			for (int x = 0; x < 3; x++) {
				array[j][x] = split[x];
			}
		}
		JFrame menus = new JFrame();
		menus.setResizable(false);
		menus.setTitle("Menuler");
		String[] columnNames = { "Tur", "Urun icerigi", "Urun fiyati" };
		menus.getContentPane().setLayout(null);
		menutable = new JTable(array, columnNames);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Icecek", "Tatli", "Yemek", "Paket" }));
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(93, 11, 86, 20);
		menus.getContentPane().add(comboBox);

		menutable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (menutable.getValueAt(menutable.getSelectedRow(), 0).equals("Icecek")) {
					comboBox.setSelectedIndex(0);
				} else if (menutable.getValueAt(menutable.getSelectedRow(), 0).equals("Tatli")) {
					comboBox.setSelectedIndex(1);
				} else if (menutable.getValueAt(menutable.getSelectedRow(), 0).equals("Yemek")) {
					comboBox.setSelectedIndex(2);
				}

				showmenuisim.setText((String) menutable.getValueAt(menutable.getSelectedRow(), 1));
				showmenufiyat.setText((String) menutable.getValueAt(menutable.getSelectedRow(), 2));
			}
		});
		menutable.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(menutable);
		sp.setBounds(10, 143, 488, 161);
		menus.getContentPane().add(sp);

		JButton btnmenuekle = new JButton("Menu Ekle");
		btnmenuekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (costmenuflag) {
					String addItem = (String) comboBox.getSelectedItem() + "," + showmenuisim.getText() + ","
							+ showmenufiyat.getText();
					Menu.add(addItem);
					FileWriter writer = null;
					try {
						writer = new FileWriter(file);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						for (int i = 0; i < Menu.size(); i++) {
							writer.write(Menu.get(i) + "\n");

						}
						writer.close();
						menus.setVisible(false);
						try {
							showmenu();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Menu Guncellendi");
				} else
					JOptionPane.showMessageDialog(null, "Bilgiler hatali");
			}

		});
		btnmenuekle.setBounds(354, 10, 118, 23);
		menus.getContentPane().add(btnmenuekle);

		JButton btnmenuduzenle = new JButton("Menu Duzenle");
		btnmenuduzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int i = Integer.parseInt(showmenufiyat.getText());
					costmenuflag = true;
				} catch (NumberFormatException e1) {
					costmenuflag = false;
				}
				if (costmenuflag) {
					FileWriter writer = null;
					try {
						writer = new FileWriter(file);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					array[menutable.getSelectedRow()][1] = showmenuisim.getText();
					array[menutable.getSelectedRow()][2] = showmenufiyat.getText();
					for (int i = 0; i < Menu.size(); i++) {
						String newLine = array[i][0] + "," + array[i][1] + "," + array[i][2];
						try {
							writer.write(newLine + "\n");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

					try {
						writer.close();
						menus.setVisible(false);
						try {
							showmenu();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, "Menu Guncellendi");
				} else {
					JOptionPane.showMessageDialog(null, "Bilgiler hatali");
				}

			}
		});
		btnmenuduzenle.setBounds(354, 60, 118, 23);
		menus.getContentPane().add(btnmenuduzenle);

		JButton btnmenusil = new JButton("Menu Sil");
		btnmenusil.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String delItem = (String) comboBox.getSelectedItem() + "," + showmenuisim.getText() + ","
						+ showmenufiyat.getText();
				FileWriter writer = null;
				try {
					writer = new FileWriter(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					for (int i = 0; i < Menu.size(); i++) {
						if (!Menu.get(i).equals(delItem)) {
							writer.write(Menu.get(i) + "\n");
						}

					}
					writer.close();
					menus.setVisible(false);
					try {
						showmenu();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Menu Guncellendi");
			}

		});
		btnmenusil.setBounds(354, 110, 118, 23);
		menus.getContentPane().add(btnmenusil);

		JTextPane txtpnTr = new JTextPane();
		txtpnTr.setBackground(SystemColor.control);
		txtpnTr.setText("T\u00FCr"); // Ürün türü
		txtpnTr.setBounds(10, 11, 79, 20);
		menus.getContentPane().add(txtpnTr);

		JTextPane txtpnrnIsmi = new JTextPane();
		txtpnrnIsmi.setBackground(SystemColor.control);
		txtpnrnIsmi.setText("Urun icerigi");
		txtpnrnIsmi.setBounds(10, 42, 79, 20);
		menus.getContentPane().add(txtpnrnIsmi);

		JTextPane txtpnTr_1_1 = new JTextPane();
		txtpnTr_1_1.setBackground(SystemColor.control);
		txtpnTr_1_1.setText("Urun fiyati"); // Ürün fiyatı
		txtpnTr_1_1.setBounds(10, 73, 79, 20);
		menus.getContentPane().add(txtpnTr_1_1);
		showmenuisim = new JTextField();
		showmenuisim.setColumns(10);
		showmenuisim.setBounds(93, 42, 86, 20);
		menus.getContentPane().add(showmenuisim);
		JTextPane errormenufiyat = new JTextPane();
		errormenufiyat.setForeground(Color.RED);
		errormenufiyat.setBackground(SystemColor.control);
		errormenufiyat.setBounds(189, 73, 79, 23);
		menus.getContentPane().add(errormenufiyat);
		showmenufiyat = new JTextField();
		showmenufiyat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					double cost = Double.parseDouble(showmenufiyat.getText());
					errormenufiyat.setText("");
					costmenuflag = true;

				} catch (NumberFormatException e1) {
					errormenufiyat.setText("Hatali fiyat");
					costmenuflag = false;
				}
			}
		});
		showmenufiyat.setColumns(10);
		showmenufiyat.setBounds(93, 73, 86, 20);
		menus.getContentPane().add(showmenufiyat);
		menus.setSize(513, 344);
		menus.setVisible(true);
		objReader.close();
	}

	public void showStock() throws IOException {
		ArrayList<String> Products = new ArrayList<String>();
		File file = new File("Products.txt");
		BufferedReader objReader = new BufferedReader(new FileReader(file));
		String line;
		String[] split = new String[4];
		while ((line = objReader.readLine()) != null) {
			Products.add(line);
		}
		Collections.sort(Products);
		String[][] array = new String[Products.size()][4];
		for (int j = 0; j < Products.size(); j++) {

			split = Products.get(j).split(",");

			for (int j2 = 0; j2 < 4; j2++) {

				array[j][j2] = split[j2];
			}
		}
		JFrame stok = new JFrame();
		stok.setResizable(false);
		stok.setTitle("Stok durumu");
		String[] columnNames = { "Tur", "Urun ismi", "Urun fiyati ", "Urun stogu" };
		stok.getContentPane().setLayout(null);
		JTable stoktable = new JTable(array, columnNames);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Icecek", "Tatli", "Yemek" }));
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(93, 11, 86, 20);
		stok.getContentPane().add(comboBox);

		stoktable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (stoktable.getValueAt(stoktable.getSelectedRow(), 0).equals("Icecek")) {
					comboBox.setSelectedIndex(0);
				} else if (stoktable.getValueAt(stoktable.getSelectedRow(), 0).equals("Tatli")) {
					comboBox.setSelectedIndex(1);
				} else {
					comboBox.setSelectedIndex(2);
				}
				showisim.setText((String) stoktable.getValueAt(stoktable.getSelectedRow(), 1));
				showfiyat.setText((String) stoktable.getValueAt(stoktable.getSelectedRow(), 2));
				showstok.setText((String) stoktable.getValueAt(stoktable.getSelectedRow(), 3));
			}
		});
		stoktable.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(stoktable);
		sp.setBounds(10, 143, 488, 161);
		stok.getContentPane().add(sp);

		JButton btnStokYenile = new JButton("Stok Yenile");
		btnStokYenile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (stockflag && costflag) {
					FileWriter writer = null;
					try {
						writer = new FileWriter(file);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for (int i = 0; i < Products.size(); i++) {
						String[] check = Products.get(i).split(",");
						if (check[1].equals(showisim.getText())) {
							System.out.print(array[i][3] + " > ");
							array[i][3] = showstok.getText();
							System.out.println(array[i][3]);
						}
					}
					for (int i = 0; i < Products.size(); i++) {
						String newLine = array[i][0] + "," + array[i][1] + "," + array[i][2] + "," + array[i][3];
						try {
							writer.write(newLine + "\n");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

					try {
						writer.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Stok Guncellendi");
				} else {
					JOptionPane.showMessageDialog(null, "Bilgiler hatali");
				}

			}

		});
		btnStokYenile.setBounds(374, 29, 98, 23);
		stok.getContentPane().add(btnStokYenile);

		JButton btnYeniStok = new JButton("Yeni Stok");
		btnYeniStok.addActionListener(new ActionListener() {
			String newLine;

			public void actionPerformed(ActionEvent e) {
				if (costflag && stockflag) {
					FileWriter writer = null;
					try {
						writer = new FileWriter(file);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for (int i = 0; i < Products.size(); i++) {
						newLine = array[i][0] + "," + array[i][1] + "," + array[i][2] + "," + array[i][3];
						try {
							writer.write(newLine + "\n");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					String type;
					if (comboBox.getSelectedIndex() == 0)
						type = "Icecek";
					else if (comboBox.getSelectedIndex() == 1)
						type = "Tatli";
					else
						type = "Yemek";
					newLine = type + "," + showisim.getText() + "," + showfiyat.getText() + "," + showstok.getText();
					try {
						writer.write(newLine + "\n");

					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						writer.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Yeni stok eklendi");
				} else {
					JOptionPane.showMessageDialog(null, "Bilgiler hatali");
				}

			}
		});
		btnYeniStok.setBounds(374, 80, 98, 23);
		stok.getContentPane().add(btnYeniStok);

		JTextPane txtpnTr = new JTextPane();
		txtpnTr.setBackground(SystemColor.control);
		txtpnTr.setText("T\u00FCr");
		txtpnTr.setBounds(10, 11, 79, 20);
		stok.getContentPane().add(txtpnTr);

		JTextPane txtpnrnIsmi = new JTextPane();
		txtpnrnIsmi.setBackground(SystemColor.control);
		txtpnrnIsmi.setText("\u00DCr\u00FCn ismi");
		txtpnrnIsmi.setBounds(10, 42, 79, 20);
		stok.getContentPane().add(txtpnrnIsmi);

		JTextPane txtpnTr_1_1 = new JTextPane();
		txtpnTr_1_1.setBackground(SystemColor.control);
		txtpnTr_1_1.setText("\u00DCr\u00FCn fiyat\u0131");
		txtpnTr_1_1.setBounds(10, 73, 79, 20);
		stok.getContentPane().add(txtpnTr_1_1);

		JTextPane txtpnTr_1_1_1 = new JTextPane();
		txtpnTr_1_1_1.setBackground(SystemColor.control);
		txtpnTr_1_1_1.setText("\u00DCr\u00FCn sto\u011Fu");
		txtpnTr_1_1_1.setBounds(10, 104, 79, 20);
		stok.getContentPane().add(txtpnTr_1_1_1);

		JTextPane errorfiyat = new JTextPane();
		errorfiyat.setForeground(Color.RED);
		errorfiyat.setBackground(SystemColor.control);
		errorfiyat.setBounds(189, 73, 79, 23);
		stok.getContentPane().add(errorfiyat);

		JTextPane errorstok = new JTextPane();
		errorstok.setForeground(Color.RED);
		errorstok.setBackground(SystemColor.control);
		errorstok.setBounds(189, 104, 79, 23);
		stok.getContentPane().add(errorstok);

		showisim = new JTextField();
		showisim.setColumns(10);
		showisim.setBounds(93, 42, 86, 20);

		stok.getContentPane().add(showisim);

		showfiyat = new JTextField();
		showfiyat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					double cost = Double.parseDouble(showfiyat.getText());
					errorfiyat.setText("");
					costflag = true;

				} catch (NumberFormatException e1) {
					errorfiyat.setText("Hatali fiyat");
					costflag = false;
				}
			}
		});

		showfiyat.setColumns(10);
		showfiyat.setBounds(93, 73, 86, 20);

		stok.getContentPane().add(showfiyat);

		showstok = new JTextField();
		showstok.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				try {

					int stock = Integer.parseInt(showstok.getText());
					errorstok.setText("");
					stockflag = true;
				} catch (NumberFormatException e1) {
					errorstok.setText("Hatali stok sayisi");
					stockflag = false;
				}
			}
		});
		showstok.setColumns(10);
		showstok.setBounds(93, 104, 86, 20);
		stok.getContentPane().add(showstok);

		stok.setSize(513, 344);
		stok.setVisible(true);
		objReader.close();
	}

	public void changecost() {
		JFrame jfchangecost = new JFrame("FIYAT GUNCELLEME");
		jfchangecost.getContentPane().setLayout(new FlowLayout());
		jfchangecost.setSize(600, 600);
		jfchangecost.setLocation(100, 200);
		jfchangecost.setLayout(null);
		jfchangecost.setResizable(false);
		jfchangecost.setVisible(true);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "a", "b" }));
		comboBox.setBounds(54, 11, 370, 22);
		jfchangecost.getContentPane().add(comboBox);

		JTextPane txtpnUrun = new JTextPane();
		txtpnUrun.setEditable(false);
		txtpnUrun.setText("URUN");
		txtpnUrun.setBackground(SystemColor.control);
		txtpnUrun.setBounds(10, 13, 40, 20);
		jfchangecost.getContentPane().add(txtpnUrun);

		JTextPane txtpnGuncelFiyat = new JTextPane();
		txtpnGuncelFiyat.setEditable(false);
		txtpnGuncelFiyat.setBackground(SystemColor.control);
		txtpnGuncelFiyat.setText("GUNCEL FIYAT");
		txtpnGuncelFiyat.setBounds(10, 44, 78, 20);
		jfchangecost.getContentPane().add(txtpnGuncelFiyat);

		JTextPane oldcost = new JTextPane();
		oldcost.setBackground(Color.WHITE);
		oldcost.setBounds(98, 44, 78, 20);
		jfchangecost.getContentPane().add(oldcost);

		JTextPane txtpnYeniFiyat = new JTextPane();
		txtpnYeniFiyat.setEditable(false);
		txtpnYeniFiyat.setText("YENI FIYAT");
		txtpnYeniFiyat.setBackground(SystemColor.menu);
		txtpnYeniFiyat.setBounds(10, 75, 78, 20);
		jfchangecost.getContentPane().add(txtpnYeniFiyat);

		JTextPane show_error = new JTextPane();
		show_error.setForeground(Color.RED);
		show_error.setBackground(SystemColor.control);
		show_error.setBounds(98, 106, 78, 20);
		jfchangecost.getContentPane().add(show_error);

		JTextPane newcost = new JTextPane();
		newcost.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					double cost = Double.parseDouble(newcost.getText());
					show_error.setText("");
				} catch (NumberFormatException e1) {
					show_error.setText("Hatali fiyat");
				}
			}
		});
		newcost.setBackground(Color.WHITE);
		newcost.setBounds(98, 75, 78, 20);
		jfchangecost.getContentPane().add(newcost);

		JButton btnNewButton = new JButton("GUNCELLE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(293, 191, 104, 23);
		jfchangecost.getContentPane().add(btnNewButton);
	}


	public void personelfunc() {

		JFrame jfpersonelf = new JFrame("PERSONEL ISLEMLERI");
		jfpersonelf.getContentPane().setLayout(new FlowLayout());
		jfpersonelf.setSize(200, 150);
		jfpersonelf.setLocation(100, 200);
		jfpersonelf.setLayout(null);
		// jfadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfpersonelf.setResizable(false);
		jfpersonelf.setVisible(true);
		JPanel contentPane;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("PERSONEL EKLEME");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonelAdd();

			}
		});

		btnNewButton.setBounds(0, 0, 150, 40);
		jfpersonelf.add(btnNewButton);

		JButton btnNewButton_3 = new JButton("PERSONEL LISTESI");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    personelList();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
			}
		});
		btnNewButton_3.setBounds(0, 40, 150, 40);
		jfpersonelf.add(btnNewButton_3);
	}

	public void zamyap(String name, ArrayList<Staff> list) {
		JFrame frame = new JFrame();
		setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		JTextField textField = new JTextField();
		textField.setBounds(135, 95, 96, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		JButton btnNewButton = new JButton("ONAYLA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < list.size(); i++) {
					if (name.equals(list.get(i).getName())) {
						list.get(i).setSalary(list.get(i).getSalary() + Integer.parseInt(textField.getText()));
						JOptionPane.showMessageDialog(null, list.get(i).getName() + " personeline  zam yap�ld�.");
						break;
					}

				}

			}
		});
		btnNewButton.setBounds(271, 138, 85, 21);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Zam Miktari");
		lblNewLabel.setBounds(55, 95, 90, 25);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Isim");
		lblNewLabel_1.setBounds(10, 20, 90, 25);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(name);
		lblNewLabel_2.setBounds(105, 20, 90, 25);
		frame.getContentPane().add(lblNewLabel_2);

		frame.setSize(400, 400);
		frame.setVisible(true);

	}

	public void PersonelAdd() {
		JTextField name;
		JTextField surname;
		JTextField address;
		JTextField mail;
		JTextField phonenumber;
		// JFrame Personel1=new JFrame("PERSONEL EKLEME");
		JFrame Personel1 = new JFrame("PERSONEL EKLEME");
		Personel1.getContentPane().setLayout(new FlowLayout());
		Personel1.setSize(600, 600);
		Personel1.setLocation(100, 200);
		Personel1.setLayout(null);
		// jfadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Personel1.setResizable(false);
		Personel1.setVisible(true);
		JLabel lblNewLabel = new JLabel("ISIM");
		lblNewLabel.setBounds(10, 10, 65, 13);
		Personel1.add(lblNewLabel);

		JLabel lblSurname = new JLabel("SOYISIM");
		lblSurname.setBounds(10, 30, 65, 13);
		Personel1.add(lblSurname);

		JLabel lblAddress = new JLabel("ADRES");
		lblAddress.setBounds(10, 50, 65, 13);
		Personel1.add(lblAddress);

		JLabel lblEmail = new JLabel("E-POSTA");
		lblEmail.setBounds(10, 70, 65, 13);
		Personel1.add(lblEmail);

		JLabel lblPhone = new JLabel("TELEFON NUMARASI");
		lblPhone.setBounds(10, 90, 70, 13);
		Personel1.add(lblPhone);

		JLabel lblGender = new JLabel("CINSIYET");
		lblGender.setBounds(10, 150, 65, 13);
		Personel1.add(lblGender);

		JLabel lblDate = new JLabel("TARIH");
		lblDate.setBounds(10, 110, 65, 13);
		Personel1.add(lblDate);

		JLabel lblPosition = new JLabel("POZISYON");
		lblPosition.setBounds(10, 130, 65, 13);
		Personel1.add(lblPosition);

		name = new JTextField();
		name.setBounds(135, 7, 96, 19);
		Personel1.add(name);
		name.setColumns(10);

		surname = new JTextField();
		surname.setColumns(10);
		surname.setBounds(135, 27, 96, 19);
		Personel1.add(surname);

		address = new JTextField();
		address.setColumns(10);
		address.setBounds(135, 47, 96, 19);
		Personel1.add(address);

		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(135, 67, 96, 19);
		Personel1.add(mail);

		phonenumber = new JTextField();
		phonenumber.setColumns(10);
		phonenumber.setBounds(135, 87, 96, 19);
		Personel1.add(phonenumber);

		JComboBox<String> month = new JComboBox<String>();
		month.setBounds(135, 107, 50, 21);
		month.addItem("Jan");
		month.addItem("Feb");
		month.addItem("Mar");
		month.addItem("Apr");
		month.addItem("May");
		month.addItem("Jun");
		month.addItem("July");
		month.addItem("Aug");
		month.addItem("Sep");
		month.addItem("Oct");
		month.addItem("Nov");
		month.addItem("Dec");

		Personel1.add(month);

		JComboBox<Integer> day = new JComboBox<Integer>();
		day.setBounds(183, 107, 41, 21);
		for (int i = 1; i <= 31; i++) {
			day.addItem(i);
		}
		Personel1.add(day);

		JComboBox<Integer> year = new JComboBox<Integer>();
		year.setBounds(224, 107, 60, 21);
		for (int i = 1970; i <= 2003; i++) {
			year.addItem(i);
		}
		Personel1.add(year);

		JComboBox<String> position = new JComboBox<String>();
		position.setBounds(135, 127, 80, 21);
		position.addItem("SEF");
		position.addItem("VALE");
		position.addItem("GARSON");
		Personel1.add(position);

		JComboBox<String> gender = new JComboBox<String>();
		gender.setBounds(135, 147, 80, 21);
		gender.addItem("ERKEK");
		gender.addItem("KADIN");
		Personel1.add(gender);

		JButton submitpersonel = new JButton("EKLE");
		submitpersonel.setBounds(65, 189, 85, 21);
		Personel1.add(submitpersonel);
		Personel1.setVisible(true);

		submitpersonel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cMonth = (String) month.getSelectedItem();
				int cDay = (Integer) day.getSelectedItem();
				int cYear = (Integer) year.getSelectedItem();
				Boolean flag = false;
				if (phonenumber.getText().length() < 10 || phonenumber.getText().length() > 11) {
					flag = false;

				}
				if (cMonth.equals("Jan") || cMonth.equals("Mar") || cMonth.equals("Mar") || cMonth.equals("May")
						|| cMonth.equals("july") || cMonth.equals("Aug") || cMonth.equals("Oct")
						|| cMonth.equals("Nov")) {

					if (cDay <= 31 && cDay > 0) {
						flag = true;
					}

				} else if (cMonth.equals("Apr") || cMonth.equals("June") || cMonth.equals("Sep")
						|| cMonth.equals("Nov")) {

					if (cDay <= 30 && cDay > 0) {
						flag = true;
					}
				} else {
					if ((cDay <= 29 && cYear % 4 == 0) || (cYear % 4 > 0 && cDay <= 28) && cDay > 0) {

						flag = true;
					}
				}

				if (mail.getText().contains("@") == false || mail.getText().contains(".com") == false) {
					flag = false;
				}
				if (phonenumber.getText().length() < 10 || phonenumber.getText().length() > 11) {
					flag = false;

				}
				if (flag == true) {
					JOptionPane.showMessageDialog(null, "EKLEME BASARILI");
					String toDay = Integer.toString(cDay);
					String toYear = Integer.toString((Integer) year.getSelectedItem());
					String date = toDay + "." + cMonth + "." + toYear;
					Staff s1 = new Staff(name.getText(), surname.getText(), address.getText(), mail.getText(),
							phonenumber.getText(), (String) gender.getSelectedItem(), date,
							(String) position.getSelectedItem());
					staffs.add(s1);

				} else

					JOptionPane.showMessageDialog(null, "Bilgileriniz kontrol ediniz.");

			}

		});
	}
	int count=0;
	public void personelList() throws IOException  {

		File file = new File("Staffs.txt");

		if(count==0)
		{
			BufferedReader objReader = new BufferedReader(new FileReader(file));
			String line;
			String[]split2 = new String[8];
			while ((line = objReader.readLine()) != null) {
				split2=line.split(",");
				staffs.add(new Staff(split2[0],split2[1],split2[2],split2[3],split2[4],split2[5],split2[6],split2[7]));
			}
			count++;
		}

		JFrame contentPane2 = new JFrame("PERSONEL LISTESI");
		contentPane2.getContentPane().setLayout(new FlowLayout());
		contentPane2.setSize(600, 600);
		contentPane2.setLocation(100, 200);
		contentPane2.setLayout(null);
		// jfadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane2.setResizable(false);
		contentPane2.setVisible(true);

		JComboBox<String> comboBox = new JComboBox<String>();
		for (int i = 0; i < staffs.size(); i++) {
			comboBox.addItem(staffs.get(i).getName());
		}
		comboBox.setBounds(140, 20, 130, 25);
		contentPane2.add(comboBox);

		JButton zambuton = new JButton("ZAM YAP");
        zambuton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String controlname=(String)comboBox.getSelectedItem();
                zamyap(controlname,staffs);
            }

        });
        zambuton.setBounds(409, 232, 150, 21);
        contentPane2.getContentPane().add(zambuton);



		JLabel lblNewLabel = new JLabel("ISIM");
		lblNewLabel.setBounds(20, 45, 90, 25);
		contentPane2.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("SOYISIM");
		lblNewLabel_1.setBounds(20, 65, 90, 25);
		contentPane2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("ADRES");
		lblNewLabel_2.setBounds(20, 85, 90, 25);
		contentPane2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("TELEFON");
		lblNewLabel_3.setBounds(20, 105, 90, 25);
		contentPane2.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("E-POSTA");
		lblNewLabel_4.setBounds(20, 125, 90, 25);
		contentPane2.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("CINSIYET");
		lblNewLabel_5.setBounds(20, 145, 90, 25);
		contentPane2.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("MAAS");
		lblNewLabel_6.setBounds(20, 165, 90, 25);
		contentPane2.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("BASLANGIC TARIHI");
		lblNewLabel_7.setBounds(20, 185, 90, 25);
		contentPane2.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("POZISYON");
		lblNewLabel_8.setBounds(20, 205, 90, 25);
		contentPane2.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("CALISANLAR");
		lblNewLabel_9.setBounds(20, 20, 90, 25);
		contentPane2.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setBounds(130, 45, 200, 25);
		contentPane2.add(lblNewLabel_10);
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBounds(130, 65, 200, 25);
		contentPane2.add(lblNewLabel_11);
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setBounds(130, 85, 200, 25);
		contentPane2.add(lblNewLabel_12);
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setBounds(130, 105, 200, 25);
		contentPane2.add(lblNewLabel_13);
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setBounds(130, 125, 200, 25);
		contentPane2.add(lblNewLabel_14);
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setBounds(130, 145, 200, 25);
		contentPane2.add(lblNewLabel_15);
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setBounds(130, 165, 200, 25);
		contentPane2.add(lblNewLabel_16);
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setBounds(130, 205, 200, 25);
		contentPane2.add(lblNewLabel_17);
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setBounds(130, 185, 200, 25);
		contentPane2.add(lblNewLabel_18);

		JButton btnNewButton = new JButton("ISTEN CIKAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String controlname = (String) comboBox.getSelectedItem();
				for (int i = 0; i < staffs.size(); i++) {
					if (controlname.equals(staffs.get(i).getName())) {
						staffs.remove(i);
						comboBox.removeItem((String) comboBox.getSelectedItem());
						JOptionPane.showMessageDialog(null, controlname + " isten cikarildi.");
						break;

					}
				}

			}
		});
		btnNewButton.setBounds(250, 232, 150, 21);
		contentPane2.add(btnNewButton);
		JButton btnNewButton_2 = new JButton("ARA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String controlname = (String) comboBox.getSelectedItem();
				for (int i = 0; i < staffs.size(); i++) {
					if (controlname.equals(staffs.get(i).getName())) {
						lblNewLabel_10.setText(staffs.get(i).getName());
						lblNewLabel_11.setText(staffs.get(i).getSurName());
						lblNewLabel_12.setText(staffs.get(i).getAddress());
						lblNewLabel_13.setText(staffs.get(i).getMail());
						lblNewLabel_14.setText(staffs.get(i).getPhoneNumber());
						lblNewLabel_15.setText(staffs.get(i).getGender());
						String temp = String.valueOf(staffs.get(i).getSalary());
						lblNewLabel_16.setText(temp);
						lblNewLabel_17.setText(staffs.get(i).getPosition());
						lblNewLabel_18.setText(staffs.get(i).getStartDate());
						break;

					}
				}

			}
		});
		btnNewButton_2.setBounds(300, 20, 85, 25);
		contentPane2.add(btnNewButton_2);
		contentPane2.setVisible(true);
		FileWriter fw=new FileWriter(file);
		for(int i=0;i<staffs.size();i++)
		{
			String newLine=staffs.get(i).getName()+","+staffs.get(i).getSurName()+","+staffs.get(i).getAddress()+","+staffs.get(i).getPhoneNumber()+","+staffs.get(i).getMail()+","+staffs.get(i).getGender()+","+staffs.get(i).getStartDate()+","+staffs.get(i).getPosition();
			fw.write(newLine+"\n");
		}
		fw.close();

	}
}
