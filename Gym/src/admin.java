import java.awt.Color;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class admin {

	public void adm() {
		
		JFrame ob = new JFrame();
		ob.setSize(700, 700);
		ob.setTitle("Admin");
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
		
		JLabel name = new JLabel("Admin");
		name.setBounds(200, 20, 700, 150);
		name.setForeground(Color.WHITE);
		name.setFont(new Font("serif",Font.BOLD,75));
		p1.add(name);

		// View
		JLabel view = new JLabel("View");
		view.setBounds(100, 250, 700, 50);
		view.setForeground(Color.WHITE);
		view.setFont(new Font("serif",Font.ITALIC,35));
		p2.add(view);
				
		// View - button
		JButton bview = new JButton("View");
		bview.setBounds(280, 250, 180, 40);
		bview.setFont(new Font("serif",Font.BOLD,25));
		bview.setBackground(Color.WHITE);
		p2.add(bview);
		
		bview.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
				try {
				
					new Demo();
				} catch (Exception excp) {
					
					System.out.println(excp);
				}
			}
		});
		
		
		// Update
		JLabel update = new JLabel("Update");
		update.setBounds(100, 320, 700, 50);
		update.setForeground(Color.WHITE);
		update.setFont(new Font("serif",Font.ITALIC,35));
		p2.add(update);
			
		// Update - button
		JButton bupdate = new JButton("Update");
		bupdate.setBounds(280, 320, 180, 40);
		bupdate.setFont(new Font("serif",Font.BOLD,25));
		bupdate.setBackground(Color.WHITE);
		p2.add(bupdate);
		
		bupdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
				Delete obj2 = new Delete();
				obj2.deleteRecord(1);
			
			}
		});
		
		// Delete
		JLabel delete = new JLabel("Delete");
		delete.setBounds(100, 390, 700, 50);
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("serif",Font.ITALIC,35));
		p2.add(delete);
		
		// Delete - button
		JButton bdel = new JButton("Delete");
		bdel.setBounds(280, 390, 180, 40);
		bdel.setFont(new Font("serif",Font.BOLD,25));
		bdel.setBackground(Color.WHITE);
		p2.add(bdel);
		
		
		
		bdel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
				Delete obj = new Delete();
				obj.deleteRecord(0);
			
			}
		});
		
		
		ob.setVisible(true);
		ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {

		admin admin_obj = new admin();
		admin_obj.adm();
		
	}

}
