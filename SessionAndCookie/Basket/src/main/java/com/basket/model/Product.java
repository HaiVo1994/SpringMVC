package com.basket.model;

public class Product {
    private int id;
    private String name;
    private int price;
    private String content;
    private String img;
    public Product() {
    }

    public Product(int id, String name, int price, String content, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.content = content;
        this.img = img;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
