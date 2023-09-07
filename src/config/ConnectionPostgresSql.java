package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPostgresSql {

    private String jdbcUrl="jdbc:postgresql://localhost:5432/postgres";
    private String userDB="postgres";
    private String password="postgres";

    public Connection doConnectionDb(){
        try {
            Connection connection= DriverManager.getConnection(jdbcUrl,userDB,password);
            System.out.println("conexion exitosa a  Postgres");
            return connection;
        }catch (Exception e){
            System.out.println(e);
            return  null;
        }
    }
}
