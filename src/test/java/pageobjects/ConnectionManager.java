package pageobjects;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

    private static String url = "jdbc:mysql://localhost:3306/medicare";
    private static String username = "root";
    private static String password = "Minions@123";
    private static Connection con;

    public static Connection getConnection() throws Exception {
      con = DriverManager.getConnection(url, username, password);
        return con;
    }


}