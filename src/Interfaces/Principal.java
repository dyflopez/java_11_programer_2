package Interfaces;


import Controller.ProductController;
import config.ConnectionDB;
import dtos.ProductDTO;
import model.ProductEntity;
import model.migrations.AdminMigration;
import model.repository.ProductRepository;
import utils.Commons;

import javax.swing.text.Utilities;
import java.util.regex.Pattern;


public class Principal {
    public static void main(String[] args) {
        boolean flagMigration = false; // mejorar esta parte codigo
        boolean backup = true; // mejorar esta parte codigo
        AdminMigration adminMigration = new AdminMigration();
        ConnectionDB connectionDB = new ConnectionDB();
        ProductController productController = new ProductController();

        ProductRepository productRepository = new ProductRepository();

        var connection = connectionDB.doConnectionDb();

        if(flagMigration){
            adminMigration.orquestarMigraciones(connection);
        }
        if(backup){

            var lines = Commons.fileReadBackup("backupProduct.txt");
            lines
                    .stream()
                    .forEach(System.out::println);
            //Split

            Pattern pattern = Pattern.compile(",");

            lines
                    .stream()
                   // .flatMap( s -> pattern.splitAsStream(s) )
                    .forEach(System.out::println);

            /*for (String line :lines) {
                var vectorLineas =line.split(",");
                var patterLenas =pattern.split(line);

                ProductDTO productDTO = new ProductDTO( Integer.parseInt(patterLenas[0]),
                                                       patterLenas[1],
                                                       patterLenas[2],
                                                       Integer.parseInt(patterLenas[3]),
                                                       Integer.parseInt(patterLenas[4]),
                                                       Double.parseDouble(patterLenas[5])
                                                       );

                productController.create(productDTO);
            }*/

            lines
                    .stream()
                    .map(s->pattern.split(s))
                    .map(s-> new ProductDTO(
                                            Integer.parseInt(s[0]),
                                            s[1],
                                            s[2],
                                            Integer.parseInt(s[3]),
                                            Integer.parseInt(s[4]),
                                            Double.parseDouble(s[5])
                    ))
                    .forEach(s-> productController.create(s));

         /*   lines
                    .stream()
                    .map(linea->{
                        String [] itmes = pattern.split(linea);
                        return new ProductDTO(
                                Integer.parseInt(itmes[0]),
                                itmes[1],
                                itmes[2],
                                Integer.parseInt(itmes[3]),
                                Integer.parseInt(itmes[4]),
                                Double.parseDouble(itmes[5]));
                    })
                    .forEach(s-> productController.create(s));*/

          /*  lines
                    .stream()
                    .forEach(linea->{
                        String [] itmes = pattern.split(linea);
                         ProductDTO productDTO = new ProductDTO(
                                Integer.parseInt(itmes[0]),
                                itmes[1],
                                itmes[2],
                                Integer.parseInt(itmes[3]),
                                Integer.parseInt(itmes[4]),
                                Double.parseDouble(itmes[5]));
                        productController.create(productDTO);
                    });


            ProductDTO product = new ProductDTO();*/

        }




       /*  var listaProductos = productController.find();


        listaProductos
                .stream()
                .forEach(p-> Commons.writeFile("backupProduct.txt",p.saveBackup()));*/


    }


}
