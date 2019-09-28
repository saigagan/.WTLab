import java.sql.*;

public class CallableStatementDemo {
	public static void main(String args[]) throws Exception {
		Connection con = null;
		CallableStatement cst = null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
		System.out.println("\nConnection Successful.\n");
		
		cst = con.prepareCall("{call square(?,?)}");
		cst.setInt(1,3);
		cst.registerOutParameter(2,Types.INTEGER);
		cst.execute();
		System.out.println("\nProcedure Execution Successful.\n");
		System.out.println("\nSquare of given number is: " + cst.getInt(2) + "\n");
		
		cst.close();
		con.close();
	}
}

// Before running create this procedure
/*
	create or replace procedure square(a in number,b out number)
	as
		begin
		b:=a*a;
		end
	/
*/
// To Run: java -cp C:\oraclexe\app\oracle\product\10.2.0\server\jdbc\lib\ojdbc14.jar CallableStatementDemo