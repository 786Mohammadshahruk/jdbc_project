package prepared_stmt;

import com.istumbh.jdbc.Common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoreFile {

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        Connection connection = Common.loadAndCreateConnection();
        String QUERY = "insert into file_table values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, "SAMPLE1.txt");

        File file = new File("E:\\sample.txt");
        FileReader fileReader = new FileReader(file);
        preparedStatement.setCharacterStream(2, fileReader, (int) file.length());

        int i = preparedStatement.executeUpdate();

        System.out.println(i + " Record Created !!");
        connection.close();
    }
}
