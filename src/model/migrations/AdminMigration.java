package model.migrations;

import java.sql.Connection;
import java.sql.Statement;

public class AdminMigration {
    public void orquestarMigraciones(Connection connection){
        try {
            System.out.println("Ejecutando migraciones");
            CreateTableExample createTableExample = new CreateTableExample();
            Statement statement = connection.createStatement();
            createTableExample.up(statement);
            connection.close();
        }catch (Exception e){
            System.err.println("falla Ejecucion orquestarMigraciones" + e.getMessage());
        }
    }
}
