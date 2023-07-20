package transactions;

import com.istumbh.jdbc.Common;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class WithTransaction {

    public static void main(String[] args) throws SQLException {
        Connection connection = Common.loadAndCreateConnection();

        try {
            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();

            String Q1 = "INSERT INTO Persons (PersonID, LastName, FirstName, Address, City) VALUES ('22', 'Kumar', 'Logesh', 'Kolkata', 'Kolkata')";
            int value = statement.executeUpdate(Q1);
            System.out.println(value + " Record Created !!!!");

            String Q2 = "INSERT (PersonID, LastName, FirstName, Address, City) VALUES ('23', 'Kumar', 'Logesh', 'Kolkata', 'Kolkata')";
            int value2 = statement.executeUpdate(Q2);
            System.out.println(value2 + " Record Created !!!!");

            connection.commit();

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }finally {
            connection.close();
        }

    }
}
