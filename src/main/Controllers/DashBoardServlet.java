package Controllers;

import Model.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DashBoardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String reqParam = req.getParameter("param");
        req.setAttribute("parameter", reqParam);

        getServletContext().getRequestDispatcher("/jsp_dashboard.jsp")
                .forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String btn_deleteUser = req.getParameter("delete_user");
        if (btn_deleteUser != null) {
            String reqUserParam = req.getParameter("user_delete");
            if (UserDao.deleteUserByLogin(reqUserParam))
                System.out.println("User " + reqUserParam + " was succesfully deleted");
        }

        String btn_addUser = req.getParameter("add_user");
        if (btn_addUser != null) {
            String login = req.getParameter("login_add");
            String password = req.getParameter("password_add");

            if (Model.dao.UserDao.addUser(login, password))
                System.out.println("User " + password + " was succesfully added");
        }

        getServletContext().getRequestDispatcher("/jsp_dashboard.jsp")
                .forward(req, resp);

    }
}
