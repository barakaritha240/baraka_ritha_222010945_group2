package passengerform;

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

import passengertable.passengers;



public class passengerform1 implements ActionListener {
	JFrame frame;
	JLabel pid_lb=new JLabel("passengerid");
	JLabel fid_lb=new JLabel("flightid");
	JLabel pn_lb=new JLabel("passengername");
	JLabel pg_lb=new JLabel("passengergender");
	JLabel pe_lb=new JLabel("email");

	JTextField pid_txf=new JTextField();
	JTextField fid_txf=new JTextField();
	JTextField pn_txf=new JTextField();
	JTextField pg_txf=new JTextField();
	JTextField pe_txf=new JTextField();

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
	public passengerform1() {
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
		frame.setTitle("PASSENGER FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		pid_lb.setBounds(10, 10, 130, 30);
		fid_lb.setBounds(10, 50, 150, 30);
		pn_lb.setBounds(10, 90, 150, 30);
		pg_lb.setBounds(10, 130, 150, 30);
		pe_lb.setBounds(10, 170, 150, 30);
		//ContactNmbr_lb.setBounds(10, 210, 170, 30);
		//gender_lb.setBounds(10, 250, 100, 30);
		
		pid_txf.setBounds(200, 10, 170, 30);
		fid_txf.setBounds(200, 50, 170, 30);
		pn_txf.setBounds(200, 90, 170, 30);
		pg_txf.setBounds(200, 130, 170, 30);
		pe_txf.setBounds(200, 170, 170, 30);
		
		
		//Email_txf.setBounds(200, 210, 170, 30);
		//genderBox.setBounds(200, 250, 170, 30);
		//Buttons CRUD
		insert_btn.setBounds(10,250, 100, 60);
		Read_btn.setBounds(120,250, 100, 60);
		update_tbtn.setBounds(230,250, 100, 60);
		delete_btn.setBounds(340,250, 100, 60);
		table.setBounds(500, 10, 600, 240);
		table.setBounds(500, 10, 600, 240);
		table.setBounds(500, 10, 600, 240);
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		pid_lb.setFont(font);
		fid_lb.setFont(font);
		pn_lb.setFont(font);
		pg_lb.setFont(font);
		pe_lb.setFont(font);
		
		//Email_lb.setFont(font);
		//genderBox.setFont(font);

		pid_txf.setFont(font);
		fid_txf.setFont(font);
		pn_txf.setFont(font);
		pg_txf.setFont(font);
		pe_txf.setFont(font);
		
	
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(pid_lb);
		frame.add(fid_lb);
		frame.add(pn_lb);
		frame.add(pg_lb);
		frame.add(pe_lb);
		
		frame.add(pid_txf);
		frame.add(fid_txf);
		frame.add(pn_txf);
		frame.add(pg_txf);
		frame.add(pe_txf);

		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		passengers reserve=new passengers();
		if(e.getSource()==insert_btn) {
			reserve.setFlightid(fid_txf.getText());
			reserve.setPassengername(pn_txf.getText());
			reserve.setPassengergender(pg_txf.getText());
			reserve.setEmail(pe_txf.getText());
			//fly.setBranchID(Bid_txf.getText());
			//fly.setTelephone(tel_txf.getText());
			//emf.setEmail(eml_txf.getText());
			reserve.insertData();
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("pid");
            model.addColumn("fid");
            model.addColumn("pn");
            model.addColumn("pg");
            model.addColumn("pe");
           
           
            ResultSet resultSet = passengers.viewData();
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
	    	int id=Integer.parseInt(pid_txf.getText());
	    	reserve.setFlightid(fid_txf.getText());
			reserve.setPassengername(pn_txf.getText());
			reserve.setPassengergender(pg_txf.getText());
			reserve.setEmail(pe_txf.getText());
	    	//fly.setBranchID(Bid_txf.getText());
			//emf.setTelephone(tel_txf.getText());
			//emf.setEmail(eml_txf.getText());
			
			reserve.update(id);
	    }
	  else {
			int id=Integer.parseInt(pid_txf.getText());
			reserve.delete(id);}

	  }		
		public static void main(String[] args) {
			passengerform1 reserve=new passengerform1();
			System.out.println(reserve);
		
			
		}

	}

	
		
	



