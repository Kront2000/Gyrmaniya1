package Servlet;

import Service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    LoginService loginService = LoginService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(loginService.login(req.getParameter("login"),req.getParameter("password"))){
            req.getSession().setAttribute("login", "true");
            resp.sendRedirect("/gyrmaniya/admin");
        }else{

            resp.sendRedirect("/gyrmaniya/login");
        }
    }
}
