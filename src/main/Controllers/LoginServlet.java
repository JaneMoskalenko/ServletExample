import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    final static Logger LOGGER = Logger.getLogger(LoginServlet.class);
    static{
        BasicConfigurator.configure();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
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
        LOGGER.debug("Request for login page");
        resp.getWriter().println("Hello world");
        request.getRequestDispatcher("/jsp_login.jsp").forward(request, resp);
    }
}
