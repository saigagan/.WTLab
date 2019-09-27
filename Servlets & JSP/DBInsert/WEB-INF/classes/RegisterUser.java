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

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String pwd = req.getParameter("pwd");
        String cpwd = req.getParameter("cpwd");

        if(!pwd.equals(cpwd)) {
            out.write("Passwords don't match");
            return;
        }

        try {
            pwd = toHexString(getSHA(pwd));

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            PreparedStatement ps = con.prepareStatement("insert into users values(?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pwd);
            
            if(ps.executeUpdate() > 0)
                out.write("Registration Successful");
            else
                out.write("An error occured while registration");
            
            ps.close();
            con.close();
        } catch(Exception ex) {
            out.write("An error occured while registration.<br>" + ex);
        }
    }

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
    {  
        MessageDigest md = MessageDigest.getInstance("SHA-512");  
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    } 
    
    public static String toHexString(byte[] hash) 
    { 
        BigInteger number = new BigInteger(1, hash);  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
        
        while (hexString.length() < 32)  
            hexString.insert(0, '0');
  
        return hexString.toString();  
    } 

}