package Backend;

import Util.JBDcutils;
import entity.DePartment;
import entity.Position;
import enums.Enums;

import java.rmi.server.ExportException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Qlposition {
    public static List<Position> showPosition() throws ClassNotFoundException {
        List<Position> positions = new ArrayList<>();
        try{
            Connection connection =JBDcutils.getConnection();
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
            for(Position  position:positions)
            {
                System.out.println(position);
            }
        }
        catch  (Exception e) {// crtl   alt   L
            throw new RuntimeException(e);
        }
        return positions;
    }
    public static List<Position> findByPositionName(String sreachName)
    {
        List<Position> positions =new ArrayList<>();
        try{
            Connection connection = JBDcutils.getConnection();
            String sql =" select* from position\n" +
                    "where position_name like ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,sreachName);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                int id =resultSet.getInt("position_id");
                String name =resultSet.getString("position_name");
                Position position =new Position(id,Enums.Positionanme.valueOf(name));
                positions.add(position);
            }
            for(Position po:positions)
            {
                System.out.println(po);
            }
    } catch (Exception e) {
            e.printStackTrace();
        }
        return positions;
    }public static boolean createPosition(String name)
    {
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
    public static boolean deletePosition(String deletename)
    {
        try{
            Connection connection = JBDcutils.getConnection();
            String sql="delete from position where position_name = ?;";
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
    public static boolean updatePosition(int id ,String deletename)
    {
        try{
            Connection connection = JBDcutils.getConnection();
            String sql="update position set  position_name =? where position_id =?";
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
