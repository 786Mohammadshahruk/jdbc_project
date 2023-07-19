package prepared_stmt;

import com.istumbh.jdbc.Common;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;

public class FetchStoredFile {

    public static void main(String[] args) {


        Connection connection = Common.loadAndCreateConnection();
        String QUERY = "Select * from file_table";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Clob clob = resultSet.getClob(2);
                Reader reader = clob.getCharacterStream();
                String file = "E:\\retrieve_file.txt";
                FileWriter fileWriter = new FileWriter(file);

                int i;
                while ((i = reader.read()) != -1) {
                    fileWriter.write((char) i);
                }
                System.out.println("Work Done");
                fileWriter.close();
                connection.close();

            }
        } catch (SQLException sqlException) {

        } catch (IOException e) {
            System.out.println();
        }


    }
}
