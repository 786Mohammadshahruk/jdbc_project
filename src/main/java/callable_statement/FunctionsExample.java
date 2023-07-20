package callable_statement;

import com.istumbh.jdbc.Common;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class FunctionsExample {

    public static void main(String[] args) {

        Connection connection = Common.loadAndCreateConnection();

        //String QUERY = "select sumdd(?,?)";

        String QUERY = "{?= call sumdd(?,?)}";
        try {
            CallableStatement callableStatement = connection.prepareCall(QUERY);
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.setInt("n1",10);
            callableStatement.setInt("n2", 20);
            callableStatement.execute();
            System.out.println(callableStatement.getInt(1));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
