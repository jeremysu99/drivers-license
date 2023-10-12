package driverslicense;

import java.awt.*;
import javax.swing.*;
public class Sort 
{
	private static PersonList plist;
	private String s;
	public Sort(String choice, PersonList plist1) 
	{
		s = choice;
		plist = plist1;
		create();
		
	}
	public void create() 
	{
		if (s.equals("Name")) 
		{
			//label1.setText("DLs sorted by Name: ");
			sort1();
			
		}
		else if (s.equals("Gender"))
		{
			//label1.setText("DLs sorted by Gender: ");
			sort2();
		}
		else
		{
			//label1.setText("DLs sorted by ID: ");
			sort3();
		}
		
	}
	public void sort1() 
	{
		plist.selectionSort(plist);
	}
	public void sort2() 
	{
		plist.selectionSort2(plist);
	}
	public void sort3() 
	{
		plist.selectionSort3(plist);
	}
}
