package prepared_stmt;

import com.istumbh.jdbc.Common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class FetchBlobExample {

    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = Common.loadAndCreateConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from image_table");
        ResultSet resultSet = preparedStatement.executeQuery();

        int fileNumber = 1;
        while (resultSet.next()) {
            // Fetching Blob Object
            Blob blob = resultSet.getBlob(2);
            //Converting to Byte Array
            byte[] bytes = blob.getBytes(1, (int) blob.length());

            //Creating new File using FileOutputStream
            String fileName = "E:\\img" + fileNumber + ".jpg";
            fileNumber++;
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            //writing byte array to the file which we created using FileOutputStream
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        }
        System.out.println("Done");
        connection.close();


    }
}
