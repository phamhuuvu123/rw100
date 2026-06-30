//package com.vti.backend;
//
//import com.vti.enitity.Department;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.query.Query;
//
//import javax.security.auth.login.AppConfigurationEntry;
//import java.util.ArrayList;
//import java.util.List;
//
//public class program {
//    public static void main(String[] args) {
//      // b1 tao session ket noi den database
//        SessionFactory sessionFactory;
//        Configuration cfg= new Configuration();
//        cfg.configure();
//        sessionFactory = cfg.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        List<Department> departments= new ArrayList<>();
//        String hql="FROM Department";
//        Query<Department> query= session.createQuery(hql, Department.class);
//        departments= query.list();
//        for(Department dep:departments)
//        {
//            System.out.println(dep.toString());
//        }
//
//    }
//}
