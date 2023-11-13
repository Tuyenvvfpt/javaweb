package com.example.demo_serverlet.repository;

import com.example.demo_serverlet.entities.Category;
import com.example.demo_serverlet.entities.Product;
import com.example.demo_serverlet.utils.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {


    public boolean insert(Product product){
        DBContext context = new DBContext();
        Connection connection = context.openConnection();
        String sql = "insert into product(name,price,status,image,id_subcategory) values (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getPrice());
            preparedStatement.setString(3,"1"); //lúc mới đầu thêm vào mặc định là 1
            preparedStatement.setString(4,product.getName_file());
            preparedStatement.setInt(5,product.getId_category());
            preparedStatement.executeUpdate();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Product> getAll(){
        DBContext context = new DBContext();
        List<Product> products = new ArrayList<>();

        Connection connection = context.openConnection();
        String sql = "select * from product";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int status = resultSet.getInt("status");
                String price = resultSet.getString("price");
                String name_image = resultSet.getString("image");
                Product product = new Product(name,price,name_image);
                products.add(product);
            }
            connection.close();
            return products;
        }catch (Exception e){
            return  products;
        }

    }

    public List<Product> finById(int id_sub){
        DBContext context = new DBContext();
        List<Product> products = new ArrayList<>();

        Connection connection = context.openConnection();
        String sql = "select * from product where id_subcategory =?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id_sub);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int status = resultSet.getInt("status");
                String price = resultSet.getString("price");
                String name_image = resultSet.getString("image");
                Product product = new Product(name,price,name_image);
                products.add(product);
            }
            connection.close();
            return products;
        }catch (Exception e){
            return  products;
        }

    }
}
