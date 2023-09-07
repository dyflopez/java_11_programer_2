package service;

import Controller.ProductController;
import dtos.ProductDTO;
import model.repository.DatabaseRepository;
import utils.Commons;

import java.util.regex.Pattern;

public class DataBaseService {

    DatabaseRepository databaseRepository = new DatabaseRepository();

    ProductService productService = new ProductService();

    public void executeMigration (){
        databaseRepository.orquestarMigraciones();
    }

    public void executeBackUp (String nameFile){
        Pattern pattern = Pattern.compile(",");

        var lines = Commons.fileReadBackup(nameFile);
        lines
                .stream()
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
                .forEach(s-> productService.create(s));

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
}
