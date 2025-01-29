package com.project;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem 
{
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    //Main Menu
    public static void main(String[] args) 
    {
        boolean running = true;

        while (running)
        {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Counsellor Menu");
            System.out.println("2. Faculty Menu");
            System.out.println("3. Student Menu");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) 
            {
                case 1:
                    counsellorMenu();
                    break;
                case 2:
                    facultyMenu();
                    break;
                case 3:
                	studentMenu();
                	break;
                case 4:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Counsellor Menu
    private static void counsellorMenu() 
    {
        boolean backToMain = false;

        while (!backToMain) 
        {
            System.out.println("\n--- Counsellor Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. View All Students");
            System.out.println("4. View Specific Student");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) 
            {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    viewAllStudents();
                    break;
                case 4:
                    viewSpecificStudent();
                    break;
                case 5:
                    backToMain = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    // Student Menu
    private static void studentMenu()
    {
    	boolean backToMain = false;
    	
    	while(!backToMain)
    	{
    		System.out.println("\n--- Student Menu ---");
    		System.out.println("1. View Student Deatils");
    		System.out.println("2. Back to Main Menu");
    		System.out.println("Select an option : ");
    		int choice = scanner.nextInt();
    		scanner.nextLine();
    		
    		switch(choice)
    		{
    			case 1 : viewOwnStudents();
    					 break;
    			case 2 : backToMain=true;
    					 break;
    			default : 
    					System.out.println("Invalid option.Please Try Again.");
    		}
    	}
    }

    // Faculty Menu
    private static void facultyMenu()
    {
        boolean backToMain = false;

        while (!backToMain)
        {
            System.out.println("\n--- Faculty Menu ---");
            System.out.println("1. Add Student Marks");
            System.out.println("2. View Own Students");
            System.out.println("3. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) 
            {
                case 1:
                    addStudentMarks();
                    break;
                case 2:
                    viewOwnStudents();
                    break;
                case 3:
                    backToMain = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addStudent()
    {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();

        // Validation 
        if (!contactNumber.matches("\\d{10}")) 
        {
            System.out.println("Invalid contact number. Please enter a 10-digit number.");
            return;
        }

        Student student = new Student(id, firstName, lastName, contactNumber);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    private static void removeStudent() 
    {
        System.out.print("Enter ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Student studentToRemove = null;
        for (Student student : students) 
        {
            if (student.getId() == id) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null)
        {
            System.out.print("Are you sure you want to delete this student? (Y/N): ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("Y")) 
            {
                students.remove(studentToRemove);
                System.out.println("Student removed successfully!");
            } 
            else
            {
                System.out.println("Deletion cancelled.");
            }
        } 
        else 
        {
            System.out.println("Student not found.");
        }
    }

    private static void viewAllStudents() 
    {
        System.out.println("\n--- All Students ---");
        for (Student student : students) 
        {
            System.out.println(student);
        }
    }

    private static void viewSpecificStudent() 
    {
        System.out.print("Enter ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (Student student : students)
        {
            if (student.getId() == id) 
            {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void addStudentMarks() 
    {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Student student : students) 
        {
            if (student.getId() == id) 
            {
                System.out.print("Enter Marks: ");
                int marks = scanner.nextInt();
                scanner.nextLine(); 

                student.setMarks(marks);
                System.out.println("Marks added successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void viewOwnStudents() 
    {
        System.out.println("\n--- Own Students ---");
        for (Student student : students) 
        {
            System.out.println(student);
        }
    }
}

