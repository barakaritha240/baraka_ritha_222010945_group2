package myreservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class reservation {
	private int reservationid;
	private String passengerid;
	private String reservationtime;
	private String reservationdate;
	
	public reservation ( int reservationid,  String passengerid, String reservationtime, String reservationdate ) {
		super();
		this.reservationid = reservationid;
		this. passengerid = passengerid;
		this. reservationtime =  reservationtime;
		this. reservationdate =  reservationdate;
		
	}

	public reservation() {
		// TODO Auto-generated constructor stub
	}

	public int getReservationid() {
		return reservationid;
	}

	public void setReservationid(int reservationid) {
		this.reservationid = reservationid;
	}

	public String getPassengerid() {
		return passengerid;
	}

	public void setPassengerid(String passengerid) {
		this.passengerid = passengerid;
	}

	public String getReservationtime() {
		return reservationtime;
	}

	public void setReservationtime(String reservationtime) {
		this.reservationtime = reservationtime;
	}

	public String getReservationdate() {
		return reservationdate;
	}

	public void setReservationdate(String reservationdate) {
		this.reservationdate = reservationdate;
	}

public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/baraka_ritha_fb";
    String user = "222010945";
    String password = "222010945";

    // SQL query to insert data
    String sql = "INSERT INTO reservation (passengerid,reservationdate,reservationtime) VALUES (?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.passengerid);
       preparedStatement.setString(2, this.reservationdate);
       preparedStatement.setString(3, this.reservationtime);
      
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

	        String sql = "SELECT * FROM reservation";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputreservationid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/baraka_ritha_fb";
    String user = "222010945";
    String password = "222010945";

    // SQL query to update data
    String sql = "UPDATE reservation SET  passengerid=? reservationdate=? reservationtime=?  WHERE reservationid = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getPassengerid());
          stm.setString(2, this.getReservationdate());
          stm.setString(3, this.getReservationtime());
   
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(4,inputreservationid);
       
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
public void delete(int inputreservationid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/baraka_ritha_fb";
    String user = "222010945";
    String password = "222010945";

    // SQL query to delete data
    String sql = "DELETE FROM reservation WHERE  reservationid =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputreservationid); // Assuming there is a column named 'id' for the WHERE clause

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