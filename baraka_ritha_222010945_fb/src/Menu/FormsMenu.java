package Menu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import MyFlightform.Flightform;
import Myairlineform.Airlineform;
import mypaymentform.paymentform;
import myreservationform.reservationform;

public class FormsMenu extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu airlinemenu;
    private JMenu flightsmenu;
    private JMenu passengersmenu;
    private JMenu paymentmenu;
    private JMenu reservationmenu;
    private JMenu Logoutmenu;
    


	public FormsMenu() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem airlineItem;
    private JMenuItem flightsItem;
    private JMenuItem passengersItem;
    private JMenuItem paymentItem;
    private JMenuItem reservationItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public FormsMenu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        airlinemenu = new JMenu("airline");
        flightsmenu = new JMenu("flights");
        passengersmenu= new JMenu("passengers");
        paymentmenu = new JMenu("payments ");
        reservationmenu = new JMenu("reservation");
        Logoutmenu = new JMenu("Logout");
        		

        // Create menu items
        menuBar.add(airlinemenu);
        airlineItem = new JMenuItem("airlineform");
        airlineItem.addActionListener(this);
        
        menuBar.add(flightsmenu);
        flightsItem = new JMenuItem("flightsform");
        flightsItem.addActionListener(this);
        
        menuBar.add(passengersmenu);
        passengersItem = new JMenuItem("passengersform");
        passengersItem.addActionListener(this);
        
        menuBar.add(paymentmenu);
        paymentItem = new JMenuItem("paymentform");
        paymentItem.addActionListener(this);
        
        menuBar.add(reservationmenu);
        reservationItem = new JMenuItem("reservationform");
        reservationItem.addActionListener(this);

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        airlinemenu.add(airlineItem);
        flightsmenu.add(flightsItem);
        passengersmenu.add(passengersItem);
        paymentmenu.add(paymentItem);
        reservationmenu.add(reservationItem);
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel with background image
        JPanel dashboardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the image
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\mahoro chany\\Desktop\\New folder\\Bluesky.jpg");
                // Draw the image
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };



        // Initialize dashboard panel
        JPanel dashboardPanel1 = new JPanel();
        dashboardPanel1.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel1.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel1);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == airlineItem) {
            new Airlineform();
        
        } else if (e.getSource() == flightsItem) {
            new Flightform();
        
        } else if (e.getSource() == passengersItem) {
            new passengerform();
       
        } else if (e.getSource() == paymentItem) {
           new paymentform();
        
        } else if (e.getSource() == reservationItem) {
           new reservationform();
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormsMenu("TO PROJECT"));
    }
}



 


