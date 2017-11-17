package studentdatabaseapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int academicYear;
	private int studentID;
	private ArrayList<String> courses = new ArrayList<String>();
	private int tuitionBalance = 0;
	private static int courseCost = 600;
	private static int id = 1000;
	
	// Constructor: Prompt to enter name and year for each student
	public Student(Scanner input) {
		System.out.print("Enter student first name: ");
		this.firstName = input.nextLine();
		
		System.out.print("Enter student last name: ");
		this.lastName = input.nextLine();
		
		System.out.print("Enter student academic year: ");
		this.academicYear = Integer.parseInt(input.nextLine());
				
		id++;
		setStudentID();
	}

	// Generate student 5-digit unique ID
	private int setStudentID() {
		// Academic year + static id
		return studentID = academicYear * 10000 + id;
	}
	
	/*
	 * Student can enroll in following courses (Each course is $600):
	 * History 101
	 * Math 101
	 * English 101
	 * Chemistry 101
	 * Computer Science 101
	 */
	public void enroll(Scanner input) {
		HashMap<Integer, String> coursesMap = new HashMap<Integer, String>();
		coursesMap.put(1, "History 101");
		coursesMap.put(2, "Math 101");
		coursesMap.put(3, "English 101");
		coursesMap.put(4, "Chemistry 101");
		coursesMap.put(5, "Computer Science 101");
		
		System.out.println("\nChoose course enrollment (Q to quit)");
		System.out.println("1 - History 101" +
						   "\n2 - Math 101" +
						   "\n3 - English 101" +
						   "\n4 - Chemistry 101" +
						   "\n5 - Computer Science 101");
						   
		while (true) {
			System.out.print("Enter course code to enroll: ");
			String courseCode = input.nextLine();
			if (courseCode.equals("Q")) 
				break;
			courses.add(coursesMap.get(Integer.parseInt(courseCode)));
			tuitionBalance += courseCost;
		}
		
		for (String item : courses) {
			System.out.println(item);
		}
	}
	
	// Student can view their balance and pay tuition
	public void viewBalance() {
		System.out.println("Student Tuition Balance: $" + tuitionBalance + " remaining.");
	}
	
	// Pay Tuition
	public void payTuition(int payment) {
		tuitionBalance -= payment;
		if (tuitionBalance > 0) {
			viewBalance();
		} else if (tuitionBalance < 0) {
			System.out.println("Refund Amount: $" + tuitionBalance * -1 + " to be paid back to student.");
		} else {
			System.out.println("Student tuition paid off in full.");
		}
	}
	
	/*
	 * View student status:
	 * Name
	 * ID
	 * Courses enrolled
	 * Tuition balance
	 */
	public void showStudentInfo() {
		System.out.println("Student: " + firstName + " " + lastName);
		System.out.println("Student ID: " + studentID);
		System.out.println("Courses Enrolled: ");
		for (String course : courses) 
			System.out.println(course);
		viewBalance();   
	}
}
