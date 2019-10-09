import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServletConfig extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        ServletConfig config = getServletConfig();
        Enumeration<String> e = config.getInitParameterNames();
        String str = "";

        while (e.hasMoreElements()) {
            str = e.nextElement();
            out.print(str +": " + config.getInitParameter(str) + "<br>");
        }
        out.close();
    }
}
