package com.gcu.model;

public class ProductModel {

    private Long id;

    private String name;

    private String price;

    private String instock;

    public ProductModel(Long id, String name, String price, String instock) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.instock = instock;
    }

    public ProductModel() {
    }

    //getters/setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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

    public String getInstock() {
        return instock;
    }

    public void setInstock(String instock) {
        this.instock = instock;
    }
}