package Service;

import Dao.CategoriesDao;
import Dao.DishDao;

public class CategoryService {
    final static private CategoryService INSTANCE = new CategoryService();
    CategoriesDao categoriesDao = CategoriesDao.getInstance();

    public Long fromCategorytoId(String category){
        return categoriesDao.findByCategory(category).getId();
    }

    public static CategoryService getInstance(){
        return INSTANCE;
    }
    private CategoryService(){}
}
