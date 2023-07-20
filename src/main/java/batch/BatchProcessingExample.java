package batch;

import com.istumbh.jdbc.Common;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingExample {

    public static void main(String[] args) {
        Connection connection = Common.loadAndCreateConnection();

        try {

            Statement statement = connection.createStatement();

            String query1 = "INSERT INTO Persons (PersonID, LastName, FirstName, Address, City) VALUES ('11', 'Kumar', 'Logesh', 'Kolkata', 'Kolkata')";
            statement.addBatch(query1);
            //statement.executeUpdate(query1);

            String query2 = "INSERT INTO Persons (PersonID, LastName, FirstName, Address, City) VALUES ('12', 'Sharma', 'Rohit', 'Mumbai', 'Navi Mumbai')";
            statement.addBatch(query2);
            //statement.executeUpdate(query2);
            int[] arr = statement.executeBatch();

            for (int value : arr) {
                System.out.println(value + " Record Created !!!");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
