package Interfaces;


import config.ConnectionDB;
import model.migrations.AdminMigration;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        boolean flagMigration = false; // mejorar esta parte codigo
        AdminMigration adminMigration = new AdminMigration();
        ConnectionDB connectionDB = new ConnectionDB();

        var connection = connectionDB.doConnectionDb();

        if(flagMigration){
            adminMigration.orquestarMigraciones(connection);
        }

        System.out.println("Insetar en la base de datos");

        Scanner sc = new Scanner(System.in);
        String name;
        String category;
        int stock;
        int lot;
        double price;

        System.out.println("Ingrese el name del product");
        name= sc.next();
        System.out.println("Ingrese la category");
        category= sc.next();
        System.out.println("Ingrese el stock");
        stock= sc.nextInt();
        System.out.println("Ingrese el lot");
        lot= sc.nextInt();
        System.out.println("Ingrese el price");
        price= sc.nextDouble();

        //metod para insertar en la db - metodo espesifico  - DAO ( DTO) -
        // Forma 1
        /*try{
            Statement statement = connection.createStatement();
            String querySql =  "insert into product (name,category,stock,lot,price) " +
                    "values ('"+name+"','"+category+"',"+stock+","+lot+","+price+");";
            statement.executeUpdate(querySql);
            System.out.println("producto creado ");
        }catch (Exception e){
            System.err.println("Error al insertar un producto" + e.getMessage());
        }*/
        // Forma 2
        try{

            String querySql =  "INSERT INTO product (name,category,stock,lot,price) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(querySql);

            preparedStatement.setString(1,name);
            preparedStatement.setString(2,category);
            preparedStatement.setInt(3,stock);
            preparedStatement.setInt(4,lot);
            preparedStatement.setDouble(5,price);

            preparedStatement.executeUpdate();

            System.out.println("producto creado ");

        }catch (Exception e){
            System.err.println("Error al insertar un producto" + e.getMessage());
        }
    }


}
