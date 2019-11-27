package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class My_SQL_Connection {
    private static final String host= "localhost:3306/";
    private static final String databaseName = "coffee";
    private static final String user = "root";
    private static final String password = "mysqlvophihai1994";
    private static final String urlConnection = "jdbc:mysql://" + host + databaseName;
    public static Connection getSqlConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(urlConnection, user, password);
    }

}
