import java.sql.*;

class DBInsert
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","nikhil","nikhil4433");
			System.out.println("\nConnection Successful.\n");
			
			Statement st=con.createStatement();
			
			st.execute("insert into Account values(1,'Ramu',50000)");
			st.execute("insert into Account values(2,'Ramesh',70000.25)");
			st.execute("insert into Account values(3,'Sharath',80000)");
			System.out.println("Insert Operation Successful.");
			
			st.close();
			con.close();
		}
		
		catch(Exception sqle)
		{
			System.out.println("Exception: "+sqle);
		}
	}
}