package restaurantmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class Main
{
	static String adminpassword;
	public static void main(String[] args) throws IOException
	{
		File f = new File("password.txt");
		BufferedReader objReader = new BufferedReader(new FileReader(f));		
		adminpassword=objReader.readLine();
		
		boolean passwordcheck = true;
		adminpanel adminpanel = new adminpanel();
		JFrame jf = new JFrame("OZOsoft");

		jf.setLayout(null);
		// jf.setTitle("OZOsoft");
		JButton size = new JButton("Window X value :");
		jf.setSize(631, 600);

		jf.setLocation(100, 200);
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.setVisible(true);		
		JButton adminbutton = new JButton("YONETICI GIRISI");
		Image img=new ImageIcon(Main.class.getResource("/admin.png")).getImage();
		adminbutton.setIcon(new ImageIcon(img));
		adminbutton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				String adminPassword = JOptionPane.showInputDialog("Sifrenizi Yazin");
				if (adminPassword != null && adminPassword.equals(adminpassword)) {
					adminpanel.getAdminPanel();

				}
				else
				{
					JOptionPane.showMessageDialog(null, "SIFRE HATALI");
				}
			}
		});
		jf.getContentPane().add(adminbutton);
		adminbutton.setBounds(-10, 5, 170, 20);

		



 









		///////////////////////////////////////
		int tablecount = Integer.parseInt(adminpanel.tablecount);
		ArrayList<Boolean> flags = new ArrayList<Boolean>();
		for (int i = 0; i < adminpanel.maxmasa; i++)
		{
			flags.add(false);
		}
		for (int i = 0; i < tablecount; i++)
		{
			flags.set(i, true);
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if (flags.get(0))
		{
			tables Tables1 = new tables();
			JButton table1 = new JButton("MASA-1");

			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table1.setIcon(new ImageIcon(imgtable));

			table1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					try {
						Tables1.getTable(1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table1);
			table1.setBounds(164, 5, 104, 100);
		}
		if (flags.get(1))
		{
			tables Tables2 = new tables();
			JButton table2 = new JButton("MASA-2");

			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table2.setIcon(new ImageIcon(imgtable));
			table2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tables2.getTable(2);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table2);
			table2.setBounds(274, 5, 104, 100);
		}
		if (flags.get(2)) {
			tables Tables3 = new tables();
			JButton table3 = new JButton("MASA-3");
			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table3.setIcon(new ImageIcon(imgtable));
			table3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tables3.getTable(3);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table3);
			table3.setBounds(384, 5, 104, 100);
		}
		if (flags.get(3)) {
			tables Tables4 = new tables();
			JButton table4 = new JButton("MASA-4");
			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table4.setIcon(new ImageIcon(imgtable));
			table4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tables4.getTable(4);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table4);
			table4.setBounds(494, 5, 104, 100);
		}
		if (flags.get(4)) {
			tables Tables5 = new tables();
			JButton table5 = new JButton("MASA-5");
			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table5.setIcon(new ImageIcon(imgtable));
			table5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tables5.getTable(5);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table5);
			table5.setBounds(164, 115, 104, 100);
		}

		if (flags.get(5)) {
			tables Tables6 = new tables();
			JButton table6 = new JButton("MASA-6");
			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table6.setIcon(new ImageIcon(imgtable));
			table6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tables6.getTable(6);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table6);
			table6.setBounds(274, 115, 104, 100);
		}
		if (flags.get(6)) {
			tables Tables7 = new tables();
			JButton table7 = new JButton("MASA-7");
			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table7.setIcon(new ImageIcon(imgtable));
			table7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tables7.getTable(7);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table7);
			table7.setBounds(384, 115, 104, 100);
		}
		if (flags.get(7)) {
			tables Tables8 = new tables();
			JButton table8 = new JButton("MASA-8");
			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table8.setIcon(new ImageIcon(imgtable));
			table8.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					try {
						Tables8.getTable(8);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table8);
			table8.setBounds(494, 115, 104, 100);
		}
		if (flags.get(8)) {
			tables Tables9 = new tables();
			JButton table9 = new JButton("MASA-9");
			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table9.setIcon(new ImageIcon(imgtable));
			table9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tables9.getTable(9);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table9);
			table9.setBounds(164, 225, 104, 100);
		}
		if (flags.get(9)) {
			tables Tables10 = new tables();
			JButton table10 = new JButton("MASA-10");
			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table10.setIcon(new ImageIcon(imgtable));
			table10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tables10.getTable(10);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table10);
			table10.setBounds(274, 225, 104, 100);
		}

		if (flags.get(10)) {
			tables Tables11 = new tables();
			JButton table11 = new JButton("MASA-11");
			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table11.setIcon(new ImageIcon(imgtable));
			table11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tables11.getTable(11);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table11);
			table11.setBounds(384, 225, 104, 100);
		}
		if (flags.get(11)) {
			tables Tables12 = new tables();
			JButton table12 = new JButton("MASA-12");
			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table12.setIcon(new ImageIcon(imgtable));
			table12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tables12.getTable(12);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table12);
			table12.setBounds(494, 225, 104, 100);
		}
		if (flags.get(12)) {
			tables Tables13 = new tables();
			JButton table13 = new JButton("MASA-13");
			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table13.setIcon(new ImageIcon(imgtable));
			table13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tables13.getTable(13);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table13);
			table13.setBounds(164, 335, 104, 100);
		}
		if (flags.get(13)) {
			tables Tables14 = new tables();
			JButton table14 = new JButton("MASA-14");
			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table14.setIcon(new ImageIcon(imgtable));
			table14.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tables14.getTable(14);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table14);
			table14.setBounds(274, 335, 104, 100);
		}
		if (flags.get(14)) {
			tables Tables15 = new tables();
			JButton table15 = new JButton("MASA-15");
			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table15.setIcon(new ImageIcon(imgtable));
			table15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tables15.getTable(15);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table15);
			table15.setBounds(384, 335, 104, 100);
		}
		if (flags.get(15)) {
			tables Tables16 = new tables();
			JButton table16 = new JButton("MASA-16");
			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table16.setIcon(new ImageIcon(imgtable));
			table16.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tables16.getTable(16);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table16);
			table16.setBounds(494, 335, 104, 100);
		}

		if (flags.get(16)) {
			tables Tables17 = new tables();
			JButton table17 = new JButton("MASA-17");
			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table17.setIcon(new ImageIcon(imgtable));
			table17.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tables17.getTable(17);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table17);
			table17.setBounds(164, 445, 104, 100);
		}
		if (flags.get(17)) {
			tables Tables18 = new tables();
			JButton table18 = new JButton("MASA-18");
			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table18.setIcon(new ImageIcon(imgtable));
			table18.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tables18.getTable(18);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table18);
			table18.setBounds(274, 445, 104, 100);
		}
		if (flags.get(18)) {
			tables Tables19 = new tables();
			JButton table19 = new JButton("MASA-19");
			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table19.setIcon(new ImageIcon(imgtable));
			table19.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tables19.getTable(19);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table19);
			table19.setBounds(384, 445, 104, 100);
		}
		if (flags.get(19)) {
			tables Tables20 = new tables();
			JButton table20 = new JButton("MASA-20");
			Image imgtable=new ImageIcon(Main.class.getResource("/table1.png")).getImage();
			table20.setIcon(new ImageIcon(imgtable));
			table20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tables20.getTable(20);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jf.getContentPane().add(table20);
			table20.setBounds(494, 445, 104, 100);
		}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		

	}
	private static String getResource(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
