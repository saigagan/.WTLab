import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  

public class RegisterUser extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html><head><title>Database Insert</title></head><body><h1>");

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String pwd = req.getParameter("pwd");
        String cpwd = req.getParameter("cpwd");

        if(!pwd.equals(cpwd)) {
            out.println("Passwords don't match");
            return;
        }

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            PreparedStatement ps = con.prepareStatement("INSERT INTO users(name, email, pwd) VALUES (?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pwd);
            
            if(ps.executeUpdate() > 0)
                out.println("Registration Successful");
            else
                out.println("An error occured while registration");
            
            ps.close();
            con.close();
        } catch(Exception ex) {
            out.println("An error occured while registration.<br>" + ex.getMessage());
        }
        
        out.println("</h1></body></html>");
    }
}

/**
 * Before running, create table in Oracle DB using,
 * create table users(id NUMBER GENERATED ALWAYS AS IDENTITY, name VARCHAR2(255), email varchar2(255), pwd varchar2(255));
 */