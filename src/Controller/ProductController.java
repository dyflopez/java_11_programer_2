package Controller;

import dtos.ProductDTO;
import model.ProductEntity;
import service.ProductService;

import java.util.List;

public class ProductController {

    ProductService productService = new ProductService();

    //POST
    public void create(ProductDTO productDTO){
        try {
            System.out.println("ingresa a crear el producto");
            productService.create(productDTO);
            System.out.println("Producto creado correctamente");
        }catch (Exception e){
            System.out.println("Error en ProductController.create "+e.getMessage());
        }
    }
    //GET
    public List<ProductEntity> find(){
        try {
            System.out.println("buscando productos");
            return   productService.getProduct();

        }catch (Exception e){
            System.out.println("Error en ProductController.create "+e.getMessage());
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
