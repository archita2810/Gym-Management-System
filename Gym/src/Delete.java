import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Delete {

		 void deleteRecord(int m) {
			
			JFrame ob = new JFrame();
			ob.setSize(700, 700);
			ob.setTitle("Delete record");
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
			
			
			
			//update
			if(m == 1) {
			
				String input[] = {" name", "address", "gender", "birthdate", "username", "password"};
				
				
				JComboBox c1 = new JComboBox(input);
				c1.setBounds(50, 250, 180, 40);
				p2.add(c1);
					
				JLabel jl1 = new JLabel("Enter name");
				jl1.setBounds(100, 350, 700, 50);
				jl1.setForeground(Color.WHITE);
				jl1.setFont(new Font("serif",Font.ITALIC,35));
				p2.add(jl1);
				
				JTextField textprev = new JTextField();
				textprev.setBounds(310, 350, 180, 40);
				textprev.setFont(new Font("times new roman",Font.CENTER_BASELINE,20));
				p2.add(textprev);
				
				JLabel jl2 = new JLabel("New record");
				jl2.setBounds(100, 450, 700, 50);
				jl2.setForeground(Color.WHITE);
				jl2.setFont(new Font("serif",Font.ITALIC,35));
				p2.add(jl2);
				
				
				JTextField textchanged = new JTextField();
				textchanged.setBounds(310, 450, 180, 40);
				textchanged.setFont(new Font("times new roman",Font.CENTER_BASELINE,20));
				p2.add(textchanged);
				
				
				JButton btn = new JButton("Update");
				btn.setBounds(150, 550, 150, 40);
				btn.setFont(new Font("serif",Font.BOLD,25));
				btn.setBackground(Color.WHITE);
				p2.add(btn);
				
				
				
				btn.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
					
						try {
							
							Class.forName("com.mysql.cj.jdbc.Driver");
							String url = "jdbc:mysql://localhost:3306/info";
							String username = "root";
							String password = "root";

							String n1 = textprev.getText();
							String n2 = textchanged.getText();
							String n3 = (String) c1.getSelectedItem(); 
									
							Connection con = DriverManager.getConnection(url, username, password);
				
							String sql = null;
							
							if(n3.equals("name")) {
								
								sql = "update regdata set name = ? where name = ?";
								
							} else if(n3.equals("address")) {
								
								sql = "update regdata set address = ? where name = ?";
														
							} else if(n3.equals("gender")) {
								
								sql = "update regdata set gender = ? where name = ?";
									
							} else if(n3.equals("birthdate")) {
								
								 sql = "update regdata set birthdate = ? where name = ?";
							
							} else if(n3.equals("username")) {
								
								sql = "update regdata set username = ? where name = ?";
							
							} else if(n3.equals("password")) {
								
								 sql = "update regdata set password = ? where name = ?";
							}
						
							PreparedStatement pstmt = con.prepareStatement(sql);	
							
							pstmt.setString(1,n2);
							pstmt.setString(2, n1);
						
							pstmt.executeUpdate();
	
							
						} catch (Exception excp) {
							
							System.out.println(excp);
						}	
					}
				});
			}

				
			
			
			// delete
			if(m == 0) {
				
				JLabel name = new JLabel("Name");
				name.setBounds(100, 250, 700, 50);
				name.setForeground(Color.WHITE);
				name.setFont(new Font("serif",Font.ITALIC,35));
				p2.add(name);
				
				JTextField textuname = new JTextField();
				textuname.setBounds(310, 250, 180, 40);
				textuname.setFont(new Font("times new roman",Font.CENTER_BASELINE,20));
				p2.add(textuname);
				
				
				
				JButton btn = new JButton("Delete");
				btn.setBounds(150, 450, 150, 40);
				btn.setFont(new Font("serif",Font.BOLD,25));
				btn.setBackground(Color.WHITE);
				p2.add(btn);
				
				btn.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
					
						try {
							
							Class.forName("com.mysql.cj.jdbc.Driver");
							String url = "jdbc:mysql://localhost:3306/info";
							String username = "root";
							String password = "root";

							Connection con = DriverManager.getConnection(url, username, password);
							Statement stmt = (Statement) ((java.sql.Connection) con).createStatement();
							stmt.executeUpdate("delete from regdata where name =  '" + textuname.getText() + "' ");		
						
						} catch (Exception excp) {
							
							System.out.println(excp);
						}	
					}
				});
			}
			
			ob.setVisible(true);
			ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			}		

	
	public static void main(String[] args) {
		
		

	}

	}

