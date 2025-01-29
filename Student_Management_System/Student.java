package com.project;

public class Student 
{
    private int id;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private int marks;

    public Student(int id, String firstName, String lastName, String contactNumber) 
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
    }

    public int getId()
    { 
    	return id;
    }
    public String getFirstName()
    { 
    	return firstName; 
    }
    public String getLastName() 
    {
    	return lastName; 
    }
    public String getContactNumber() 
    { 
    	return contactNumber; 
    }
    public int getMarks() 
    { 
    	return marks; 
    }

    public void setMarks(int marks) 
    { 
    	this.marks = marks;
    }
    public void setContactNumber(String contactNumber)
    { 
    	this.contactNumber = contactNumber; 
    }

    @Override
    public String toString() 
    {
        return "ID: " + id + ", Name: " + firstName + " " + lastName + ", Contact: " + contactNumber + ", Marks: " + marks;
    }
}
