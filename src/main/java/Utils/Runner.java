package Utils;

import Dao.CategoriesDao;
import Dao.DishDao;
import Dto.DishDto;
import Entity.Categories;
import Entity.Dish;
import Service.DishService;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        CategoriesDao categoriesDao = CategoriesDao.getInstance();
        DishDao dishDao = DishDao.getInstance();
//        Dish dish = new Dish(1L,
//                "Тартар из лосося, сливочный сыр, огурец, соус терияки. Нежный тартар из лосося, сливочный сыр и свежий огурец, дополненные ароматным соусом терияки и зеленью. Изысканный вкус (322 гр, 370 ккал)",
//                "/img/img5.png",
//                "Филадельфия тартар",
//                2650L);
//        dishDao.save(dish);
        DishService dishService = DishService.getInstance();
        List<DishDto> list = dishService.findAll();
        for(DishDto dishDto : list){
            System.out.println(dishDto);
        }

    }


}
