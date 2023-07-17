package prepared_stmt;

import com.istumbh.jdbc.Common;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class DataBaseMetaData {

    public static void main(String[] args) throws SQLException {

        Connection connection = Common.loadAndCreateConnection();
        DatabaseMetaData databaseMetaData =  connection.getMetaData();

        System.out.println(" Driver Name : "+ databaseMetaData.getDriverName());
        System.out.println(" Driver Version : "+ databaseMetaData.getDriverVersion());
        System.out.println(" User Name : "+ databaseMetaData.getUserName());
        System.out.println(" Product Name : "+ databaseMetaData.getDatabaseProductName());
        System.out.println(" Product Version : "+ databaseMetaData.getDatabaseProductVersion());

    }
}
