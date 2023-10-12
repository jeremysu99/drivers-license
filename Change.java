package driverslicense;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class Change implements ActionListener
{
	static JComboBox box;
	static String[] options;
	private static JFrame frame1;
	private static JPanel panel;
	private static PersonList plist;
	private static String person, pick;
	private static JTextField textfield;
	private static License licenseobj;
	
	public Change(PersonList pl) 
	{
		frame1 = new JFrame();
		panel = new JPanel();
		textfield = new JTextField(20);
		licenseobj = new License(1);
		plist = pl;
		
		options = new String[]{"Name", "DOB", "Expiration Date", "Number", "Above 18?", "Donor?", "Traffic Restriction", "Gender"};
		box = new JComboBox(options);
	}
	
	public Change(String n) 
	{
		person = n;
		create();
	}
	
	public void create() 
	{
		box.addActionListener(this);
		textfield.addActionListener(this);
		panel.add(box);
		panel.add(textfield);
		
		frame1.add(panel, BorderLayout.CENTER);
		frame1.pack();
		frame1.setVisible(true);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource().equals(box))
		{
			System.out.println("2");
			JComboBox cb = (JComboBox)e.getSource();
			pick = (String)cb.getSelectedItem();
		}
		else 
		{
			String value = textfield.getText();
			Person initial = (Person) plist.getNode1(person).getValue();
			if (pick.equals("Name")) 
				initial.changeName(value);
			else if (pick.equals("DOB"))
				initial.changeDOB(value);
			else if (pick.equals("Expiration Date"))
				initial.changeDate(value);
			else if (pick.equals("Number"))
				initial.changeNum(Integer.valueOf(value));
			else if (pick.equals("Traffic Restriction"))
				initial.changeTraffic(Integer.valueOf(value));
			else if (pick.equals("Gender"))
				initial.changeGender(value);
			else  if (pick.equals("Above 18?"))
			{
				if (value.equals("true"))
					initial.changeAge(true);
				else
					initial.changeAge(false);
			}
			else 
			{
				if (value.equals("true"))
					initial.changeDonor(true);
				else
					initial.changeDonor(false);
			}
			licenseobj.refresh();
		}

	}
}
