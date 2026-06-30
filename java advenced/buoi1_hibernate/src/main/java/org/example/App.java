package org.example;

import com.vti.Controller.DepartmentController;
import com.vti.Controller.PositionController;
import com.vti.enitity.Department;
import com.vti.enitity.Position;
import com.vti.utlis.HibernateUtlis;
import org.hibernate.SessionFactory;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
//        DepartmentController departmentController = new DepartmentController();
//         List<Department> departmentList= departmentController.findAll();
//        for (Department department:departmentList)
//        {
//            System.out.println(department.toString());
//        }
        PositionController positionController = new PositionController();
//        List<Position> positions = positionController.findAll();
//        for(Position po:positions)
//        {
//            System.out.println(po.toString());
//        }
        Position position=positionController.findId(1);
        System.out.println(position.toString());
    }
}
