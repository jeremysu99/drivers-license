package driverslicense;

import java.awt.*;
import javax.swing.*;

public class Problem 
{
	private static JFrame frame1;
	private static JPanel panel1;
	private static JTextArea label1;
	private static PersonList plist;
	private String reason;
	
	public Problem(String reason, PersonList plist) 
	{
		this.reason = reason;
		this.plist = plist;
		frame1 = new JFrame();
		panel1 = new JPanel();
		label1 = new JTextArea("",20,50);
		label1.setEditable(false);
		frame1.setPreferredSize(new Dimension(600, 800));
		panel1.setBackground(Color.WHITE);
		create();
	}
	
	public void create() 
	{
		String str = "";
		if (reason.equals("suspended")) 
		{
			ListNode head = plist.getHead();
			ListNode current = head;
			Person p = (Person) current.getValue();
			while (current != null) 
			{
				p = (Person) current.getValue();
				if (p.getTraffic() >= 15)
					str += p.toString() + "\n";
				
				current = current.getNext();
			}
			label1.setText("\t\tSuspended Licenses:\n\n" + str);
			
		}
		else 
		{
			ListNode head = plist.getHead();
			ListNode current = head;
			Person p = (Person) current.getValue();
			while (current != null) 
			{
				p = (Person) current.getValue();
				if (!(getDateVal(p.getDate())))
					str += p.toString() + "\n";
				
				current = current.getNext();
			}
			label1.setText("\t\tExpired Licenses:\n\n "+ str);
			
		}
		panel1.add(label1);
		frame1.add(panel1, BorderLayout.CENTER);
		frame1.pack();
		frame1.setVisible(true);
	}
	
	public boolean getDateVal(String s) 
	{
		String year = s.substring(s.length()-4);
		String month = s.substring(0, s.indexOf(" "));
		String day = s.substring(s.indexOf(" ")+1, s.length()-5);
		System.out.println(year + " " + month + " " + day);
		if (Integer.valueOf(year) < 2022)
			return false;
		else if (Integer.valueOf(year) == 2022)
		{
			if (month.equals("January"))
				return false;
			if (month.equals("February"))
				return false;
			if (month.equals("March"))
				return false;
			if (month.equals("April"))
				return false;
			if (month.equals("May"))
				return false;
			if (month.equals("June"))
				return false;
			if (month.equals("July"))
				return false;
			if (month.equals("August"))
				return false;
			if (month.equals("September"))
				return false;
			if (month.equals("October"))
				return false;
			if (Integer.valueOf(day) <= 4)
				return false;
		}
		return true;
	}
}
