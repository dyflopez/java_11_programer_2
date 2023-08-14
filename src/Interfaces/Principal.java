package Interfaces;


import config.ConnectionDB;
import model.migrations.AdminMigration;
public class Principal {
    public static void main(String[] args) {
        boolean flagMigration = true;
        AdminMigration adminMigration = new AdminMigration();
        ConnectionDB connectionDB = new ConnectionDB();

        var connection = connectionDB.doConnectionDb();

        if(flagMigration){
            adminMigration.orquestarMigraciones(connection);
        }
    }
}
