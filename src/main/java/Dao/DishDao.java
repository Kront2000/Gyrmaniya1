package Dao;

import Entity.Categories;
import Entity.Dish;
import Exeptions.DaoExeption;
import Utils.ConnectionManager;
import Utils.ExeptionMassages;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private final static String FIND_BY_ID = """
            SELECT *, c.id AS category_id, c.name AS category_name, d.id AS dish_id, d.name AS dish_name 
            FROM dishes d
            JOIN categories c ON c.id = d.category_id
            WHERE d.id = ?
            """;
    private final static  String UPDATE_SQL = """
                UPDATE dishes SET category_id = ?, description = ?, image_path = ?, name = ?, price = ?
                WHERE id = ?
                
            """;
    private final static String DELETE_SQL = """
            DELETE FROM dishes
            WHERE id = ?
            """;

    public boolean update(Dish dish){
        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            statement.setLong(1, dish.getCategoriesID());
            statement.setString(2, dish.getDescription());
            statement.setString(3, dish.getImage_path());
            statement.setString(4, dish.getName());
            statement.setLong(5, dish.getPrice());
            statement.setLong(6, dish.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DaoExeption(ExeptionMassages.UPDATE_DAO_ERROR);
        }
    }
    public boolean delete(Long id) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
            throw new DaoExeption(ExeptionMassages.SAVE_DAO_ERROR);
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
            throw new DaoExeption(ExeptionMassages.FIND_DAO_ERROR);
        }
    }
    public Optional<Dish> findById(Long id) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            Dish dish = null;

            if (result.next()) {
                dish = new Dish(
                        result.getLong("dish_id"),
                        new Categories(result.getLong("category_id"), result.getString("category_name")),
                        result.getString("description"),
                        result.getString("image_path"),
                        result.getString("dish_name"),
                        result.getLong("price")
                );
                return Optional.of(dish);
            }
        } catch (SQLException e) {
            throw new DaoExeption(ExeptionMassages.FIND_DAO_ERROR);
        }
        return Optional.empty();
    }


    private DishDao(){}

    public static DishDao getInstance(){
        return INSTANCE;
    }




}
