package mypaymentform;

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

import MyFlightform.Flightform;
import Myflight.Flights;
import mypayment.payment;
import myreservationform.reservationform;

public class paymentform implements ActionListener {
	JFrame frame;
	JLabel tid_lb=new JLabel("transactionid");
	JLabel rid_lb=new JLabel("reservationid");
	JLabel d_lb=new JLabel("date");
	JLabel a_lb=new JLabel("amount");


	JTextField tid_txf=new JTextField();
	JTextField rid_txf=new JTextField();
	JTextField d_txf=new JTextField();
	JTextField a_txf=new JTextField();
 

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
	public  paymentform() {
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
		frame.setTitle("PAYMENT FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		tid_lb.setBounds(10, 10, 130, 30);
		rid_lb.setBounds(10, 50, 150, 30);
		d_lb.setBounds(10, 90, 150, 30);
		a_lb.setBounds(10, 130, 170, 30);
		
		//ContactNmbr_lb.setBounds(10, 210, 170, 30);
		//gender_lb.setBounds(10, 250, 100, 30);
		
		tid_txf.setBounds(200, 10, 170, 30);
		rid_txf.setBounds(200, 50, 170, 30);
		d_txf.setBounds(200, 90, 170, 30);
		a_txf.setBounds(200, 130, 170, 30);
		
		
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

		tid_lb.setFont(font);
		rid_lb.setFont(font);
		d_lb.setFont(font);
		a_lb.setFont(font);
		

		tid_txf.setFont(font);
		rid_txf.setFont(font);
		d_txf.setFont(font);
		a_txf.setFont(font);
		
		
	
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(tid_lb);
		frame.add(rid_lb);
		frame.add(d_lb);
		frame.add(a_lb);

		
		frame.add(tid_txf);
		frame.add(rid_txf);
		frame.add(d_txf);
		frame.add(a_txf);


		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		payment pay=new payment();
		if(e.getSource()==insert_btn) {
			pay.setReservationid(rid_txf.getText());
			pay.setDate(d_txf.getText());
			pay.setAmount(a_txf.getText());
			//fly.setBranchID(Bid_txf.getText());
			//fly.setTelephone(tel_txf.getText());
			//emf.setEmail(eml_txf.getText());
			pay.insertData();
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("transactionid");
            model.addColumn("reservationid");
            model.addColumn("date");
            model.addColumn("amount");
          
           
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
	    	int id=Integer.parseInt(tid_txf.getText());
	    	pay.setReservationid(rid_txf.getText());
	    	pay.setDate(d_txf.getText());
	    	pay.setAmount(a_txf.getText());
	    	//fly.setBranchID(Bid_txf.getText());
			//emf.setTelephone(tel_txf.getText());
			//emf.setEmail(eml_txf.getText());
			
			pay.update(id);
	    }
	  else {
			int id=Integer.parseInt(tid_txf.getText());
			pay.delete(id);}

	  }		
		public static void main(String[] args) {
			paymentform pay=new paymentform();
			System.out.println(pay);
		
			
		}}