package cn.edu.nju.datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {
	
	private static Connection conn;

	public static Connection getConnection() throws SQLException {
		
		if (conn == null || conn.isClosed()) {
			conn = magicallyCreateNewConnection();
		}
		return conn;
	}

	private static Connection magicallyCreateNewConnection() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void createTable() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "CREATE TABLE CUSTOMERS " + "( 	ID 			INT 	PRIMARY KEY  ,"
														+ " date	 	TEXT  	NOT NULL,"
														+ " firstName  	TEXT    NOT NULL, " 
														+ " lastName   	TEXT    NOT NULL, "
														+ " emailAddress TEXT	NOT NULL, " 
														+ " phoneNumber TEXT 	NOT NULL, " 
														+ " address   	TEXT 	NOT NULL, " 
														+ " city	   	TEXT 	NOT NULL, " 
														+ " state      	TEXT 	NOT NULL, " 
														+ " zip      	TEXT 	NOT NULL)";

			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table created successfully");
	}
	
	public static void deleteTable() {

		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);

			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sqlCommand = "DROP TABLE IF EXISTS 'CUSTOMERS' ";

			System.out.println("output : " + stmt.executeUpdate(sqlCommand));

			stmt.close();
			c.commit(); // commit after execute sql command
			// COMMIT TRANSACTION makes all data modifications performed since
			// the start of the transaction a permanent part of the database,
			c.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Deletion done successfully");
	}

}