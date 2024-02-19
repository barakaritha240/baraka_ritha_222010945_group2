package mypayment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class payment {
private int transactionid;
private String reservationid;
private String date;
private String amount;

public payment(int transactionid,String reservationid,String date,String amount) {
	super();
	this.transactionid =  transactionid;
	this.reservationid = reservationid;
	this.date = date;
	this.amount = amount;

}

public payment() {
	// TODO Auto-generated constructor stub
}

public int getTransactionid() {
	return transactionid;
}

public void setTransactionid(int transactionid) {
	this.transactionid = transactionid;
}

public String getReservationid() {
	return reservationid;
}

public void setReservationid(String reservationid) {
	this.reservationid = reservationid;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getAmount() {
	return amount;
}

public void setAmount(String amount) {
	this.amount = amount;
}
public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/baraka_ritha_fb";
    String user = "222010945";
    String password = "222010945";

    // SQL query to insert data
    String sql = "INSERT INTO payment (reservationid,date,amount) VALUES (?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.reservationid);
       preparedStatement.setString(2, this.date);
       preparedStatement.setString(3, this.amount);
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

	        String sql = "SELECT * FROM payment";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputtransactionid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/baraka_ritha_fb";
    String user = "222010945";
    String password = "222010945";

    // SQL query to update data
    String sql = "UPDATE payment SET  reservationid=? date=? amount=?  WHERE transactionid = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getReservationid());
          stm.setString(2, this.getDate());
          stm.setString(3, this.getAmount());
        //  stm.setString(4, this.getBranchID());
         // stm.setString(5, this.getTelephone());
         // stm.setString(6, this.getEmail());
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(4,inputtransactionid);
       
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
public void delete(int inputtransactionid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/baraka_ritha_fb";
    String user = "222010945";
    String password = "222010945";

    // SQL query to delete data
    String sql = "DELETE FROM payment WHERE  transactionid =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputtransactionid); // Assuming there is a column named 'id' for the WHERE clause

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
