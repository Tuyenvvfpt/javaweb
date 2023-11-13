package com.example.demo_serverlet.entities;

public class Product {
    private int id;
    private String name;
    private String price;
    private String name_file;
    private int id_category;

    public Product() {
    }

    public Product(int id, String name, String price, String name_file, int id_category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.name_file = name_file;
        this.id_category = id_category;
    }
    public Product( String name, String price, String name_file, int id_category) {
        this.name = name;
        this.price = price;
        this.name_file = name_file;
        this.id_category = id_category;
    }
    public Product( String name, String price, String name_file) {
        this.name = name;
        this.price = price;
        this.name_file = name_file;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName_file() {
        return name_file;
    }

    public void setName_file(String name_file) {
        this.name_file = name_file;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
}
