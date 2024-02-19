package passengertable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class passengers {
	private int passengerid;
	private String flightid;
	private String passengername;
	private String passengergender;
	private String email;
	
	public passengers(int passengerid,String flightid,String passengername, String passengergender,String passengeremail) {
		super();
		this.passengerid = passengerid;
		this.flightid = flightid;
		this.passengername = passengername;
		this.passengergender = passengergender;
		this.email = email;
}

	public passengers() {
		// TODO Auto-generated constructor stub
	}

	public int getPassengerid() {
		return passengerid;
	}

	public void setPassengerid(int passengerid) {
		this.passengerid = passengerid;
	}

	public String getFlightid() {
		return flightid;
	}

	public void setFlightid(String flightid) {
		this.flightid = flightid;
	}

	public String getPassengername() {
		return passengername;
	}

	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}

	public String getPassengergender() {
		return passengergender;
	}

	public void setPassengergender(String passengergender) {
		this.passengergender = passengergender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/baraka_ritha_fb";
	    String user = "222010945";
	    String password = "222010945";

	    // SQL query to insert data
	    String sql = "INSERT INTO passengers ( flightid,passengername,passengergender,email) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.flightid);
	       preparedStatement.setString(2, this.passengername);
	       preparedStatement.setString(3, this.passengergender);
	       preparedStatement.setString(4, this.email);
	       //preparedStatement.setString(5, this.Telephone);
	       //preparedStatement.setString(6, this.Email);
	       //preparedStatement.setString(6, this.gender);
	       
	          
	        
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
	 
			public static ResultSet viewData() {
		        String host = "jdbc:mysql://localhost/baraka_ritha_fb";
		        String user = "222010945";
		        String password = "222010945";

		        String sql = "SELECT * FROM passengers";

		        try {
		            Connection con = DriverManager.getConnection(host, user, password);
		            PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
	public void update(int inputpassengerid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/baraka_ritha_fb";
	    String user = "222010945";
	    String password = "222010945";

	    // SQL query to update data
	    String sql = "UPDATE passengers SET  flightid=? passengername=? gender=? email=? WHERE passengerid  = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getFlightid());
	          stm.setString(2, this.getPassengername());
	          stm.setString(3, this.getPassengergender());
	          stm.setString(4, this.getEmail());
	         // stm.setString(5, this.getTelephone());
	         // stm.setString(6, this.getEmail());
	          
	          
	          
	          // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(4,inputpassengerid);
	       
	        // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputpassengerid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/baraka_ritha_fb";
	    String user = "222010945";
	    String password = "222010945";

	    // SQL query to delete data
	    String sql = "DELETE FROM passengers WHERE  passengerid =?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputpassengerid); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	}
	}
