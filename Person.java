package driverslicense;

public class Person {
	private String name, DOB, gender, date;
	private int ID, traffic;
	private boolean donor, age;
	
	public Person(String name, String DOB, int ID, String gender, boolean age, boolean donor, int traffic, String date) 
	{
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.donor = donor;
		this.date = date;
	}
	public int getNumber() 
	{
		return ID;
	}
	public String getName() 
	{
		return name;
	}
	public String getGender() 
	{
		return gender;
	}
	public String getDate() 
	{
		return date;
	}
	public String getDOB() 
	{
		return DOB;
	}
	public int getTraffic() 
	{
		return traffic;
	}
	public boolean getDonor() 
	{
		return donor;
	}
	
	public void changeName(String n) {this.name = n;}
	public void changeDOB(String d) {this.DOB = d;}
	public void changeDate(String d) {this.date = d;}
	public void changeNum(int n) {this.ID = n;}
	public void changeTraffic(int n) {this.traffic = n;}
	public void changeGender(String g) {this.gender = g;}
	public void changeAge(boolean b) {this.age = b;}
	public void changeDonor(boolean b) {this.donor = b;}
	
	
}
