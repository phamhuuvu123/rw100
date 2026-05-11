package Backend;

import com.mysql.cj.jdbc.Driver;
import entity.DePartment;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLDepartment {
    public static void showDepartment() throws SQLException {
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
        String sql ="select *from department where department like  ";
        Statement statement =connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<DePartment> dePartments = new ArrayList<>();
        while (rs.next())
        {
            int id= rs.getInt("department_id");
            String name=rs.getString("department_name");
            DePartment dep =new DePartment(id,name);
            dePartments.add(dep);
        }
        for(DePartment dep:dePartments)
        {
            System.out.println(dep);
        }
    }
    catch  (ClassNotFoundException e) {// crtl   alt   L
          throw new RuntimeException(e);
      }
    }
    public static void findinnameandId(String searchName,int searchId) throws ClassNotFoundException {
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
            String sql ="select *from department where department_name like ? and department_id = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,searchName);
            statement.setInt(2,searchId);
            ResultSet rs = statement.executeQuery();
            List<DePartment> dePartments = new ArrayList<>();
            while (rs.next())
            {
                int id= rs.getInt("department_id");
                String name=rs.getString("department_name");
                DePartment dep =new DePartment(id,name);
                dePartments.add(dep);
            }
            for(DePartment dep:dePartments)
            {
                System.out.println(dep);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void phongBanCoHon2NhanVien() throws ClassNotFoundException {
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
            String sql ="select de.department_name,de.department_id,count(1)\n" +
                    "from department as de\n" +
                    "join `account` as acc on acc.department_id= de.department_id\n" +
                    "group by acc.department_id\n" +
                    "having count(1)>=2; ";
            Statement statement =connection.createStatement();

            ResultSet rs = statement.executeQuery(sql);
            List<DePartment> dePartments = new ArrayList<>();
            while (rs.next())
            {
                int id= rs.getInt("department_id");
                String name=rs.getString("department_name");
                DePartment dep =new DePartment(id,name);
                dePartments.add(dep);
            }
            for(DePartment dep:dePartments)
            {
                System.out.println(dep);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
