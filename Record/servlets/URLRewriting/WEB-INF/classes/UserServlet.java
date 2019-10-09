import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;

public class UserServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        String name = req.getParameter("name");

        out.println("<html><head><title>User Page</title></head><body>");
        out.println("<h1>Good Morning, " + name + "</h1>");
        out.println("</body></html>");
    }
}
