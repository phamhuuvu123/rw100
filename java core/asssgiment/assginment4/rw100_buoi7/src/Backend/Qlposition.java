package Backend;

import entity.DePartment;
import entity.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Qlposition {
    public static void showPosition() throws SQLException {
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
            String sql ="select *from position  ";
            Statement statement =connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            List<Position> positions = new ArrayList<>();
            while (rs.next())
            {
                int id= rs.getInt("position_id");
                String name=rs.getString("position_name");
                Position PO =new Position(id,name);
                positions.add(PO);
            }
            for(Position  position:positions)
            {
                System.out.println(position);
            }
        }
        catch  (ClassNotFoundException e) {// crtl   alt   L
            throw new RuntimeException(e);
        }
    }
    public static void findByPositionName(String sreachName)
    {

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
            String sql =" select* from position\n" +
                    "where position_name like ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,sreachName);
            ResultSet resultSet = statement.executeQuery();
            List<Position> positions =new ArrayList<>();
            while (resultSet.next())
            {
                int id =resultSet.getInt("position_id");
                String name =resultSet.getString("position_name");
                Position position =new Position(id,name);
                positions.add(position);
            }
            for(Position po:positions)
            {
                System.out.println(po);
            }
    } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
