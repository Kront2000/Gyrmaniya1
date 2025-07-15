package Service;

import Dao.DishDao;
import Dto.DishDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DishService {
    private static final DishService INSTANCE = new DishService();
    private final DishDao dishDao = DishDao.getInstance();
    public List<DishDto> findAll(){
        return dishDao.findAll().stream().map(dish ->
                new DishDto(dish.getId(), dish.getCategories().getName(),
                        dish.getDescription(), dish.getImage_path(),
                        dish.getName(), dish.getPrice())
        ).collect(Collectors.toList());
    }

    private DishService(){}

     public static DishService getInstance(){
        return INSTANCE;
    }
}
