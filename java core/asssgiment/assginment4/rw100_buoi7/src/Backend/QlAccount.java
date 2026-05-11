package Backend;

import entity.Account;
import entity.DePartment;
import entity.Position;
import enums.Enums;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QlAccount {
    public static void showAccount() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "123456";// mk mysql

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection  = DriverManager.getConnection(url,username,password);
            if(connection!=null)
            {
                System.out.println("kết nối DB thành công");
            }
            String sql ="select *from Account  ";
            Statement statement =connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            List<Account> accounts = new ArrayList<>();
            while (rs.next())
            {
                int id= rs.getInt("account_id");
                String nameEmail=rs.getString("email");
                String username1 =rs.getString("username");
                String fullName =rs.getString("full_name");
                DePartment dep = new DePartment(
                        rs.getInt("department_id"),
                        null
                );
                Position position= new Position(
                        rs.getInt("position_id"),
                    null
                );
                Account ac =new Account(id,fullName,username1,nameEmail,position,dep);
                accounts.add(ac);
            }
            for(Account  account:accounts)
            {
                System.out.println(account);
            }
        }
        catch  (ClassNotFoundException e) {// crtl   alt   L
            throw new RuntimeException(e);
        }
    }
    public static void findByfullname(String SreachFullName) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "123456";// mk mysql

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection  = DriverManager.getConnection(url,username,password);
            if(connection!=null)
            {
                System.out.println("kết nối DB thành công");
            }
            String sql ="select *from `account`\n" +
                    "where full_name like ? ; ";
            PreparedStatement statement =connection.prepareStatement(sql);
            statement.setString(1,SreachFullName);
            ResultSet rs = statement.executeQuery();
            List<Account> accounts = new ArrayList<>();
            while (rs.next())
            {
                int id= rs.getInt("account_id");
                String nameEmail=rs.getString("email");
                String username1 =rs.getString("username");
                String fullName =rs.getString("full_name");
                DePartment dep = new DePartment(
                        rs.getInt("department_id"),
                        null
                );
                Position position= new Position(
                        rs.getInt("position_id"),
                        null
                );
                Account ac =new Account(id,fullName,username1,nameEmail,position,dep);
                accounts.add(ac);
            }
            for(Account  account:accounts)
            {
                System.out.println(account);
            }
        }
        catch  (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void findByfullnameAndUseName(String SearchFullName,String searchUesName) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "123456";// mk mysql

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection  = DriverManager.getConnection(url,username,password);
            if(connection!=null)
            {
                System.out.println("kết nối DB thành công");
            }
            String sql ="select *from `account`\n" +
                    "where full_name like ?  and username = ?; ";
            PreparedStatement statement =connection.prepareStatement(sql);
            statement.setString(1,SearchFullName);
            statement.setString(2,searchUesName);
            ResultSet rs = statement.executeQuery();
            List<Account> accounts = new ArrayList<>();
            while (rs.next())
            {
                int id= rs.getInt("account_id");
                String nameEmail=rs.getString("email");
                String username1 =rs.getString("username");
                String fullName =rs.getString("full_name");
                DePartment dep = new DePartment(
                        rs.getInt("department_id"),
                        null
                );
                Position position= new Position(
                        rs.getInt("position_id"),
                        null
                );
                Account ac =new Account(id,fullName,username1,nameEmail,position,dep);
                accounts.add(ac);
            }
            for(Account  account:accounts)
            {
                System.out.println(account);
            }
        }
        catch  (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
