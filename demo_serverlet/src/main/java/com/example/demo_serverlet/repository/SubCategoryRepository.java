package com.example.demo_serverlet.repository;

import com.example.demo_serverlet.entities.Category;
import com.example.demo_serverlet.entities.SubCategory;
import com.example.demo_serverlet.utils.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubCategoryRepository {

    public List<SubCategory> getAll(){
        DBContext context = new DBContext();
        List<SubCategory> subCategoryList = new ArrayList<>();

        Connection connection = context.openConnection();
        String sql = "select * from subCategory";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int id_category = resultSet.getInt("id_category");
                SubCategory subCategory = new SubCategory(id,name,id_category);
                subCategoryList.add(subCategory);
            }
            connection.close();
            return subCategoryList;
        }catch (Exception e){
            return  subCategoryList;
        }

    }


    public boolean insert(SubCategory subCategory){
        DBContext context = new DBContext();
        Connection connection = context.openConnection();
        String sql = "insert into sub_category(name,id_category) values (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,subCategory.getName());
            preparedStatement.setInt(2,subCategory.getId_category());
            preparedStatement.executeUpdate();
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
