package restaurantmanagementsystem;

import java.util.ArrayList;

public class Staff
{


    private String Name;
    private String SurName;
    private String Address;
    private String Mail;
    private String PhoneNumber;// 11 haneli kontrol et
    private String Gender;// option
    private int Salary;
    private String StartDate;// option
    private String Position;// option
    public Staff(String name, String surName, String address,String mail, String phoneNumber, String gender,  String startDate, String position)
    {
        Name = name;
        SurName = surName;
        Address = address;
        Mail=mail;
        PhoneNumber = phoneNumber;
        Gender = gender;
        Position = position;
        if (position.equals("GARSON"))
        {
            Salary=3000;
        }
        else if (position.equals("SEF"))
        {
            Salary=4000;
        }
        else if(position.equals("VALE"))
        {
            Salary=2833;
        }


        StartDate = startDate;
        
        
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
            PhoneNumber = phoneNumber;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate)
    {
        StartDate = startDate;
    }

    public String getPosition()
    {
        return Position;
    }

    public void setPosition(String position)

    {
        Position = position;
    }

	public String getMail() {
		return Mail;
	}

	public void setMail(String mail) {
		Mail = mail;
	}
	
}
