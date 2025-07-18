package Servlet;

import Service.DishService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DishService dishService = DishService.getInstance();
        Long id = Long.valueOf(req.getParameter("id"));
        req.setAttribute("dish", dishService.findById(id));
        req.getRequestDispatcher("WEB-INF/jsp/edit.jsp").forward(req, resp);
    }
}
