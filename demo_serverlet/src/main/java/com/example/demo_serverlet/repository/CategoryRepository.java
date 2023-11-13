package com.example.demo_serverlet.repository;

import com.example.demo_serverlet.entities.Category;
import com.example.demo_serverlet.utils.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {


    public List<Category> getAll() {
        DBContext context = new DBContext();
        List<Category> categoryList = new ArrayList<>();

        Connection connection = context.openConnection();
        String sql = "select * from category";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int status = resultSet.getInt("status");
                Category category = new Category(id, name, status);
                categoryList.add(category);
            }
            connection.close();
            return categoryList;

        } catch (Exception e) {
            return categoryList;
        }

    }


    public boolean insert(Category category) {
        DBContext context = new DBContext();
        Connection connection = context.openConnection();
        String sql = "insert into category(name,status) values (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2, category.getStatus());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
