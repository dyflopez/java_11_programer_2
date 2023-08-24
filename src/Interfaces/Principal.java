package Interfaces;


import Controller.ProductController;
import config.ConnectionDB;
import model.migrations.AdminMigration;
import model.repository.ProductRepository;


public class Principal {
    public static void main(String[] args) {
        boolean flagMigration = false; // mejorar esta parte codigo
        AdminMigration adminMigration = new AdminMigration();
        ConnectionDB connectionDB = new ConnectionDB();

        //Repository Producto

        ProductRepository productRepository = new ProductRepository();

        var connection = connectionDB.doConnectionDb();

        if(flagMigration){
            adminMigration.orquestarMigraciones(connection);
        }
        //MENU llamado al controller
        ProductController productController = new ProductController();
        //Usuario que ingrese la infomracion para crear el producto
       /*  ProductDTO productDTO = new ProductDTO();

        productDTO.setCategory("Bebida");
        productDTO.setLot(10);
        productDTO.setName("Cocacola");
        productDTO.setPrice(2000);
        productDTO.setStock(80);

        productController.create(productDTO);*/


        var listaProductos = productController.find();

        listaProductos.forEach(System.out::println);



    }


}
