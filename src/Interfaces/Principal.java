package Interfaces;


import Controller.ProductController;
import config.ConnectionDB;
import model.migrations.AdminMigration;
import model.repository.ProductRepository;
import utils.Commons;


public class Principal {
    public static void main(String[] args) {
        boolean flagMigration = false; // mejorar esta parte codigo
        AdminMigration adminMigration = new AdminMigration();
        ConnectionDB connectionDB = new ConnectionDB();

        ProductRepository productRepository = new ProductRepository();

        var connection = connectionDB.doConnectionDb();

        if(flagMigration){
            adminMigration.orquestarMigraciones(connection);
        }

        ProductController productController = new ProductController();

        var listaProductos = productController.find();


        // Necesito que me listen todos los produtos que su stock sea mayor a 19
        /*var stock =listaProductos
                .stream()
                .filter(n->n.getCategory()
                        .toLowerCase()
                        .equals("bebida"))
                .mapToInt(n->n.getStock())
                .sum();*/

        listaProductos
                .stream()
                .forEach(
                        System.out::println
                );
        /*.forEach(
                        Commons.writeFile(
                                "productBackup.txt",
                                datos-> System.out.println(datos)
                        )
                );*/
        /*

        crear el backup
        listaProductos
                .stream()
                .forEach(p-> Commons.writeFile("log.txt",p.toString()));*/

    }


}
