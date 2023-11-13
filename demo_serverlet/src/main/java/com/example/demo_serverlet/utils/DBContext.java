package com.example.demo_serverlet.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    public Connection openConnection() {
        String DB_URL = "jdbc:mysql://localhost:3306/demo_second?useSSL=false&allowPublicKeyRetrieval=true"; //testdb la ten dtb ma cta ket noi den
        String USER_NAME = "root";
        String PASSWORD = "123456";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //driver của mysql de ket noi csdl
            Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD); //tao ra coonect toi csdl
            System.out.println("Connect Successfully");
            return connection;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

//    public static void main(String[] args) {
//        DBContext db = new DBContext();
//        db.openConnection();
//    }
}
