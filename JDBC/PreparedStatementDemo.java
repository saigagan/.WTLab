import java.sql.*;

public class PreparedStatementDemo {
	public static void main(String args[]) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
		System.out.println("\nConnection Successful.\n");
		
		ps = con.prepareStatement("insert into account values(?,?,?)");
		ps.setInt(1,4);
		ps.setString(2,"Prajeet");
		ps.setInt(3,50000);
		ps.execute();
		System.out.println("Insert Operation Successful.");
		
		ps.close();
		con.close();
	}
}

/*
	Before running create table with
	create table account(id number, name varchar2(30), amt number)

	To Run: java -cp C:\oraclexe\app\oracle\product\10.2.0\server\jdbc\lib\ojdbc14.jar PreparedStatementDemo
 */