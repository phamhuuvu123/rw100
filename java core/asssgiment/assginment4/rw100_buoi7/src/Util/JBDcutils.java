package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JBDcutils {
    public static Connection getConnection()
    {
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "123456";// mk mysql
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection  = DriverManager.getConnection(url,username,password);
        return DriverManager.getConnection(url,username,password);
    }
    catch ( Exception e)
    {
        System.out.println(" Kết Nối Không Thành Công");
    }
    return null;
    }
    public static void closeConnection(Connection connection ,Statement statement,ResultSet rs)
    {
        try{
        if(connection!=null) {
            connection.close();
        }}

        catch(Exception e)
                    {
                        e.printStackTrace();
                    }
       try{
        if (statement!=null) {
            statement.close();
        }
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
       try{
        if(rs!=null)
        {
            rs.close();
          }
       }catch (Exception e)
       {
           e.printStackTrace();
       }

    }
}
