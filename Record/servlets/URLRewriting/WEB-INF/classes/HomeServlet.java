import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("name");

        out.println("<html><head><title>Home Page</title></head><body>");
        out.println("<h2>Welcome to CVR Collge of Enginnering</h2>");
        out.println("<h5><a href =./user?name=" + name + ">" + name + "</a></h5>");
        out.println("</body></html>");
    }
}