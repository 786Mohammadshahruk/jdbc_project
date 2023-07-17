package prepared_stmt;

import com.istumbh.jdbc.Common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertPreparedExample {


    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = Common.loadAndCreateConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into persons values(?,?,?,?,?)");
            System.out.println("Enter the Id ");
            preparedStatement.setInt(1, scanner.nextInt());
            preparedStatement.setString(2, "Kumar");
            preparedStatement.setString(3, "Ajay");
            preparedStatement.setString(4, "HYD");
            preparedStatement.setString(5, "HYD");
            int value = preparedStatement.executeUpdate();
            System.out.println(value + "Record Created");
        } catch (SQLException sqlException) {
            System.out.println("Error : " + sqlException.getMessage());
        } finally {
            connection.close();
        }


    }
}
