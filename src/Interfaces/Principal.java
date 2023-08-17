package Interfaces;


import config.ConnectionDB;
import model.migrations.AdminMigration;
import model.repository.ProductRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

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

        System.out.println("Insetar en la base de datos");

    }


}
