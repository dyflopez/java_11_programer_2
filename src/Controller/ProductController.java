package Controller;

import dtos.ProductDTO;
import model.ProductEntity;
import service.ProductService;
import utils.Commons;

import java.util.Date;
import java.util.List;

public class ProductController {

    ProductService productService = new ProductService();

    //POST
    public void create(ProductDTO productDTO){
        try {
            Commons.writeFile(new Date() +" ingresa a crear el producto","log.txt");
            productService.create(productDTO);
            Commons.writeFile(new Date() +" Producto creado correctamente","log.txt");
        }catch (Exception e){
            Commons.writeFile(new Date() +" Error en ProductController.create " + e.getMessage(),"log.txt");
        }
    }
    //GET
    public List<ProductEntity> find(){
        try {
            Commons.writeFile(new Date() +" buscando productos","log.txt");
            return   productService.getProduct();

        }catch (Exception e){
            Commons.writeFile(new Date() +" Error en ProductController.create "+e.getMessage(),"log.txt");
            return  null;
        }
    }

    /**
     *
     *  POST
     *  GET
     *  DELETE
     *  PUT
     *  PATCH
     */
}
