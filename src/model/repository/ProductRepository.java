package model.repository;

import config.ConnectionDB;
import model.ProductEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductRepository {

    public void createForm1(ProductEntity productEntity){
        try{
            ConnectionDB connectionDB = new ConnectionDB();
            var connection = connectionDB.doConnectionDb();

            Statement statement = connection.createStatement();
            String querySql =  "insert into "+productEntity.getTableName()+
                    " (name,category,stock,lot,price) " +
                    "values ('"+productEntity.getName()+"','"
                    +productEntity.getCategory()+"',"
                    +productEntity.getStock()+","
                    +productEntity.getLot()+","
                    +productEntity.getPrice()
                    +");";
            statement.executeUpdate(querySql);
            System.out.println("producto creado ");
            connection.close();
        }catch (Exception e){
            System.err.println("Error al insertar un producto" + e.getMessage());
        }
    }

    public void createForm2(ProductEntity productEntity){
        try{
            ConnectionDB connectionDB = new ConnectionDB();
            var connection = connectionDB.doConnectionDb();

            String querySql =  "INSERT INTO product (name,category,stock,lot,price) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(querySql);

            preparedStatement.setString(1,productEntity.getName());
            preparedStatement.setString(2,productEntity.getCategory());
            preparedStatement.setInt(3,productEntity.getStock());
            preparedStatement.setInt(4,productEntity.getLot());
            preparedStatement.setDouble(5,productEntity.getPrice());

            preparedStatement.executeUpdate();

            System.out.println("producto creado ");

        }catch (Exception e){
            System.err.println("Error al insertar un producto" + e.getMessage());
        }
    }

    public void update(ProductEntity productEntity){
        try{
            ConnectionDB connectionDB = new ConnectionDB();
            var connection = connectionDB.doConnectionDb();

            Statement statement = connection.createStatement();
            String querySql =  "insert into "+productEntity.getTableName()+" (name,category,stock,lot,price) " +
                    "values ('"
                    +productEntity.getName()+"','"
                    +productEntity.getCategory()+"',"
                    +productEntity.getStock()+","
                    +productEntity.getLot()+","
                    +productEntity.getPrice()
                    +");";
            statement.executeUpdate(querySql);
            System.out.println("producto creado ");
            connection.close();
        }catch (Exception e){
            System.err.println("Error al insertar un producto" + e.getMessage());
        }
    }

    public void update2(int id,
                        String name,
                            String category,
                            int stock,
                            int lot,
                            double price){
        ConnectionDB connectionDB = new ConnectionDB();
        var connection = connectionDB.doConnectionDb();

        try {
            String updateQuery =
                    "UPDATE product " ;
                          //  "Where id_product = ?";

            String setPameter="Set ";
            if(Objects.nonNull(name)){
                setPameter= "name = "+name+",";
            }
            if(Objects.nonNull(category)){
                setPameter= "category = "+category+" ,";
            }
            if(Objects.nonNull(stock)){
                setPameter= "stock = "+stock+" ,";
            }
            if(Objects.nonNull(lot)){
                setPameter= "lot = "+lot+" ,";
            }
            if(Objects.nonNull(price)){
                setPameter= "price = "+price+" ,";
            }
            updateQuery= updateQuery+setPameter+ "Where id_product = "+ id;
            Statement statement = connection.createStatement();
           int result =  statement.executeUpdate(updateQuery);

           System.out.println("La cantidad de registros afectados es = "+result);

        }catch (Exception e){
            System.err.println("Error al insertar un producto" + e.getMessage());
        }
    }

    public void delete(int id){
        try{
            ConnectionDB connectionDB = new ConnectionDB();
            var connection = connectionDB.doConnectionDb();
            String queryDelete = ("DELETE FROM product  WHERE  category = ?");

            PreparedStatement preparedStatement = connection.prepareStatement(queryDelete);
            preparedStatement.setString(1,"pet");
            var result = preparedStatement.executeUpdate();
            var valor =String.valueOf(result);
            if(result>0){
                // System.out.println("se borraron " + result +" en la base de datos");
                System.out.println(String.format("se borraron %i en la base de datos", valor));

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public  List<ProductEntity> find (){
        List<ProductEntity> productEntityList = new ArrayList<>();
        try {


            ConnectionDB connectionDB = new ConnectionDB();
            var connection = connectionDB.doConnectionDb();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM product";
            ResultSet resultSet = statement.executeQuery(sql);
           /* while (resultSet.next()){
                System.out.println(resultSet.getString("id_product"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("category"));
                System.out.println(resultSet.getString("stock"));
                System.out.println(resultSet.getString("lot"));
                System.out.println(resultSet.getString("price"));
            }*/
            var meta= resultSet.getMetaData();
            var numeroColumns = meta.getColumnCount();
            System.out.println("la cantidad de columnas numeroColumns");
            while (resultSet.next()){
                for (int i=1;i <numeroColumns;i++){
                    System.out.println(meta.getColumnName(i) + ":" + resultSet.getString(i));
                }
                ProductEntity product = new ProductEntity();
                product.setIdProduct(resultSet.getString("id_product"));
                product.setName(resultSet.getString("name"));
                product.setCategory(resultSet.getString("category"));
                product.setStock(resultSet.getInt("stock"));
                product.setLot(resultSet.getInt("lot"));
                product.setPrice(resultSet.getDouble("price"));
                productEntityList.add(product);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            return productEntityList;
        }
    }
}
