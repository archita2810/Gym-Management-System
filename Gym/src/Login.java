import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Login {

	public void log() {
		
		JFrame ob = new JFrame();
		ob.setSize(700, 700);
		ob.setTitle("Login");
		ob.setResizable(false);
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		p1.setLayout(null);
		p2.setLayout(null);
		
		p1.setBounds(0, 0, 700, 150);
		p1.setBackground(Color.BLUE);
		ob.add(p1);
		
		JLabel title = new JLabel("About us");
		title.setBounds(130, 20, 700, 150);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("serif",Font.BOLD,75));
		p1.add(title);
		
		p2.setSize(700, 700);
		p2.setBackground(Color.BLACK);
		ob.add(p2);
		
		JLabel vision = new JLabel("<html>Our goals and be truly satisfied,<br> we must first actively change our mindset<br> before physically working to our goal.<br> At FitBox Gym in Pimpri Chinchwad,<br> our exceptional professionals help our clients<br> first uncover the power of the Mind before<br> developing the other 2 pillars of health –<br> Nutrition and Training. Our Approach Frustrated with the poor<br> quality of services and lack of support that<br> health clubs have to offer throughout<br> Pune and Pimpri Chinchwad, Founder of<br>  FitBox Gym, Vikram brought a revolutionary and game-changing<br> concept for health and fitness.</html>", SwingConstants.CENTER);
		vision.setBounds(10, 50, 700, 700);
		vision.setForeground(Color.WHITE);
		vision.setFont(new Font("serif",Font.BOLD,20));
		p2.add(vision);
		
		
		ob.setVisible(true);
		ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		
	}

}
