import java.sql.*;

public class BatchUpdateDemo {
	public static void main(String args[] ) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
			System.out.println("\nConnection Successful.\n");
		
			con.setAutoCommit(false);
			st = con.createStatement();
			st.execute("create table account(id number, name varchar2(30), amt number)");
			st.addBatch("insert into account values(7,'Rishi',90000)");
			st.addBatch("insert into account values(8,'Hemanth',99999)");
			st.executeBatch();
			con.commit();
			System.out.println("\nBatch Execute Successful.\n");
			
			con.close();
			st.close();
		} catch(Exception e) {
			try {
				System.out.println(e);
				System.out.println("\nBatch Execute Unsuccessful.\n");
				con.rollback();
			} catch(Exception e1) {
				System.out.println(e1);
			}
		}
	}
}

/*
	Before running create table with
	create table account(id number, name varchar2(30), amt number)

	To Run: java -cp C:\oraclexe\app\oracle\product\10.2.0\server\jdbc\lib\ojdbc14.jar BatchUpdateDemo
 */