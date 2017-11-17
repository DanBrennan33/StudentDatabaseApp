package studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// Ask how many new students will be added to database
		System.out.print("Enter number of students to enroll: ");
		int numOfStudents = Integer.parseInt(input.nextLine());
		Student[] students = new Student[numOfStudents];
		System.out.println("");
		
		for (int i = 0; i < numOfStudents; i++) {
			students[i] = new Student(input);
			
			students[i].enroll(input);

			students[i].viewBalance();

			while (true) {
				System.out.print("Make a tuition payment (Yes or No): ");
				String paymentDecision = input.nextLine();
				if (paymentDecision.equals("Yes")) {
					System.out.print("Payment amount: $");
					String paymentAmount = input.nextLine();
					students[i].payTuition(Integer.parseInt(paymentAmount));
					break;
				} else 
					break;
			}
		}
		
		while (true) {
			System.out.print("Show specific student information (Q to quit): ");
			String studentNum = input.nextLine();
			if (studentNum.equals("Q"))
				break;
			else {
				System.out.println("");
				students[Integer.parseInt(studentNum)].showStudentInfo();
			}
		}
			
		input.close();
	}
}
