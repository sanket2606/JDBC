package student_jdbc_controller;

import java.sql.SQLException;
import java.util.Scanner;

import student_jdbc_dao.Student_dto;
import student_jdbc_dto.Student;

public class MainController
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// Create an instance of the Student_dto class to interact with the database
		Student_dto student_dto = new Student_dto();

		// Create a Scanner object for user input
		Scanner scanner = new Scanner(System.in);

		// Display a welcome message for the Student Management Application
		System.out.println("-------------------Welcome to Student Management Application---------------------------------");

		// Display menu options to the user
		System.out.println("1. Insert Data 2. Update Data 3. Delete Data 4. Fetch Data 5. Fetch All Data 6. Exit");

		// Enter into a loop for continuous interaction with the user
		while (true) {
		    System.out.println("Select the option you want to perform: ");
		    int choice = scanner.nextInt();

		    // Use a switch statement to handle the user's choice
		    switch (choice) {
		        case 1:
		        {
		            // Option 1: Insert Data
		            Student student = new Student();
		            System.out.println("Enter Your id: ");
		            int id = scanner.nextInt();
		            System.out.println("Enter Your Name: ");
		            String name = scanner.next();
		            System.out.println("Enter Your LastName: ");
		            String lastName = scanner.next();
		            System.out.println("Enter Your Mobile Number: ");
		            long mob = scanner.nextLong();
		            System.out.println("Enter Your Date of Birth: ");
		            String dob = scanner.next();
		            System.out.println("Enter Your Gender: ");
		            String gender = scanner.next();
		            System.out.println("Enter Your Percentage: ");
		            int percentage = scanner.nextInt();

		            // Set student information
		            student.setId(id);
		            student.setName(name);
		            student.setLastName(lastName);
		            student.setAddress(gender);
		            student.setMobaile(mob);
		            student.setDob(dob);
		            student.setGender(gender);
		            student.setParcentage(percentage);

		            // Save the student data to the database
		            student_dto.save(student);
		            break;
		        }

		        case 2:
		        {
		            // Option 2: Update Data
		            Student student = new Student();
		            System.out.println("Enter the ID you want to update: ");
		            int id = scanner.nextInt();
		            System.out.println("Enter Your Name: ");
		            String name = scanner.next();
		            System.out.println("Enter Your LastName: ");
		            String lastName = scanner.next();
		            System.out.println("Enter Your Mobile Number: ");
		            long mob = scanner.nextLong();
		            System.out.println("Enter Your Date of Birth: ");
		            String dob = scanner.next();
		            System.out.println("Enter Your Gender: ");
		            String gender = scanner.next();
		            System.out.println("Enter Your Percentage: ");
		            int percentage = scanner.nextInt();

		            // Set updated student information
		            student.setName(name);
		            student.setLastName(lastName);
		            student.setAddress(gender);
		            student.setMobaile(mob);
		            student.setDob(dob);
		            student.setGender(gender);
		            student.setParcentage(percentage);

		            // Update the student data in the database
		            student_dto.updateData(student, id);
		            break;
		        }

		        case 3:
		        {
		            // Option 3: Delete Data
		            System.out.println("Enter the ID you want to delete: ");
		            int idToDelete = scanner.nextInt();
		            student_dto.deleteData(idToDelete);
		            break;
		        }

		        case 4:
		        {
		            // Option 4: Fetch Data
		            System.out.println("Enter the ID you want to fetch: ");
		            int idToFetch = scanner.nextInt();
		            student_dto.fetchData(idToFetch);
		            break;
		        }

		        case 5:
		        {
		            // Option 5: Fetch All Data
		            student_dto.batchExecution();
		            break;
		        }

		        case 6:
		        {
		            // Option 6: Exit the application
		            System.out.println("Application Closed!");
		            System.exit(0);
		        }

		        default:
		        {
		            // Handle invalid menu choice
		            System.out.println("Please select the right option!");
		        }
		    }
		}
	}

}
