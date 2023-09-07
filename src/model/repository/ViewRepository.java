package model.repository;

import config.ConnectionPostgresSql;
import dtos.ViewClientesCargosDTO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ViewRepository {

    public List<ViewClientesCargosDTO> findViewClient(){
        List<ViewClientesCargosDTO> viewClientesCargosDTOList = new ArrayList<>();
        ConnectionPostgresSql connectionPostgresSql = new ConnectionPostgresSql();
        var connection = connectionPostgresSql.doConnectionDb();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM vista_cliente_x_empleado";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                ViewClientesCargosDTO viewClientesCargosDTO = new ViewClientesCargosDTO();
                viewClientesCargosDTO.setNombre(resultSet.getString("nombre"));
                viewClientesCargosDTO.setCargo(resultSet.getString("cargo"));
                viewClientesCargosDTO.setSalario(resultSet.getDouble("salario"));
                viewClientesCargosDTOList.add(viewClientesCargosDTO);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
       return viewClientesCargosDTOList;
    }
}
