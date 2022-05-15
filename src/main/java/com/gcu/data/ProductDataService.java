package com.gcu.data;

import com.gcu.entity.ProductEntity;
import com.gcu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductDataService implements DataAccessInterface<ProductEntity>{

    @Autowired
    private ProductRepository productRepository;

    public ProductDataService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> findAll() {
        List<ProductEntity> product = new ArrayList<ProductEntity>();
        try{
            //Get all entity orders
            Iterable<ProductEntity> productEntityIterable = productRepository.findAll();
            //Convert to a list and return that list
            productEntityIterable.forEach(product::add);
        }catch (Exception e){
            e.printStackTrace();
        }
        //Return list named "product"
        return product;
    }

    @Override
    public ProductEntity findById(int id) {

        //Optional object to hold entity returned from database
        Optional<ProductEntity> product = productRepository.findById((long) id);

        return product.get();
    }

    /**
     * CRUD: Create an entity
     * @return boolean if created or not
     */
    @Override
    public boolean create(ProductEntity productEntity) {

        try{
            this.productRepository.save(productEntity);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(ProductEntity product) {

        try{
            productRepository.save(product);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(ProductEntity product) {

        try{
            productRepository.delete(product);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
