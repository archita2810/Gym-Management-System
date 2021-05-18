import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Registration {

	public void reg() {
		
		JFrame ob = new JFrame();
		ob.setSize(700, 700);
		ob.setTitle("Registration");
		ob.setResizable(false);
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		p1.setLayout(null);
		p2.setLayout(null);
		
		p1.setBounds(0, 0, 700, 150);
		p1.setBackground(Color.BLUE);
		ob.add(p1);
		
		
		p2.setSize(700, 700);
		p2.setBackground(Color.BLACK);
		ob.add(p2);
		
		
		JLabel title = new JLabel("Registration");
		title.setBounds(130, 20, 700, 150);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("serif",Font.BOLD,75));
		p1.add(title);
		
		// Name
		JLabel name = new JLabel("Name");
		name.setBounds(100, 180, 700, 50);
		name.setForeground(Color.WHITE);
		name.setFont(new Font("serif",Font.ITALIC,35));
		p2.add(name);
		
		// Name - button
		JTextField tname = new JTextField();
		tname.setBounds(280, 180, 180, 40);
		tname.setFont(new Font("times new roman",Font.CENTER_BASELINE,20));
		p2.add(tname);
		
		// Address
		JLabel address = new JLabel("Address");
		address.setBounds(100, 250, 700, 50);
		address.setForeground(Color.WHITE);
		address.setFont(new Font("serif",Font.ITALIC,35));
		p2.add(address);
				
		// Address - button
		JTextField taddress = new JTextField();
		taddress.setBounds(280, 250, 180, 40);
		taddress.setFont(new Font("times new roman",Font.CENTER_BASELINE,20));
		p2.add(taddress);
		
		
		// Gender
		JLabel gender = new JLabel("Gender");
		gender.setBounds(100, 310, 700, 50);
		gender.setForeground(Color.WHITE);
		gender.setFont(new Font("serif",Font.ITALIC,35));
		p2.add(gender);
		
		// Gender - button
		JRadioButton r1 = new JRadioButton("Male");
		r1.setForeground(Color.WHITE);
	
		JRadioButton r2 = new JRadioButton("Female");
		r2.setForeground(Color.WHITE);

		r1.setBounds(280,310,90,50);
		r2.setBounds(370,310,90,50);
		r1.setBackground(Color.BLACK);
		r2.setBackground(Color.BLACK);
		
		r1.setFont(r1.getFont().deriveFont(18.0f));
		r2.setFont(r2.getFont().deriveFont(18.0f));
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		p2.add(r1);
		p2.add(r2);
		
		// Birthdate
		JLabel birthdate = new JLabel("Birth date");
		birthdate.setBounds(100, 370, 700, 50);
		birthdate.setForeground(Color.WHITE);
		birthdate.setFont(new Font("serif",Font.ITALIC,35));
		p2.add(birthdate);
						
		// Birthdate - button
		JTextField tbirthdate = new JTextField();
		tbirthdate.setBounds(280, 370, 180, 40);
		tbirthdate.setFont(new Font("times new roman",Font.CENTER_BASELINE,20));
		p2.add(tbirthdate);
		
		// Username
		JLabel username = new JLabel("User name");
		username.setBounds(100, 440, 700, 50);
		username.setForeground(Color.WHITE);
		username.setFont(new Font("serif",Font.ITALIC,35));
		p2.add(username);
								
		// username - textfield
		JTextField tusername = new JTextField();
		tusername.setBounds(280, 440, 180, 40);
		tusername.setFont(new Font("times new roman",Font.CENTER_BASELINE,20));
		p2.add(tusername);
		
		// Password
		JLabel password = new JLabel("Password");
		password.setBounds(100, 520, 700, 50);
		password.setForeground(Color.WHITE);
		password.setFont(new Font("serif",Font.ITALIC,35));
		p2.add(password);
										
		// password - textfield
		JTextField tpassword = new JTextField();
		tpassword.setBounds(280, 520, 180, 40);
		tpassword.setFont(new Font("times new roman",Font.CENTER_BASELINE,20));
		p2.add(tpassword);
		
		// Submit - button
		JButton submit = new JButton("SUBMIT");
		submit.setBounds(250, 600, 150, 40);
		submit.setFont(new Font("serif",Font.BOLD,25));
		submit.setBackground(Color.WHITE);
		p2.add(submit);
		
		
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String n = tname.getText();
				String a = taddress.getText();
				String b = tbirthdate.getText();
				String u = tusername.getText();
				String p = tpassword.getText();
	
				String g;
				
				if(r1.isSelected()) {
					g = "Male";
				} else if(r2.isSelected()) {
					g = "Female";
				} else {
					g = "No button is selected";
				}
				
			
				
				 try {
	            	 
		             Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root", "root");

		             Statement stmt = (Statement) ((java.sql.Connection) conn).createStatement();
		             String str = "Select * from info.regdata";
		             ResultSet rs = ((java.sql.Statement) stmt).executeQuery(str);
		             
		             int uid = 0;
		             while(rs.next()) {
		             
		            	  uid = rs.getInt(1);
		             }
		             
		             uid++;
		             
		             PreparedStatement pst = conn.prepareStatement("insert into regdata values(?, ?, ?, ?, ?, ?, ?)");
		         
		             
		             pst.setInt(1, uid);
		             pst.setString(2, n);
	                 pst.setString(3, a);
	                 pst.setString(4, g);
	                 pst.setString(5, b);
	                 pst.setString(6, u);
	                 pst.setString(7, p);
	                 
	                 
	                int x =  pst.executeUpdate();
	                System.out.println(x);
	                
				 } catch (Exception excp) {
					 
					 System.out.println(excp);
				 }
			}
		});
		
		
		ob.setVisible(true);
		ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		
		Registration regobj = new Registration();
		regobj.reg();
	}

}
