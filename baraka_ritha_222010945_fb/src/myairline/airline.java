package myairline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.Spring;

public class airline {
private int airlineid;
private String airlinecode;
private String airlinename;

public airline(int airlineid,String airlinecode,String airlinename ) {
super();
this.airlineid = airlineid;
this.airlinecode = airlinecode;
this.airlinename = airlinename;	
	
}

public airline() {
	// TODO Auto-generated constructor stub
}

public int getAirlineid() {
	return airlineid;
}

public void setAirlineid(int airlineid) {
	this.airlineid = airlineid;
}

public String getAirlinecode() {
	return airlinecode;
}

public void setAirlinecode(String airlinecode) {
	this.airlinecode = airlinecode;
}

public String getAirlinename() {
	return airlinename;
}

public void setAirlinename(String airlinename) {
	this.airlinename = airlinename;
}
public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/baraka_ritha_fb";
    String user = "222010945";
    String password = "222010945";

    // SQL query to insert data
    String sql = "INSERT INTO airline(airlinecode,airlinename) VALUES (?,?,)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.airlinecode);
       preparedStatement.setString(2, this.airlinename);
       //preparedStatement.setString(3, this.Position);
       //preparedStatement.setString(4, this.BranchID);
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

	        String sql = "SELECT * FROM airline";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputairlineid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/baraka_ritha_fb";
    String user = "222010945";
    String password = "222010945";

    // SQL query to update data
    String sql = "UPDATE airline SET  airlinecode=? airlinename=?   WHERE airlineid = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getAirlinecode());
          stm.setString(2, this.getAirlinename());
         // stm.setString(3, this.getPosition());
        //  stm.setString(4, this.getBranchID());
         // stm.setString(5, this.getTelephone());
         // stm.setString(6, this.getEmail());
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(3,inputairlineid);
       
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
public void delete(int inputairlineid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/baraka_ritha_fb";
    String user = "222010945";
    String password = "222010945";

    // SQL query to delete data
    String sql = "DELETE FROM airline WHERE  airlineid =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputairlineid); // Assuming there is a column named 'id' for the WHERE clause

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
	

