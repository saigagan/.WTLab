import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.*;

public class MyFilter implements Filter {
    public void init(FilterConfig arg0) throws ServletException {}  

    public void doFilter(ServletRequest req, ServletResponse res,  FilterChain chain) throws IOException, ServletException {  
        PrintWriter out = res.getWriter();  
        String password = req.getParameter("password");  
    
        if(password.equals("admin")) {  
            chain.doFilter(req, res);
        } else {
            out.print("username or password error!");  
            RequestDispatcher rd = req.getRequestDispatcher("index.html");  
            rd.include(req, res);  
        }  
    }  
    
    public void destroy() {}
}  