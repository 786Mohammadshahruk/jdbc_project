package prepared_stmt;

import com.istumbh.jdbc.Common;

import java.sql.*;

public class PreparedStatementGetDetails {

    public static void main(String[] args) throws SQLException {
        Connection connection = Common.loadAndCreateConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from persons order by personId Desc");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) );
            System.out.println(resultSet.getString(2) );
            System.out.println(resultSet.getString(3) );
            System.out.println(resultSet.getString(4) );
            System.out.println(resultSet.getString(5) );
            System.out.println("======================================");
        }
        System.out.println("Fetching ResultSet MeteData");
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        System.out.println("Total Columns : " + resultSetMetaData.getColumnCount());
        System.out.println("Column Name : " + resultSetMetaData.getColumnName(1));
        System.out.println("Column Type : " + resultSetMetaData.getColumnTypeName(1));

        connection.close();
    }
}
