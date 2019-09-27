import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.io.IOException;

public class HelloMessage extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        String name = req.getParameter("name");

        PrintWriter out = res.getWriter();
        out.println("<html><head><title>Hello</title></head><body><h1>Welcome, " + name + "</h1></body></html>");
    }

}