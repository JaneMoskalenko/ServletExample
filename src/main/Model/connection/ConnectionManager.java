package Model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by admin on 01.07.2017.
 */
public class ConnectionManager {


    public static Connection getConnection()  {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5433/postgres",
                    "postgres", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  connection;

    }
}
