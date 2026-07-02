package com.vti.Repository.impl;

import com.vti.Repository.IDepartmentRepository;
import com.vti.enitity.Account;
import com.vti.enitity.Department;
import com.vti.utlis.HibernateUtlis;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import static com.vti.utlis.HibernateUtlis.sessionFactory;

public class DepartmentRepositoryimpl implements IDepartmentRepository {
    private final SessionFactory  sessionFactory = HibernateUtlis.sessionFactory;
    @Override
    public List<Department> findAll() {
        Session session = sessionFactory.openSession();
        List<Department> departments= new ArrayList<>();
        try {
            String hql="FROM Department";
            Query<Department> query= session.createQuery(hql, Department.class);
            departments= query.list();
        }finally {
            session.close();
        }

        return departments;
    }

    @Override
    public Department findId(Integer id) {
        Session session = sessionFactory.openSession();
        String hql="From Department where id=:idParam";
        Query<Department> query = session.createQuery(hql, Department.class);
        query.setParameter("idParam",id);
        Department department =query.uniqueResult();
        return department;
    }

    @Override
    public void create(String name) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
        try{
        Department department = new Department();
        department.setName(name);
        session.persist(department);
        session.getTransaction().commit();
        }finally {
        session.getTransaction().rollback();
         }
    }

    @Override
    public void update(String name, Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            Department department =session.find(Department.class,id);
            department.setName(name);
            session.getTransaction().commit();
        }finally {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        try{
            com.vti.enitity.Department department =  session.find(Department.class,id);
            session.remove(department);
            session.getTransaction().commit();
        }finally {
            session.getTransaction().rollback();
        }
    }
}
