package Servlet;

import Dao.DishDao;
import Dto.DishDto;
import Service.DishService;
import Utils.CreateImagePath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/del")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DishService dishService = DishService.getInstance();
        DishDao dishDao = DishDao.getInstance();

        dishDao.delete(Long.valueOf(req.getParameter("id")));

        resp.sendRedirect("/gyrmaniya/admin");
    }
}
