package Interfaces;


import Controller.DatabaseController;
import Controller.ProductController;
import config.ConnectionPostgresSql;
import dtos.ProductDTO;
import model.ProductEntity;
import model.repository.DatabaseRepository;
import model.repository.ProductRepository;
import utils.Commons;

import java.util.regex.Pattern;


public class Principal {
    public static void main(String[] args) {
        boolean backup = false;
        ProductController productController = new ProductController();

        DatabaseController databaseController = new DatabaseController();

        //databaseController.executeMigration();

        ProductDTO productDTO = new ProductDTO();

       /* productDTO.setStock(200);
        productDTO.setPrice(2000);
        productDTO.setName("ropa");
        productDTO.setLot(1);
        productDTO.setCategory("camisa polo");
        productController.create(productDTO);*/

        if(backup){
            var lines = Commons.fileReadBackup("backupProduct.txt");
            lines
                    .stream()
                    .forEach(System.out::println);

            //split
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
                                            s[1],
                                            s[2],
                                            Integer.parseInt(s[3]),
                                            Integer.parseInt(s[4]),
                                            Double.parseDouble(s[5])
                    ))
                    .forEach(s-> productController.create(s));

         /* lines
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






         var listaProductos = productController.find();


       /*   listaProductos
                .stream()
                .forEach(producto -> System.out.println(producto.toString()));
*/
        var total =listaProductos
                .stream()
                .filter(s->s.getCategory().equalsIgnoreCase("bebida"))
                .count();

        var totalSuma= listaProductos
                .stream()
                .filter(s->s.getCategory().equalsIgnoreCase("bebida"))
                .mapToInt(p->p.getStock())
                .sum();


        System.out.println(totalSuma);


        ConnectionPostgresSql connectionPostgresSql = new ConnectionPostgresSql();

        connectionPostgresSql.doConnectionDb();



/*
        listaProductos
                .stream()
                .forEach(p-> Commons.writeFile("backupProduct.txt",p.saveBackup()));*/


    }


}
