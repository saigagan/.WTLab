import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;;

public class DemoServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException {  
        res.setContentType("text/html");  
        PrintWriter out = res.getWriter();
        ServletContext context = getServletContext();
        String driverName = context.getInitParameter("dname");  
        
        out.println("Driver name is = " + driverName);  
        out.close();  
    }
}
