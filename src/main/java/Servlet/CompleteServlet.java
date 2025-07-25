package Servlet;

import Dao.DishDao;
import Dto.DishDto;
import Service.DishService;
import Utils.CreateImagePath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/complete")
@MultipartConfig
public class CompleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DishService dishService = DishService.getInstance();
        DishDao dishDao = DishDao.getInstance();
        CreateImagePath createImagePath = CreateImagePath.getInstance();

        DishDto dishDto = new DishDto(Long.valueOf(req.getParameter("id")), req.getParameter("category"),
                req.getParameter("description"),
                req.getPart("image").getSize() != 0 ? createImagePath.CreateImagePath(req.getPart("image"),
                        req.getParameter("id"),
                        getServletContext().getRealPath("/img/")): req.getParameter("image"),
                req.getParameter("name"), Long.valueOf(req.getParameter("price")));
        dishDao.update(dishService.fromDtotoDish(dishDto));
        Long id = Long.valueOf(req.getParameter("id"));
        req.setAttribute("dish", dishService.findById(id));
        req.getRequestDispatcher("WEB-INF/jsp/complete.jsp").forward(req, resp);
    }
}
