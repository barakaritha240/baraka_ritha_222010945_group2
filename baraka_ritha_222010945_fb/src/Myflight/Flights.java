package Myflight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Flights {

    private int flightid;
    private String airlineid;
    private String ticketprice;
    private String availableseats;

    public Flights(int flightid, String airlineid, String ticketprice, String availableseats) {
        this.flightid = flightid;
        this.airlineid = airlineid;
        this.ticketprice = ticketprice;
        this.availableseats = availableseats;
    }

    public Flights() {
        // Default constructor
    }

    // Getters and setters

    public String getAirlineid() {
        return airlineid;
    }

    public void setAirlineid(String airlineid) {
        this.airlineid = airlineid;
    }

    public int getFlightid() {
        return flightid;
    }

    public void setFlightid(int flightid) {
        this.flightid = flightid;
    }

    public String getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(String ticketprice) {
        this.ticketprice = ticketprice;
    }

    public String getAvailableseats() {
        return availableseats;
    }

    public void setAvailableseats(String availableseats) {
        this.availableseats = availableseats;
    }

    public void insertData() {
        String host = "jdbc:mysql://localhost/baraka_ritha_fb";
        String user = "222010945";
        String password = "222010945";

        String sql = "INSERT INTO flights (flightid, airlineid, ticketprice, availableseats) VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(host, user, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql);) {

            preparedStatement.setInt(1, this.flightid);
            preparedStatement.setString(2, this.airlineid);
            preparedStatement.setString(3, this.ticketprice);
            preparedStatement.setString(4, this.availableseats);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
                JOptionPane.showMessageDialog(null, "Data inserted successfully!", "After insert", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to insert data.");
                JOptionPane.showMessageDialog(null, "Failed to insert data!", "After insert", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet viewData() {
        String host = "jdbc:mysql://localhost/baraka_ritha_fb";
        String user = "222010945";
        String password = "222010945";

        String sql = "SELECT * FROM flights";

        try (Connection con = DriverManager.getConnection(host, user, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(int inputflightid) {
        String url = "jdbc:mysql://localhost/baraka_ritha_fb";
        String user = "222010945";
        String password = "222010945";

        String sql = "UPDATE flights SET airlineid=?, ticketprice=?, availableseats=? WHERE flightid=?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, this.airlineid);
            stm.setString(2, this.ticketprice);
            stm.setString(3, this.availableseats);
            stm.setInt(4, inputflightid);

            int rowsAffected = stm.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data updated successfully!");
                JOptionPane.showMessageDialog(null, "Data updated successfully!", "After update", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to update data. No matching record found.");
                JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found!", "After update", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int inputflightid) {
        String url = "jdbc:mysql://localhost/baraka_ritha_fb";
        String user = "222010945";
        String password = "222010945";

        String sql = "DELETE FROM flights WHERE flightid=?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pl = con.prepareStatement(sql)) {

            pl.setInt(1, inputflightid);

            int rowsAffected = pl.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data deleted successfully!");
                JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to delete data. No matching record found.");
                JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found!", "After delete", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
