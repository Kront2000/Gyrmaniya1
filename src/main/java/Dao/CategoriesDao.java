package Dao;

import Entity.Categories;
import Utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDao {
    private final static CategoriesDao INSTANCE = new CategoriesDao();

    private final static String SAVE_SQL = """
        INSERT INTO categories (name)
        VALUES (?)
    """;
    private final static String FIND_ALL_SQL = """
            SELECT * FROM categories
            """;

    public Categories save(Categories categories){
        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, categories.getName());
                statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            if(keys.next()){
                categories.setId(keys.getLong("id"));
            }
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Categories> findAll(){
        List<Categories> list = new ArrayList<>();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_SQL)) {
            ResultSet keys = statement.executeQuery();
            while (keys.next()){
                 list.add( new Categories(
                        keys.getLong("id"),
                        keys.getString("name")
                ));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private CategoriesDao(){}

    public static CategoriesDao getInstance(){
        return INSTANCE;
    }




}
