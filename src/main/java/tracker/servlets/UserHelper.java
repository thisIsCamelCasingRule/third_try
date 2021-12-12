package tracker.servlets;

import tracker.DAO.UserDao;
import tracker.DAO.UserDaoImpl;
import tracker.helpers.PostToGetRequestWrapper;
import tracker.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserHelper {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("templates/log.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        UserDao<User> u = new UserDaoImpl();
        User user = u.getUser(username);
        if(user.getUsername() == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/templates/log-error.jsp");
            rd.include(request, response);
            return;
        }else if(!user.getPassword().equals(password)){
            RequestDispatcher rd = request.getRequestDispatcher("/templates/log.jsp");
            rd.include(request, response);
            return;
        }

        session.setAttribute("user", user);
        RequestDispatcher dispatcher = servletContext
                .getRequestDispatcher("/templates/index.jsp");
        dispatcher.forward(new PostToGetRequestWrapper(request), response);

       // return;
    }
}
