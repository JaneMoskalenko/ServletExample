package Controllers;

import Service.AutorizationService;
import Service.IAuthorizationService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    final static Logger LOGGER = Logger.getLogger(LoginServlet.class);

    @Autowired
    IAuthorizationService iAuthorizationService;

    static{
        BasicConfigurator.configure();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (iAuthorizationService.auth(login, password)) {
//        if (AutorizationService.auth(login, password)) {
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
