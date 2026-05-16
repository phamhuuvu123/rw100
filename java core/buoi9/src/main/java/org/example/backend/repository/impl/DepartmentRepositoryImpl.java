package org.example.backend.repository.impl;

import org.example.backend.repository.IDepartmentRepository;
import org.example.entity.DePartment;
import org.example.utlis.JBDcutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryImpl implements IDepartmentRepository {

    @Override
    public List<DePartment> findAll() {// lay ds department
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
                int id = rs.getInt("department_id");// lấy giá trị từ  department_id
                String name = rs.getString("department_name");//lấy giá trị từ  department_name
                DePartment dep = new DePartment(id, name);
                departments.add(dep);
            }
            JBDcutils.closeConnection(connection, statement, rs);
        } catch (Exception e) {
            System.out.println("Kết nối DB ko thành công");
            e.printStackTrace();
        }
        return departments;
    }
    public  boolean insertDepartment(String name){
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

    @Override
    public boolean deleteDepartment(int id) {
        try{
            Connection connection = JBDcutils.getConnection();
            String sql="delete from department where department_id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int c=statement.executeUpdate();
            JBDcutils.closeConnection(connection,statement,null);
            return c>0;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateDepartment(int id, String name) {
        try{
            Connection connection = JBDcutils.getConnection();
            String sql="update department set  department_name =? where department_id =?";
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
}
