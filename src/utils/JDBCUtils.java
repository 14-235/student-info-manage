package utils;

import java.io.File;
import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class JDBCUtils {
    private static String url = "jdbc:mysql://127.0.0.1:3306/studentinfomanage?useSSL=false";
    private static String user= "root";
    private static String password ="root";
    private static String driver = "com.mysql.jdbc.Driver";
    static{
        try {
            Class.forName(driver);
        } catch (Exception e) {
            
            e.getMessage();
        }
        
    }
    
    public static Connection getConn() throws Exception{
        
        Connection connection = DriverManager.getConnection(url, user, password);
        
        return connection;
    }
    public static void close(ResultSet resultSet, PreparedStatement preparedStatement, 
            Connection connection){
        
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if(preparedStatement != null ){
                preparedStatement.close();
            }
            if(connection != null ){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}