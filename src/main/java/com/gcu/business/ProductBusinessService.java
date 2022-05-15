package com.gcu.business;

import com.gcu.data.ProductDataService;
import com.gcu.entity.ProductEntity;
import com.gcu.model.ProductModel;
import com.gcu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductBusinessService {

    @Autowired
    private ProductDataService service;

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getAllProducts(){
        //Get products(entities) from database
        List<ProductEntity> productEntity = service.findAll();
        //Create list to hold products
        List<ProductModel> productDomain = new ArrayList<ProductModel>();
        //Add from productEntity list to productDomain list
        for(ProductEntity entity : productEntity){
            productDomain.add(new ProductModel(entity.getId(), entity.getName(), entity.getPrice(), entity.getInstock()));
        }
        //return list
        return productDomain;
    }

    public boolean addProduct(ProductModel productModel){
        //Create product(entity) from model
        ProductEntity entity = new ProductEntity(
                productModel.getId(),
                productModel.getName(),
                productModel.getPrice(),
                productModel.getInstock());

        return service.create(entity);
    }

    public ProductModel getProductById(int id){
        //Get entity from database by ID
        ProductEntity entity = service.findById(id);
        //Return entity
        return new ProductModel(entity.getId(), entity.getName(), entity.getPrice(), entity.getInstock());
    }

    public boolean deleteProduct(ProductModel product){
        //Get entity from database by ID
        ProductEntity entity = new ProductEntity(product.getId(), product.getName(), product.getPrice(), product.getInstock());
        //Return entity
        return service.delete(entity);
    }

    public boolean updateProduct(ProductModel productModel){
        ProductEntity entity = new ProductEntity(productModel.getId(), productModel.getName(), productModel.getPrice(), productModel.getInstock());
        return service.update(entity);
    }
}
