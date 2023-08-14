package model.migrations;

import java.sql.Statement;

public class CreateTableExample {
    public void up (Statement statement){
        try{
            System.out.println("Ejecutando creacion ejemplo ");
            String createTableExample="Create table ejemplo (id int primary key , nombre varchar(255));";
            statement.executeUpdate(createTableExample);
            System.out.println("Creacion correcta de la tabla ejemplo ");
        }catch (Exception e){
            System.err.println("Error al ejecutar CreateTableExample" + e.getMessage());
        }
    }
    public void down(Statement statement){
        try{
            String createTableExample="drop  table ejemplo;";
            statement.executeUpdate(createTableExample);
        }catch (Exception e){
            System.err.println("Error al eliminar la tabla CreateTableExample" + e.getMessage());
        }
    }
}
