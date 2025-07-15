package Dao;

import Entity.Categories;
import Entity.Dish;
import Utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDao {
    private final static DishDao INSTANCE = new DishDao();

    private final static String SAVE_SQL = """
        INSERT INTO dishes (category_id, description, image_path, name, price)
        VALUES (?, ?, ?, ?, ?)
    """;
    private final static String FIND_ALL_SQL = """
            SELECT *, c.id AS category_id, c.name AS category_name, d.id AS dish_id, d.name AS dish_name 
            FROM dishes d
            JOIN categories c ON c.id = d.category_id
            """;

    public Dish save(Dish dish){
        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, dish.getCategoriesID());
            statement.setString(2, dish.getDescription());
            statement.setString(3, dish.getImage_path());
            statement.setString(4, dish.getName());
            statement.setLong(5, dish.getPrice());
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            if(keys.next()){
                dish.setId(keys.getLong("id"));
            }
            return dish;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Dish> findAll(){
        List<Dish> list = new ArrayList<>();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_SQL)) {
            ResultSet result = statement.executeQuery();
            while (result.next()){
                list.add( new Dish(
                        result.getLong("dish_id"),
                        new Categories(result.getLong("category_id"), result.getString("category_name")),
                        result.getString("description"),
                        result.getString("image_path"),
                        result.getString("dish_name"),
                        result.getLong("price")
                ));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private DishDao(){}

    public static DishDao getInstance(){
        return INSTANCE;
    }




}
