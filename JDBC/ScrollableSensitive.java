import java.sql.*;

public class ScrollableSensitive {
	public static void main(String args[]) throws Exception {
		Connection con = null;
		Statement st = null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
		System.out.println("\nConnection Successful.\n");
		
		st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery("select * from account");
		
		System.out.println("All Records");
		while(rs.next())
			System.out.println("|"+rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getInt(3)+"|");
		
		rs.last();
		System.out.println("\nReplaced to Last Position");
		System.out.println("Row Position of Last: "+rs.getRow());
		System.out.println("Data at Last Position:\n|"+rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getInt(3)+"|\n");
		
		con.close();
		st.close();
		rs.close();
	}
}

// To Run: java -cp C:\oraclexe\app\oracle\product\10.2.0\server\jdbc\lib\ojdbc14.jar ScrollableSensitive