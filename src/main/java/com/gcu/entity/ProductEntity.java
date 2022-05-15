package com.gcu.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("products")
public class ProductEntity {

    @Id
    Long id;

    @Column("name")
    String name;

    @Column("price")
    String price;

    @Column("instock")
    String instock;

    public ProductEntity(Long id, String name, String price, String instock) {
        this.id = id;
        this.name = name;

        this.price = price;
        this.instock = instock;
    }

    public ProductEntity() {}

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
