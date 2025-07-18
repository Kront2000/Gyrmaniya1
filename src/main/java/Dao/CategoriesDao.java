package Dao;

import Entity.Categories;
import Exeptions.DaoExeption;
import Utils.ConnectionManager;
import Utils.ExeptionMassages;

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
    private final static String GET_BY_CATEGORY = """
            SELECT * FROM categories
            WHERE name = ?
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
            throw new DaoExeption(ExeptionMassages.SAVE_DAO_ERROR);
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
            throw new DaoExeption(ExeptionMassages.FIND_DAO_ERROR);
        }
    }
    public Categories findByCategory(String category){
        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(GET_BY_CATEGORY)) {
            statement.setString(1, category);
            ResultSet keys = statement.executeQuery();
            if (keys.next()){ return new Categories(
                        keys.getLong("id"),
                        keys.getString("name")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new DaoExeption(ExeptionMassages.FIND_DAO_ERROR);
        }
    }


    private CategoriesDao(){}

    public static CategoriesDao getInstance(){
        return INSTANCE;
    }




}
