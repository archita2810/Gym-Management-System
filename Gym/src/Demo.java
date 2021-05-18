import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {

		public Demo() throws Exception {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/info";
			String username = "root";
			String password = "root";

			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = (Statement) ((java.sql.Connection) con).createStatement();
			
			 String str = "Select * from info.regdata";
             ResultSet rs = ((java.sql.Statement) stmt).executeQuery(str);

             while(rs.next()) {
            	 
            	 System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getString(4) + " | " + rs.getString(5) + " | " + rs.getString(6) + " | " + rs.getString(7) + " | ");
            	 
             }
             
             con.close();        
	}
		
		public static void main(String[] args) {
			
		}

}
