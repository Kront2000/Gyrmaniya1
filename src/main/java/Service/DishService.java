package Service;

import Dao.DishDao;
import Dto.DishDto;
import Entity.Categories;
import Entity.Dish;
import Exeptions.DishNotFoundExeption;
import Utils.ExeptionMassages;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DishService {
    private static final DishService INSTANCE = new DishService();
    private final DishDao dishDao = DishDao.getInstance();
    private final CategoryService categoryService = CategoryService.getInstance();
    public List<DishDto> findAll(){
        return dishDao.findAll().stream().map(dish ->
                new DishDto(dish.getId(), dish.getCategories().getName(),
                        dish.getDescription(), dish.getImage_path(),
                        dish.getName(), dish.getPrice())
        ).collect(Collectors.toList());
    }
    public DishDto findById(Long id){
        Optional<Dish> optionalDish = dishDao.findById(id);

        Dish dish = optionalDish.orElseThrow(() -> new DishNotFoundExeption(ExeptionMassages.DISH_BY_ID_ERROR));
        return new DishDto(dish.getId(), dish.getCategories().getName(),
                        dish.getDescription(), dish.getImage_path(),
                        dish.getName(), dish.getPrice());
    }
    public Dish fromDtotoDish(DishDto dishDto){
        if(dishDto.id() != 0L){
            return new Dish(dishDto.id(), categoryService.fromCategorytoId(dishDto.category()),
                    dishDto.description(), dishDto.imagePath(), dishDto.name(),
                    dishDto.price());
        }else {
            return new Dish(categoryService.fromCategorytoId(dishDto.category()),
                    dishDto.description(), dishDto.imagePath(), dishDto.name(),
                    dishDto.price());
        }

    }

    private DishService(){}

     public static DishService getInstance(){
        return INSTANCE;
    }
}
