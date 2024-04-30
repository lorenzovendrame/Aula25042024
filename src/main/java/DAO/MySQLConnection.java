
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 1072221113
 */

public class MySQLConnection {
    private static MySQLConnection instance = null;
    private static Connection connection = null;

    public MySQLConnection() throws SQLException{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc","root","Unisul@1520");
    }

    public static synchronized MySQLConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new MySQLConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}