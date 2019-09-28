import java.sql.*;

public class DBInsert {
	public static void main(String args[]) {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
			System.out.println("\nConnection Successful.\n");
			
			Statement st = con.createStatement();
			st.execute("insert into Account values(1,'Ramu',50000)");
			st.execute("insert into Account values(2,'Ramesh',70000.25)");
			st.execute("insert into Account values(3,'Sharath',80000)");
			System.out.println("Insert Operation Successful.");
			
			st.close();
			con.close();
		} catch(Exception sqle) {
			System.out.println("Exception: "+sqle);
		}
	}
}

/*
	Before running create table with
	create table account(id number, name varchar2(30), amt number)

	To Run: java -cp C:\oraclexe\app\oracle\product\10.2.0\server\jdbc\lib\ojdbc14.jar DBInsert
 */