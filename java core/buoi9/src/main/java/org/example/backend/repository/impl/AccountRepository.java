package org.example.backend.repository.impl;

import org.example.backend.repository.IAccountRepository;
import org.example.entity.Account;
import org.example.entity.DePartment;
import org.example.entity.Position;
import org.example.enums.Enums;
import org.example.utlis.JBDcutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements IAccountRepository {
    @Override
    public List<Account> findAll() {
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

    @Override
    public boolean createAccount(String Emailname, String username, String fullname, int idDE, int idPO) {
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

    @Override
    public boolean deleteAccount(int id) {
        try{
            Connection connection = JBDcutils.getConnection();
            String sql="delete from account where account_id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int c=statement.executeUpdate();
            JBDcutils.closeConnection(connection,statement,null);
            return c>0;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateAccount(int id, String name) {
        try{
            Connection connection = JBDcutils.getConnection();
            String sql="update account set  username =? where account_id =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,name );
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

    @Override
    public List<Account> findByID(int id) {
        List<Account> accounts = new ArrayList<>();
        try{
            Connection connection =JBDcutils.getConnection();
            String sql ="select *from `account`\n" +
                    "where account_id like ? ; ";
            PreparedStatement statement =connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                int id1= rs.getInt("account_id");
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

        }
        catch  (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

}
