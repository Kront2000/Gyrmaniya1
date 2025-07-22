package Utils;

import Dao.CategoriesDao;
import Dao.DishDao;
import Dto.DishDto;
import Entity.Categories;
import Entity.Dish;
import Service.DishService;
import jakarta.servlet.http.Part;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        CategoriesDao categoriesDao = CategoriesDao.getInstance();
        DishDao dishDao = DishDao.getInstance();
        Dish dish = new Dish(1L,
                "2 горчицы, 3 кетчупа, 3 салфетки, 15 г мясного кайфа. Пышное тесто + моцарелла до последней нитки + сочные охотничьи и баварские колбаски + жареный лук и пикантный соус. (780 г, 1720 ккал)",
                "/img/pizza2.png",
                "Баварская",
                2200L);
        dishDao.save(dish);
//        DishService dishService = DishService.getInstance();
//        System.out.println(dishService.findById(20L));
//        CreateImagePath createImagePath = CreateImagePath.getInstance();


    }


}
