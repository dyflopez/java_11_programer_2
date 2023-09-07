package model.repository;

import config.ConnectionDB;
import model.migrations.CreateTableProduct;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseRepository {
    public void orquestarMigraciones(){

        try {
            ConnectionDB connectionDB = new ConnectionDB();
            var connection = connectionDB.doConnectionDb();
            System.out.println("Ejecutando migraciones");
            CreateTableProduct createTableExample = new CreateTableProduct();
            Statement statement = connection.createStatement();
            createTableExample.up(statement);
            connection.close();
        }catch (Exception e){
            System.err.println("falla Ejecucion orquestarMigraciones" + e.getMessage());
        }
    }
}
