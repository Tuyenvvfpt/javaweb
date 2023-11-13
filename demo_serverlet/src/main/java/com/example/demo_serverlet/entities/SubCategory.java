package com.example.demo_serverlet.entities;

public class SubCategory {
    private int id;
    private String name;
    private int id_category;

    public SubCategory() {
    }

    public SubCategory(String name, int id_category) {
        this.name = name;
        this.id_category = id_category;
    }

    public SubCategory(int id, String name, int id_category) {
        this.id = id;
        this.name = name;
        this.id_category = id_category;
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

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
}
