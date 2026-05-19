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
import java.util.Objects;

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

    @Override
    public boolean check(String uesername, String fullname, String email, DePartment dePartment, Position position) {
        boolean check= false ;
        try{
            Connection connection =JBDcutils.getConnection();
            String sql ="select * from `account`\n" +
                    "where account_id ?";
            if(Objects.nonNull(fullname))
            {
                sql+= " and full_name =?";
            }
            if(Objects.nonNull(email))
            {
                sql+=" and email=?";
            }
            if(Objects.nonNull(dePartment))
            {
                sql+= "department_id= ?";
            }
            if(Objects.nonNull(position))
            {
                sql+="position_id= ?";
            }
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.setString(1,uesername);
            if(Objects.nonNull(fullname))
            {
                statement.setString(2,fullname);
            }
            if(Objects.nonNull(email))
            {
                statement.setString(3,fullname);
            }
            if (Objects.nonNull(dePartment))
            {
                statement.setInt(3,dePartment.getId());
            }
            if(Objects.nonNull(position))
            {
                statement.setInt(4,position.getId());
            }
            ResultSet rs = statement.executeQuery();
            if(rs.next()) check= true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean checkExitIdAndName(String name, Integer id) {
        boolean check = false;
        try{
            Connection connection=JBDcutils.getConnection();
            String sql= "select * from `account`\n" +
                    "where username ? ;";
            if(Objects.nonNull(id))
            {
                sql+=" and account_id!= ?";
            }
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.setString(1,name);
            if(Objects.nonNull(id))
            {
                statement.setInt(2,id);
            }
            ResultSet resultSet =statement.executeQuery();
            if(resultSet.next())
            {
                check =true;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean checkId(int id) {
        boolean check= false;
        try {
            Connection connection=JBDcutils.getConnection();
            String sql ="select * from `account`\n" +
                    "where account_id ?; ";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet rs= statement.executeQuery();
            if(rs.next())
            { check =true;
                }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return  check;
    }


}
