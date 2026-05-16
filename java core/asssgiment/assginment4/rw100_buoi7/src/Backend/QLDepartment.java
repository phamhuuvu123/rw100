package Backend;

import Util.JBDcutils;
import com.mysql.cj.jdbc.Driver;
import entity.DePartment;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLDepartment {
    public static List<DePartment> showDepartment() throws SQLException {
        List<DePartment> dePartments = new ArrayList<>();
      try{
          Connection connection = JBDcutils.getConnection();
        String sql ="select *from department where department like  ";
        Statement statement =connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

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
    catch  (Exception e) {// crtl   alt   L
          e.printStackTrace();
      }
      return  dePartments;
    } public static List<DePartment> findAllDepartment() throws ClassNotFoundException {
        List<DePartment> departments = new ArrayList<>();// lưu lại dữ liệu lấy từ DB
        try {
            // b1: kết nối đến DB

            Connection connection = JBDcutils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from department;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            List<DePartment> dePartments= new ArrayList<>();// lưu lại dữ liệu lấy từ DB
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("department_id");// lấy giá trị từ cloumn department_id
                String name = rs.getString("department_name");//lấy giá trị từ cloumn department_name
                DePartment dep = new DePartment(id, name);
                departments.add(dep);
            }
            System.out.println("+-----+--------------------+");
            System.out.printf("|%5s|%20s|\n", "ID", "Tên phòng ban");
            System.out.println("+-----+--------------------+");
            for (DePartment department : departments) {
                System.out.printf("|%5s|%20s|\n", department.getId(), department.getName());
            }
            if (departments.size() == 0) {
                System.out.println("Không tìm thấy");
            }
            System.out.println("+-----+--------------------+");

            JBDcutils.closeConnection(connection, statement, rs);
        } catch (Exception e) {
            System.out.println("Kết nối DB ko thành công");
            e.printStackTrace();
        }
        return departments;
    }
    public static List<DePartment> findinnameandId(String searchName,int searchId) throws ClassNotFoundException {

        List<DePartment> dePartments = new ArrayList<>();
        try{
            Connection connection = JBDcutils.getConnection();
            String sql ="select *from department where department_name like ? and department_id = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,searchName);
            statement.setInt(2,searchId);
            ResultSet rs = statement.executeQuery();

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
        catch (Exception e) {
            e.printStackTrace();
        }
        return dePartments;
    }
    public static List<DePartment> phongBanCoHon2NhanVien() throws ClassNotFoundException {
        List<DePartment> dePartments = new ArrayList<>();

        try{
          Connection connection =JBDcutils.getConnection();
            String sql ="select de.department_name,de.department_id,count(1)\n" +
                    "from department as de\n" +
                    "join `account` as acc on acc.department_id= de.department_id\n" +
                    "group by acc.department_id\n" +
                    "having count(1)>=2; ";
            Statement statement =connection.createStatement();

            ResultSet rs = statement.executeQuery(sql);

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
        catch (Exception e) {
            e.printStackTrace();
        }
        return dePartments;
    }
    public static boolean createDepartment(String name)
    {
        try{
            Connection connection = JBDcutils.getConnection();
        String sql="insert into department (department_name) value (?);";
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
    public static boolean deleteDepartment(String deletename)
    {
        try{
            Connection connection = JBDcutils.getConnection();
            String sql="delete from department where department_name = ?;";
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
        public static boolean updateDepartment(int id ,String deletename)
        {
            try{
                Connection connection = JBDcutils.getConnection();
                String sql="update department set  department_name =? where department_id =?";
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
