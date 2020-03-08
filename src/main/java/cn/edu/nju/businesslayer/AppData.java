package cn.edu.nju.businesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;

public class AppData {

	private ArrayList<CustomerRecord> schedule = new ArrayList<CustomerRecord>();
	private String todaySchedule;
	
	// this is the reference to the single instance of the AppData class
	private static AppData appData = null;
	
	
	// A private constructor that is only called one time
	private AppData() {
		
	}
	
	// A public method to make the app Data available throughout the application.
	// The first time the method is called, the Single instance of AppData is created,
	//   each subsequent time, the one data object created is returned.
	public static AppData getAppData(){
		if(appData == null){
			appData = new AppData();
		} 
		
		return appData;
		
	}
	
	//adds schedule entries in array list
	public void addCalendarEntry(CustomerRecord customerRecord) {
//		DatabaseConnection.deleteTable();
//		DatabaseConnection.createTable();

		schedule.add(customerRecord);	
	
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);

			stmt = c.createStatement();
			String sql = "INSERT INTO CUSTOMERS (date,firstName,lastName,emailAddress,phoneNumber,address,city,state,zip) " + "VALUES (" 
						+ customerRecord.stringForTable() + " ');";
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("New record created successfully");
	
	}
	
	//Print Array List
	public String printSchedule() {
		Connection c = null;
		Statement stmt = null;
		String allRecordsPrintout = "";

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);

			System.out.println("\nRetrieving all records...\n");

			stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMERS;");

			int count = 0;
			
			while (rs.next()) {
				String date = rs.getString("date");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String emailAddress = rs.getString("emailAddress");
				String phoneNumber = rs.getString("phoneNumber");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				String zipCode = rs.getString("zip");
				
				schedule.add( new CustomerRecord(date, firstName, lastName, emailAddress, phoneNumber, address, city, state, zipCode) );
				System.out.println(schedule.get(count).toString());
				allRecordsPrintout = allRecordsPrintout + schedule.get(count).toString();
				count++;
				
			}
			

			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("All records retrieved successfully");
		return allRecordsPrintout;

	}
	
	public static CustomerRecord selectPerson(String name) {
		
		Connection c = null;
		Statement stmt = null;
		CustomerRecord query = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);

			stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMERS where lastName='" + name + "';");
			while (rs.next()) {
				String date = rs.getString("date");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String emailAddress = rs.getString("emailAddress");
				String phoneNumber = rs.getString("phoneNumber");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				String zipCode = rs.getString("zip");

				query = new CustomerRecord(date, firstName, lastName, emailAddress, phoneNumber, address, city, state, zipCode);

				System.out.println(query.toString());

			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("All records retrieved successfully");

		return query;

	}
	
	public static String deleteRecord(String last, String statusMessage){
	    Connection c = null;
	    Statement stmt = null;

	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);

	      stmt = c.createStatement();
	      
	      String sql = "DELETE from CUSTOMERS where lastName='" + last + "';";
	      stmt.executeUpdate(sql);
	      c.commit();

	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	    	System.out.println("Customer Not Found");
	    	System.out.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    return statusMessage = "Record deleted successfully";
	}
	
	public static String statusMessage(JLabel statusUpdate, String statusText) {
		  return statusText;
	}
	
	public int countRows(){
	        System.out.println("Count number of rows in a specific table!");
	        Connection con = null;
	        int count = 0;
	        try {
	            Class.forName("org.sqlite.JDBC");
	            con = DriverManager.getConnection("jdbc:sqlite:test.db");
	            try {
	                Statement st = con.createStatement();

	                ResultSet res = st.executeQuery("SELECT COUNT(*) FROM CUSTOMERS");
	                while (res.next()){
	                    count = res.getInt(1);
	                }
	                System.out.println(count);
	                return count;
	            }
	            catch (SQLException s){
	                System.out.println("SQL statement is not executed!");
	            }
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
			return count;
	    }

}

	

