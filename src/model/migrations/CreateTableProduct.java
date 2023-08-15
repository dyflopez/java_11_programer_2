package model.migrations;

import java.sql.Statement;

public class CreateTableProduct {
    public void up (Statement statement){
        try{
            System.out.println("Ejecutando creacion tabla product ");
            String createTableExample="CREATE TABLE product (\n" +
                    "    id_product BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    name VARCHAR(50) NOT NULL,\n" +
                    "    category VARCHAR(50),\n" +
                    "    stock  numeric (20),\n" +
                    "    lot  numeric(20),\n" +
                    "    price double(25,5) not null\n" +
                    ");";
            statement.executeUpdate(createTableExample);
            System.out.println("Creacion correcta de la tabla ejemplo ");
        }catch (Exception e){
            System.err.println("Error al tabla CreateTableProduct" + e.getMessage());
        }
    }
    public void down(Statement statement){
        try{
            String createTableExample="drop  table ejemplo;";
            statement.executeUpdate(createTableExample);
        }catch (Exception e){
            System.err.println("Error al eliminar la tabla CreateTableProduct" + e.getMessage());
        }
    }
}
