package driverslicense;

import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class License implements ActionListener
{
	private static JTextArea label2;
	private static JButton sort1, sort2, sort3, suspended, expired, write;
	private static JFrame frame;
	private static JPanel panel;
	static String lineSeperator = System.getProperty("line.seperator");
	static PersonList list = new PersonList();
	static String[] plist;
	static JComboBox box;
	private static Change c;
	
	public License() 
	{
		frame = new JFrame();
		box = new JComboBox(plist);
		panel = new JPanel();
		c = new Change(list);
		label2 = new JTextArea("List of Driver's Licenses: \n"+list.toString(),20, 50);
		sort1 = new JButton("Sort by Name");
		sort2 = new JButton("Sort by Gender");
		sort3 = new JButton("Sory by ID");
		suspended = new JButton("Suspended licenses");
		expired = new JButton("Expired licenses");
		write = new JButton("Export");
		
		box.addActionListener(this);
		sort1.addActionListener(this);
		sort2.addActionListener(this);
		sort3.addActionListener(this);
		suspended.addActionListener(this);
		expired.addActionListener(this);
		write.addActionListener(this);
		
		label2.setEditable(false);
		panel.setBackground(Color.WHITE);
	    frame.setPreferredSize(new Dimension(600, 800));
		panel.add(box);
		panel.add(label2);
	    panel.add(sort1);
	    panel.add(sort2);
	    panel.add(sort3);
	    panel.add(suspended);
	    panel.add(expired);
		panel.add(write);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setTitle("Driver's License");
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		refresh();

	}
	
	public License(int num) 
	{}
	
	public void refresh() 
	{
		label2.setText("\t\tList of Driver's Licenses: \n\n"+list.toString());

	}
	
	public static void main(String[] args) 
	{
		String a, b, c, k;
		int d, h;
		boolean g = false;
		boolean f = false;
		File file = new File("D:\\downloads\\school\\2023\\driverlicense\\driverlicense\\src\\driverlicense\\data.txt");
		try (BufferedReader reader = new BufferedReader(new FileReader(file)))
		{
			StringBuilder cont = new StringBuilder();
			String txt;
			String count = reader.readLine();
			plist = new String[Integer.valueOf(count)];
			for (int i = 0; i < Integer.valueOf(count); i++) 
			{
				a = reader.readLine();
				b = reader.readLine();
				d = Integer.valueOf(reader.readLine());
				c = reader.readLine();
				txt = reader.readLine();
				if (txt.equals("true"))
					g = true;
				txt = reader.readLine();
				if (txt.equals("true"))
					f = true;
				h = Integer.valueOf(reader.readLine());
				k = reader.readLine();
				reader.readLine();
				Person p = new Person(a,b,d,c,g,f,h,k);
				plist[i] = p.getName();
				list.add(p);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		
		}
		new License();
	}
	
	public JFrame getFrame() 
	{
		return frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource().equals(box)) 
		{
			JComboBox cb = (JComboBox)e.getSource();
	        String Name = (String)cb.getSelectedItem();
			Change c1 = new Change(Name);
		}
		else if (e.getSource().equals(sort1)) 
		{
			Sort s = new Sort("Name", list);
			label2.setText("\t\tDriver's Licenses sorted by Name: \n\n"+list.toString());
		}
		else if (e.getSource().equals(sort2)) 
		{
			Sort s = new Sort("Gender", list);
			label2.setText("\t\tDriver's Licenses sorted by Gender: \n\n"+list.toString());
		}
		else if (e.getSource().equals(sort3)) 
		{
			Sort s = new Sort("ID", list);
			label2.setText("\t\tDriver's Licenses sorted by ID: \n\n"+list.toString());
		}
		else if (e.getSource().equals(suspended)) 
		{
			Problem p = new Problem("suspended", list);
		}
		else if (e.getSource().equals(write)) 
		{
			try {
				FileWriter myWriter = new FileWriter("D:\\downloads\\school\\2023\\driverlicense\\driverlicense\\src\\driverlicense\\output.txt");
				myWriter.write("Driver's Licenses: \n"+list.toString());
			    myWriter.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else 
		{
			Problem p = new Problem("expired", list);
		}
	}
	
}
