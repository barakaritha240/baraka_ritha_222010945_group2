package MyFlightform;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Myflight.Flights;
import myreservationform.reservationform;

public class Flightform implements ActionListener {
	JFrame frame;
	JLabel fid_lb=new JLabel("flightid");
	JLabel aid_lb=new JLabel("airlineid");
	JLabel tp_lb=new JLabel("ticketprice");
	JLabel as_lb=new JLabel("availableseats");


	JTextField fid_txf=new JTextField();
	JTextField aid_txf=new JTextField();
	JTextField tp_txf=new JTextField();
	JTextField as_txf=new JTextField();
 

	//String []gender={"Male", "Female"};
	//JComboBox<String> genderBox = new JComboBox<>(gender);

	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public Flightform() {
		createForm();
		actionEvent();
		setFontforall();
		addComponentToFrame();
		setLocationandSize();
	}
	private void actionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_tbtn.addActionListener(this);
		delete_btn.addActionListener(this);
		//genderBox.addActionListener(this);
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("FLIGHT FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		fid_lb.setBounds(10, 10, 130, 30);
		aid_lb.setBounds(10, 50, 150, 30);
		tp_lb.setBounds(10, 90, 150, 30);
		as_lb.setBounds(10, 130, 150, 30);
		
		//ContactNmbr_lb.setBounds(10, 210, 170, 30);
		//gender_lb.setBounds(10, 250, 100, 30);
		
		fid_txf.setBounds(200, 10, 170, 30);
		aid_txf.setBounds(200, 50, 170, 30);
		tp_txf.setBounds(200, 90, 170, 30);
		as_txf.setBounds(200, 130, 170, 30);
		
		
		
		//Email_txf.setBounds(200, 210, 170, 30);
		//genderBox.setBounds(200, 250, 170, 30);
		//Buttons CRUD
		insert_btn.setBounds(10,250, 100, 60);
		Read_btn.setBounds(120,250, 100, 60);
		update_tbtn.setBounds(230,250, 100, 60);
		delete_btn.setBounds(340,250, 100, 60);
		table.setBounds(500, 10, 600, 240);
}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		fid_lb.setFont(font);
		aid_lb.setFont(font);
		tp_lb.setFont(font);
		as_lb.setFont(font);
		
		
		//Email_lb.setFont(font);
		//genderBox.setFont(font);

		fid_txf.setFont(font);
		aid_txf.setFont(font);
		tp_txf.setFont(font);
		as_txf.setFont(font);
		
		
	
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(fid_lb);
		frame.add(aid_lb);
		frame.add(tp_lb);
		frame.add(as_lb);

		
		frame.add(fid_txf);
		frame.add(aid_txf);
		frame.add(tp_txf);
		frame.add(as_txf);


		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Flights fly=new Flights();
		if(e.getSource()==insert_btn) {
			fly.setAirlineid(aid_txf.getText());
			fly.setTicketprice(tp_txf.getText());
			fly.setAvailableseats(as_txf.getText());
			//fly.setBranchID(Bid_txf.getText());
			//fly.setTelephone(tel_txf.getText());
			//emf.setEmail(eml_txf.getText());
			fly.insertData();
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("EmployeeID");
            model.addColumn("FirstName");
            model.addColumn("LastName");
            model.addColumn("Position");
            model.addColumn("BranchID");
            model.addColumn("Telephone");
            model.addColumn("Email");
           
            ResultSet resultSet =Flights.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4),resultSet.getString(5),resultSet.getString(6), resultSet.getString(7)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_tbtn) {
	    	int id=Integer.parseInt(fid_txf.getText());
	    	fly.setAirlineid(aid_txf.getText());
	    	fly.setTicketprice(tp_txf.getText());
	    	fly.setAvailableseats(as_txf.getText());
	    	//fly.setBranchID(Bid_txf.getText());
			//emf.setTelephone(tel_txf.getText());
			//emf.setEmail(eml_txf.getText());
			
			fly.update(id);
	    }
	  else {
			int id=Integer.parseInt(fid_txf.getText());
			fly.delete(id);}

	  }		
		public static void main(String[] args) {
			Flightform ef=new Flightform();
			System.out.println(ef);
		
			
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

