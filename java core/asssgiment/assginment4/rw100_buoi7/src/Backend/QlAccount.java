package Backend;

import Util.JBDcutils;
import entity.Account;
import entity.DePartment;
import entity.Position;
import enums.Enums;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QlAccount {
    public static List<Account> showAccount() throws ClassNotFoundException {
        List<Account> accounts = new ArrayList<>();
        try{
            Connection connection = JBDcutils.getConnection();
            String sql ="select acc.*,de.department_name,po.position_name \n" +
                    "from  `account` as acc\n" +
                    "left join department as de on de.department_id=acc.department_id\n" +
                    "left join position as po on po.position_id=acc.position_id;  ";
            Statement statement =connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next())
            {
                int id= rs.getInt("account_id");
                String nameEmail=rs.getString("email");
                String username1 =rs.getString("username");
                String fullName =rs.getString("full_name");
                String departmentname= rs.getString("department_name");
                String posiotionname=rs.getString("position_name");
                DePartment dep = new DePartment(
                        rs.getInt("department_id"),departmentname
                );
                Position position= new Position(
                        rs.getInt("position_id"),
                      Enums.Positionanme.valueOf(posiotionname)
                );
                Account ac =new Account(id,fullName,username1,nameEmail,position,dep);
                accounts.add(ac);
            }
            for(Account  account:accounts)
            {
                System.out.println(account);
            }
        }
        catch  (Exception e) {// crtl   alt   L
          e.printStackTrace();
        }
        return accounts;
    }
    public static List<Account> findByfullname(String SreachFullName) throws ClassNotFoundException {

        List<Account> accounts = new ArrayList<>();
        try{
           Connection connection =JBDcutils.getConnection();
            String sql ="select *from `account`\n" +
                    "where full_name like ? ; ";
            PreparedStatement statement =connection.prepareStatement(sql);
            statement.setString(1,SreachFullName);
            ResultSet rs = statement.executeQuery();

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
        catch  (Exception e) {
           e.printStackTrace();
        }
        return accounts;
    }
    public static List<Account> findByfullnameAndUseName(String SearchFullName,String searchUesName) throws ClassNotFoundException {
        List<Account> accounts = new ArrayList<>();

        try{
           Connection connection =JBDcutils.getConnection();
            String sql ="select *from `account`\n" +
                    "where full_name like ?  and username = ?; ";
            PreparedStatement statement =connection.prepareStatement(sql);
            statement.setString(1,"%"+ SearchFullName +"%");
            statement.setString(2,"%" + SearchFullName +"%");
            ResultSet rs = statement.executeQuery();

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
        catch  (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }
    public static boolean createAccount(String Emailname,String username, String fullname
                                   , int idDE,int idPO)
    {
        try{
            Connection connection = JBDcutils.getConnection();
            String sql="insert into `account`(email,username,full_name,department_id,position_id)\n" +
                    "values (?, ?,? ,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,Emailname);
            statement.setString(2,username);
            statement.setString(3,fullname);
            statement.setInt(4,idDE);
            statement.setInt(5,idPO);
            int c=statement.executeUpdate();
            JBDcutils.closeConnection(connection,statement,null);
            return c>0;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean deleteAcount(String deletename)
    {
        try{
            Connection connection = JBDcutils.getConnection();
            String sql="delete from account where username = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,deletename);
            int c=statement.executeUpdate();
            JBDcutils.closeConnection(connection,statement,null);
            return c>0;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean updateAccount(int id ,String deletename)
    {
        try{
            Connection connection = JBDcutils.getConnection();
            String sql="update account set  username =? where account_id =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,deletename);
            statement.setInt(2,id);
            int c=statement.executeUpdate();
            JBDcutils.closeConnection(connection,statement,null);
            return c>0;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
