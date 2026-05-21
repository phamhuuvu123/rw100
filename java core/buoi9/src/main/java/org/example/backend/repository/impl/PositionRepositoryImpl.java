package org.example.backend.repository.impl;

import org.example.backend.repository.IPositionRepository;
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

public class PositionRepositoryImpl implements IPositionRepository {
    @Override
    public List<Position> findAll() {
        List<Position> positions = new ArrayList<>();
        Connection connection =null;
        Statement statement=null;
        ResultSet rs= null;
        try{
            connection = JBDcutils.getConnection();
            String sql ="select *from position  ";
            statement =connection.createStatement();
             rs = statement.executeQuery(sql);

            while (rs.next())
            {
                int id= rs.getInt("position_id");
                String name=rs.getString("position_name");

                Position PO =new Position(id, Enums.Positionanme.valueOf(name));
                positions.add(PO);
            }

        }
        catch  (Exception e) {// crtl   alt   L
           e.printStackTrace();
        }
        finally {
            JBDcutils.closeConnection(connection,statement,rs);
        }
        return positions;
    }

    @Override
    public boolean createPosition(String name) {
        Connection connection=null;
        PreparedStatement statement=null;

        try{
           connection = JBDcutils.getConnection();
            String sql="insert into position (position_name) value (?);";
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            int c=statement.executeUpdate();

            return c>0;
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            JBDcutils.closeConnection(connection,statement,null);
        }
        return false;
    }

    @Override
    public boolean deletePosition(int id) {
        Connection connection=null;
        PreparedStatement statement =null;

        try{
            connection = JBDcutils.getConnection();
            String sql="delete from position where position_id = ?;";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int c=statement.executeUpdate();
                        return c>0;
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            JBDcutils.closeConnection(connection,statement,null);
        }
        return false;
    }

    @Override
    public boolean updatePosition(int id, String name) {
        Connection connection =null;
        PreparedStatement statement=null;
        try{
            connection = JBDcutils.getConnection();
            String sql="update position set  position_name =? where position_id =?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setInt(2,id);
            int c=statement.executeUpdate();

            return c>0;
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            JBDcutils.closeConnection(connection,statement,null);
        }
        return false;
    }

    @Override
    public List<Position> findById(int id) {
        List<Position> positions =new ArrayList<>();
        Connection connection =null;
        PreparedStatement statement=null;
        ResultSet resultSet =null;
        try{
            connection = JBDcutils.getConnection();
            String sql =" select* from position\n" +
                    "where position_id like ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(   1,id);
            resultSet = statement.executeQuery();
            int c=statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JBDcutils.closeConnection(connection,statement,resultSet);
        }
        return positions;
    }

    @Override
    public boolean checkExitId(Integer id) {
        boolean check = false;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        try {
            // b1: kết nối đến DB
            connection = JBDcutils.getConnection();
            // b2: lấy dữ liệu từ bảng position
            String sql = "select * from position where position_id = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            rs = preparedStatement.executeQuery();// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            if (rs.next()) {// lặp qua qua từng dòng của rs
                check = true;
            }
            // đóng các kết nối

        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }finally {
            JBDcutils.closeConnection(connection, preparedStatement, rs);
        }
        return check;
    }

    @Override
    public boolean checkExitIdAndName(String name, Integer id) {
        boolean check = false;
        Connection connection =null;
        PreparedStatement statement =null;
        ResultSet rs=null;
        try{
            connection =JBDcutils.getConnection();
            String sql= "select * from position where position_name=?";
            if(Objects.nonNull(id))
            {
                sql+= " and posiotn_id!= ?";
            }
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            if(Objects.nonNull(id)){
                statement.setInt(2,id);
            }
            rs= statement.executeQuery();
            if(rs.next())
            {
                check =true;
            }
        }catch ( Exception e)
        {
            e.printStackTrace();
        }finally {
            JBDcutils.closeConnection(connection,statement,rs);
        }
        return check;
    }
}
