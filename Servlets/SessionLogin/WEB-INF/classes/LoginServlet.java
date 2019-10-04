import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String n = req.getParameter("name");
		String p = req.getParameter("pwd");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			
			PreparedStatement ps = con.prepareStatement("select * from  login_cse where email=? and password=?");
			ps.setString(1, n);
			ps.setString(2, p);
	
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				out.print("Login Successfully");
				RequestDispatcher rd = req.getRequestDispatcher("dis");
				rd.forward(req,res);
			} else {
				out.print("Invalid Username and Password");
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req, res);
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		
		out.close();
	}
}
