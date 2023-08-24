package service;

import dtos.ProductDTO;
import model.ProductEntity;
import model.repository.ProductRepository;

import java.util.List;

public class ProductService {

    ProductRepository productRepository = new ProductRepository();
    public void  create(ProductDTO productDTO){
        ProductEntity productEntity = new ProductEntity(productDTO);
        productRepository.createForm1(productEntity);
    }

    public List<ProductEntity> getProduct (){
        return productRepository.find();
    }

}
