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

@WebServlet("/AddComplete")
@MultipartConfig
public class AddCompleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DishService dishService = DishService.getInstance();
        DishDao dishDao = DishDao.getInstance();
        CreateImagePath createImagePath = CreateImagePath.getInstance();

        DishDto dishDto = new DishDto(0L, req.getParameter("category"),
                req.getParameter("description"),
                req.getPart("image").getSize() != 0 ? createImagePath.CreateImagePath(req.getPart("image"),
                        req.getParameter("id"),
                        getServletContext().getRealPath("/img/")): req.getParameter("image"),
                req.getParameter("name"), Long.valueOf(req.getParameter("price")));

        Long id = dishDao.save(dishService.fromDtotoDish(dishDto)).getId();
        req.setAttribute("dish", dishService.findById(id));
        req.getRequestDispatcher("WEB-INF/jsp/complete.jsp").forward(req, resp);
    }
}
