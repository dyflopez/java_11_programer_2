package Interfaces;


import config.ConnectionDB;
import model.ProductEntity;
import model.migrations.AdminMigration;
import model.repository.ProductRepository;

import java.util.Optional;
import java.util.stream.Stream;

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


        var listProdiuct = productRepository.find();
        System.out.println("+++++");
        for (ProductEntity pruct : listProdiuct) {
            System.out.println(pruct.getName());
            System.out.println(pruct.getCategory());
            System.out.println(pruct.getPrice());
        }
        System.out.println("strams");
        listProdiuct
                .stream()
                .forEach(p-> System.out.println(p.toString()));



        listProdiuct
                .stream()
                .map(x->x.toString())
                .forEach(p-> System.out.println(p));








    }


}
