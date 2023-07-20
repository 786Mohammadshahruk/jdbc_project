package transactions;

import com.istumbh.jdbc.Common;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class WithoutTransaction {

    public static void main(String[] args) throws SQLException {
        Connection connection = Common.loadAndCreateConnection();


        try {
            Statement statement = connection.createStatement();
            String Q1 = "INSERT INTO Persons (PersonID, LastName, FirstName, Address, City) VALUES ('20', 'Kumar', 'Logesh', 'Kolkata', 'Kolkata')";
            int value = statement.executeUpdate(Q1);
            System.out.println(value + " Record Created !!!!");
            String Q2 = "INSERT (PersonID, LastName, FirstName, Address, City) VALUES ('21', 'Kumar', 'Logesh', 'Kolkata', 'Kolkata')";
            int value2 = statement.executeUpdate(Q2);
            connection.close();
            System.out.println(value2 + " Record Created !!!!");

            connection.close();
        } catch (SQLException e) {

            System.out.println("Error : " + e.getMessage());
        }
    }
}
