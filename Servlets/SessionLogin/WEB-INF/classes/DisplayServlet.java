import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class DisplayServlet extends HttpServlet {
        public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String name = req.getParameter("name");
        
        out.println("Weclome to Login page" + name);
    }
}
