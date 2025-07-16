package Servlet;

import Service.DishService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DishService dishService = DishService.getInstance();
        req.setAttribute("dishes", dishService.findAll());
        req.getRequestDispatcher("WEB-INF/jsp/admin.jsp").forward(req, resp);

    }
}
