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

public class PositionRepositoryImpl implements IPositionRepository {
    @Override
    public List<Position> findAll() {
        List<Position> positions = new ArrayList<>();
        try{
            Connection connection = JBDcutils.getConnection();
            String sql ="select *from position  ";
            Statement statement =connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next())
            {
                int id= rs.getInt("position_id");
                String name=rs.getString("position_name");

                Position PO =new Position(id, Enums.Positionanme.valueOf(name));
                positions.add(PO);
            }
            JBDcutils.closeConnection(connection,statement,rs);
        }
        catch  (Exception e) {// crtl   alt   L
            throw new RuntimeException(e);
        }
        return positions;
    }

    @Override
    public boolean createPosition(String name) {
        try{
            Connection connection = JBDcutils.getConnection();
            String sql="insert into position (position_name) value (?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,name);
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
    public boolean deletePosition(int id) {

        try{
            Connection connection = JBDcutils.getConnection();
            String sql="delete from position where position_id = ?;";
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
    public boolean updatePosition(int id, String name) {

        try{
            Connection connection = JBDcutils.getConnection();
            String sql="update position set  position_name =? where position_id =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,name);
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
    public List<Position> findById(int id) {
        List<Position> positions =new ArrayList<>();
        try{
            Connection connection = JBDcutils.getConnection();
            String sql =" select* from position\n" +
                    "where position_id like ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(   1,id);
            ResultSet resultSet = statement.executeQuery();

            int c=statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return positions;
    }
}
