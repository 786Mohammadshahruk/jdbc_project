package callable_statement;

import com.istumbh.jdbc.Common;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoredProcedureExample {

    public static void main(String[] args) {
        Connection connection = Common.loadAndCreateConnection();
        String QUERY = "{CALL GetAllPersons()}";
        try {
            CallableStatement callableStatement = connection.prepareCall(QUERY);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("PersonId : " + resultSet.getInt("PersonID"));
                System.out.println("LastName : " + resultSet.getString("LastName"));
                System.out.println("FirstName : " + resultSet.getString("FirstName"));
                System.out.println("Address : " + resultSet.getString("Address"));
                System.out.println("City : " + resultSet.getString("City"));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
