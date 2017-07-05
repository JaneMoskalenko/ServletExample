import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
     //   resp.sendRedirect("https://google.com");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (AutorizationService.auth(login, password)) {
            req.getSession().setAttribute("isOuts",
                    true);
            resp.sendRedirect("/server/dashboard?param=" + login);
        }
        else {
            resp.sendRedirect(req.getContextPath()
                    +"/login");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Hello world");
        request.getRequestDispatcher("/jsp_login.jsp").forward(request, resp);
    }
}
