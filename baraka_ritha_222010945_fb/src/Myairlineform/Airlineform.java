package Myairlineform;

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

import myairline.airline;

//import passengerform.passengerform1;

public class Airlineform implements ActionListener{
	JFrame frame;
	JLabel aid_lb=new JLabel("airlineid");
	JLabel ac_lb=new JLabel("airlinecode");
	JLabel an_lb=new JLabel("airlinename");


	JTextField aid_txf=new JTextField();
	JTextField ac_txf=new JTextField();
	JTextField an_txf=new JTextField();



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
	public Airlineform () {
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
		frame.setTitle("AIRLINE FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		aid_lb.setBounds(10, 10, 130, 30);
		ac_lb.setBounds(10, 50, 150, 30);
		an_lb.setBounds(10, 90, 150, 30);
		
		
		//ContactNmbr_lb.setBounds(10, 210, 170, 30);
		//gender_lb.setBounds(10, 250, 100, 30);
		
		aid_txf.setBounds(200, 10, 170, 30);
		ac_txf.setBounds(200, 50, 170, 30);
		an_txf.setBounds(200, 90, 170, 30);
		
		
		
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

		aid_lb.setFont(font);
		ac_lb.setFont(font);
		an_lb.setFont(font);
		
		
		//Email_lb.setFont(font);
		//genderBox.setFont(font);

		
		aid_txf.setFont(font);
		ac_txf.setFont(font);
		an_txf.setFont(font);
		
	
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(aid_lb);
		frame.add(ac_lb);
		frame.add(an_lb);
		

		
		frame.add(aid_txf);
		frame.add(ac_txf);
		frame.add(an_txf);
		

		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		airline ail=new airline();
		if(e.getSource()==insert_btn) {
			ail.setAirlinecode(ac_txf.getText());
			ail.setAirlinename(an_txf.getText());
			//ail.setPosition(pos_txf.getText());
			//emf.setBranchID(Bid_txf.getText());
			//emf.setTelephone(tel_txf.getText());
			//.setEmail(eml_txf.getText());
			ail.insertData();
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("airlinecode");
            model.addColumn("airlinename"); 
            ResultSet resultSet =airline.viewData();
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
	    	int id=Integer.parseInt(aid_txf.getText());
	    	ail.setAirlinecode(ac_txf.getText());
	    	ail.setAirlinename(an_txf.getText());
			//emf.setPosition(pos_txf.getText());
			//emf.setBranchID(Bid_txf.getText());
			//emf.setTelephone(tel_txf.getText());
			//emf.setEmail(eml_txf.getText());
			
			ail.update(id);
	    }
	  else {
			int id=Integer.parseInt(aid_txf.getText());
			ail.delete(id);}

	  }		
		public static void main(String[] args) {
			Airlineform ail=new Airlineform();
			System.out.println(ail);
		
			
		}

	}

