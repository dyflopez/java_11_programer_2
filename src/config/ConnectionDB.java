package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    private String jdbcUrl="jdbc:mysql://localhost:3306/falabela";
    private String userDB="root";
    private String password="eldany1234";
    public Connection doConnectionDb(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(jdbcUrl,userDB,password);
            return connection;
        }catch (Exception e){
            System.out.println(e);
            return  null;
        }
    }
}
