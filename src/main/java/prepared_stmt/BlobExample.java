package prepared_stmt;

import com.istumbh.jdbc.Common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BlobExample {

    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = Common.loadAndCreateConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into image_table values(?,?)");

        preparedStatement.setString(1, "XYZ");

        FileInputStream fileInputStream = new FileInputStream("E:\\images.jpg");
        preparedStatement.setBinaryStream(2, fileInputStream, fileInputStream.available());
        preparedStatement.setBinaryStream(2, fileInputStream);

        int i = preparedStatement.executeUpdate();
        System.out.println(i + " Record Created");
        connection.close();

    }
}
