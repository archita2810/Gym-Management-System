import java.awt.Color;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Gym implements ActionListener {

	public Gym() {
		
		JFrame ob = new JFrame();
		ob.setSize(700, 700);
		ob.setTitle("Fitbox 0.2");
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
		
		JLabel name = new JLabel("FITBOX 2.0");
		name.setBounds(130, 20, 700, 150);
		name.setForeground(Color.WHITE);
		name.setFont(new Font("serif",Font.BOLD,75));
		p1.add(name);
	
		JLabel username = new JLabel("User name");
		username.setBounds(100, 250, 700, 50);
		username.setForeground(Color.WHITE);
		username.setFont(new Font("serif",Font.ITALIC,35));
		p2.add(username);
		
		JTextField textuname = new JTextField();
		textuname.setBounds(310, 250, 180, 40);
		textuname.setFont(new Font("times new roman",Font.CENTER_BASELINE,20));
		p2.add(textuname);
		
		JPasswordField pswd = new JPasswordField();
		pswd.setBounds(310, 320, 180, 40);
		pswd.setFont(new Font("times new roman",Font.CENTER_BASELINE,20));
		p2.add(pswd);
		
		JLabel name3 = new JLabel("Password");
		name3.setBounds(100, 320, 700, 50);
		name3.setForeground(Color.WHITE);
		name3.setFont(new Font("serif",Font.ITALIC,35));
		p2.add(name3);
		
		
		JButton btn = new JButton("Login");
		btn.setBounds(150, 450, 150, 40);
		btn.setFont(new Font("serif",Font.BOLD,25));
		btn.setBackground(Color.WHITE);
		p2.add(btn);
		
		/*
		btn.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			Login lg = new Login();
			Login.log();
		}
	});*/

		JButton btn2 = new JButton("Create Account");
		btn2.setBounds(320, 450, 200, 40);
		btn2.setFont(new Font("serif",Font.BOLD,25));
		btn2.setBackground(Color.WHITE);
		p2.add(btn2);
		
		btn.addActionListener(new ActionListener() {
			 
			public void actionPerformed(ActionEvent e)  {
				
				String userName = textuname.getText();
				String password = new String(pswd.getPassword());
	             
	             try {
	            	 
	             Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/info",
	                        "root", "root");

	             Statement stmt = (Statement) ((java.sql.Connection) con).createStatement();
	            
	  
	               String str = "Select * from info.regdata";
	             
	          
	             ResultSet rs = ((java.sql.Statement) stmt).executeQuery(str);

	             int flag = 0;
	             
	             while(rs.next()) {
	            	 
	            	 String a = rs.getString(6);
	            	 String b = rs.getString(7);
	            	 
	            	 if(userName.equals(a) && password.equals(b)) {
			
							flag = 1;
							Login lg = new Login();
							lg.log();
	            	 
	            	 } 
	            	 
	            	 String admin = "admin";
	            	 
	            	 if(userName.equals(admin) && password.equals("admin")) {
	         			
							flag = 1;
							admin ag = new admin();
							ag.adm();
							
							break;
	            	 
	            	 } 
	            	 
	            	
	             }  
	             
	             if(flag == 0) 
	            	 JOptionPane.showMessageDialog(null, "INVALID CREDENTIALS!");
	            	 
	             con.close();
	             
	             } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
	            }
	        });
		
		
		
		
		btn2.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			Registration rg = new Registration();
			rg.reg();
		}
	});

		
		ob.setVisible(true);
		ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws Exception {
		
		new Gym();
		
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		
	}

}




