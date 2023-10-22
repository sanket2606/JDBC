package student_jdbc_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

import student_jdbc_dto.Student;

public class Student_dto
{
	
	/**
	 * This method establishes a database connection to the MySQL database.
	 *
	 * @return A Connection object representing the established database connection.
	 * @throws ClassNotFoundException if the MySQL driver class is not found.
	 * @throws SQLException if there's an error while connecting to the database.
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	    // Uncomment the following line if you're using the "com.mysql.jdbc.Driver" class
	    // Class.forName("com.mysql.jdbc.Driver");
	    
	    // Database connection details
	    String url = "jdbc:mysql://localhost:3306/student_jdbc"; // URL of the MySQL database
	    String username = "sanket"; // Database username
	    String password = "password"; // Database password
	    
	    // Establish and return the database connection
	    Connection connection = DriverManager.getConnection(url, username, password);
	    return connection;
	}

	

	/**
	 * Inserts a new student record into the 'student' table in the database.
	 *
	 * @throws ClassNotFoundException if the MySQL driver class is not found.
	 * @throws SQLException if there's an error while interacting with the database.
	 */
	public void Insert() throws ClassNotFoundException, SQLException {
	    Connection connection = getConnection(); // Get a connection to the database
	    Statement statement = connection.createStatement(); // Create a statement for executing SQL queries
	    
	    // SQL query to insert a new student record into the 'student' table
	    String sql = "INSERT INTO student (id, name, LastName, Address, Mobaile, Date_of_brith, Gender, Parcentage) " +
	                 "values('2', 'Vaibhav', 'Ganesh', 'Shegaon', '96575630', '2001-06-26', 'MALE', '74') ";

	    statement.execute(sql); // Execute the SQL query
	    System.out.println("Data Updated Successfully !!"); // Print a success message
	}

	
	public void save(Student student) throws ClassNotFoundException, SQLException {
	    Connection connection = getConnection(); // Get a connection to the database
	    Statement statement = connection.createStatement();
	    
	    // Prepare an SQL statement to insert student data into the 'student' table
	    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student (id, name, LastName, Address, Mobaile, Date_of_brith, Gender, Parcentage) values(?,?,?,?,?,?,?,?) ");
	    
	    // Set the parameters in the prepared statement based on the student object
	    preparedStatement.setInt(1, student.getId());
	    preparedStatement.setString(2, student.getName());
	    preparedStatement.setString(3, student.getLastName());
	    preparedStatement.setString(4, student.getAddress());
	    preparedStatement.setLong(5, student.getMobaile());
	    preparedStatement.setString(6, student.getDob());
	    preparedStatement.setString(7, student.getGender());
	    preparedStatement.setInt(8, student.getParcentage());
	    
	    preparedStatement.execute(); // Execute the SQL query to insert the student data
	    System.out.println("Data Saved successfully !!"); // Print a success message
	}


	public void updateData(Student student, int id) throws ClassNotFoundException, SQLException {
	    System.out.println("Updation Starting");
	    Connection connection = getConnection(); // Get a connection to the database

	    // Prepare a statement to select data for the given 'id'
	    PreparedStatement preparedStatementdb = connection.prepareStatement("select * from student where id=?");
	    preparedStatementdb.setInt(1, id);
	    ResultSet resultset = preparedStatementdb.executeQuery();
	    boolean b = resultset.next();

	    if (b) {
	        // Prepare an update statement to modify student data
	        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student SET name=?, lastName=?, Address=?, Mobaile=?, Date_of_brith=?, gender=?, Parcentage=? WHERE id=?");
	        while (b) {
	            System.out.println(resultset.getInt(1));
	            int iddb = resultset.getInt(1);
	            preparedStatement.setInt(8, iddb);
	            System.out.println(resultset.getInt(1));
	            break;
	        }
	        preparedStatement.setString(1, student.getName());
	        System.out.println(student.getName());
	        preparedStatement.setString(2, student.getLastName());
	        System.out.println(student.getLastName());
	        preparedStatement.setString(3, student.getAddress());
	        System.out.println(student.getAddress());
	        preparedStatement.setLong(4, student.getMobaile());
	        System.out.println(student.getMobaile());
	        preparedStatement.setString(5, student.getDob());
	        System.out.println(student.getDob());
	        preparedStatement.setString(6, student.getGender());
	        System.out.println(student.getGender());
	        preparedStatement.setInt(7, student.getParcentage());
	        System.out.println(student.getParcentage());
	        preparedStatement.executeUpdate();

	        System.out.println("Student Data Updated Successfully !!");
	    } else {
	        System.err.println("The Student with ID " + id + " Not found !!");
	    }
	}

	
	public void deleteData(int id) throws ClassNotFoundException, SQLException {
	    Connection connection = getConnection(); // Get a connection to the database
	    PreparedStatement preparedStatementdb = connection.prepareStatement("select * from student where id=?");
	    preparedStatementdb.setInt(1, id);
	    ResultSet resultset = preparedStatementdb.executeQuery();

	    if (resultset.next()) {
	        PreparedStatement preparedStatement = connection.prepareStatement("Delete From student where id=?");
	        preparedStatement.setInt(1, id);
	        int d = preparedStatement.executeUpdate();
	        System.out.println("Student Data Deleted Successfully !!");
	    } else {
	        System.err.println("The Student with ID " + id + " Not found !!");
	    }
	}

	public void fetchData(int id) throws ClassNotFoundException, SQLException {
	    Connection connection = getConnection(); // Get a connection to the database
	    PreparedStatement preparedStatementdb = connection.prepareStatement("select * from student where id=?");
	    preparedStatementdb.setInt(1, id);
	    ResultSet resultset = preparedStatementdb.executeQuery();
	    boolean b = resultset.next();

	    if (b) {
	        while (b) {
	            System.out.print("ID : " + resultset.getInt(1) + " , ");
	            System.out.print("Name : " + resultset.getNString(2) + " , ");
	            System.out.print("LastName : " + resultset.getString(3) + " , ");
	            System.out.print("Address : " + resultset.getString(4) + " , ");
	            System.out.print("Mobaile : " + resultset.getLong(5) + " , ");
	            System.out.print("Date_of_brith : " + resultset.getString(6) + " , ");
	            System.out.print("Gender : " + resultset.getString(7) + " , ");
	            System.out.print("Percentage : " + resultset.getInt(8));
	            System.out.println();
	            break;
	        }
	    } else {
	        System.err.println("The Student with ID " + id + " Not found !!");
	    }
	}

	public void fetchAllData() throws ClassNotFoundException, SQLException {
	    Connection connection = getConnection(); // Get a connection to the database
	    PreparedStatement preparedStatementdb = connection.prepareStatement("select * from student");
	    ResultSet resultset = preparedStatementdb.executeQuery();

	    while (resultset.next()) {
	        System.out.print("ID : " + resultset.getInt(1) + " , ");
	        System.out.print("Name : " + resultset.getNString(2) + " , ");
	        System.out.print("LastName : " + resultset.getString(3) + " , ");
	        System.out.print("Address : " + resultset.getString(4) + " , ");
	        System.out.print("Mobaile : " + resultset.getLong(5) + " , ");
	        System.out.print("Date_of_brith : " + resultset.getString(6) + " , ");
	        System.out.print("Gender : " + resultset.getString(7) + " , ");
	        System.out.print("Percentage : " + resultset.getInt(8));
	        System.out.println();
	    }
	}

	public void batchExecution() throws ClassNotFoundException, SQLException {
	    Connection connection = getConnection(); // Get a connection to the database
	    Statement statement = connection.createStatement();
	    String sql = "INSERT INTO student (id,name,LastName,Address,Mobaile,Date_of_brith,Gender,Parcentage) values('3','vinay','bharsakle','jalgaon','96575630','2003-05-2','MALE','74') ";
	    String sql2 = "INSERT INTO student (id,name,LastName,Address,Mobaile,Date_of_brith,Gender,Parcentage) values('4','Akash','jadhav','Shegaon','96575630','2002-06-11','MALE','88') ";
	    statement.addBatch(sql);
	    statement.addBatch(sql2);
	    statement.executeBatch();
	    System.out.println("Data Inserted");
	}

		
	
}
