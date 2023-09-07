import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class Postgres {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            // Realiza operaciones con la conexión aquí
            System.out.println("conectado");
            String sql = "CALL insertar_cliente(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "Nohora");
            preparedStatement.setString(2, "Muños");
            preparedStatement.setString(3, "dyf1");
            preparedStatement.setObject(4, UUID.fromString("72b30d60-697a-451d-a67e-de5dfab8970a"));

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
