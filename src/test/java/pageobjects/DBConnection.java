package pageobjects;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {
	
	// non-static global private Connection object
    private Connection dbConn = null;

    // non-static public method to get dbConn connection object
    public Connection getConnection() {
        // this condition will check if the Connection is not already open then open it.
        if(null == dbConn) {
            //Set up a connection to the database
            String dbURL = "jdbc:mysql://localhost:3306/medicare"; //put host, port and database here
            Properties connectionProbs = new Properties();
            connectionProbs.put("user", "root"); //insert USER here
            connectionProbs.put("password", "Minions@123"); //insert PASSWORD here

            try{
                dbConn = DriverManager.getConnection(dbURL, connectionProbs);

                PreparedStatement useStmt;
                try{
                    useStmt = dbConn.prepareStatement("USE medicare"); //insert DATABASE here
                    useStmt.executeUpdate();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                //Do some SQL operations
                //Call class B to do some SQL operations using the same connection

            }
            catch(SQLException e){
                System.err.println("There was a problem connecting to the database");
                e.printStackTrace();
            }
            finally{
                if(dbConn != null)
                    try{dbConn.close();}catch(SQLException e){e.printStackTrace();}
            }
        }
        return dbConn;
    }
	
	
	
}

