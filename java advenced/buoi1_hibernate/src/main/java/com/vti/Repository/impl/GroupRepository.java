package com.vti.Repository.impl;

import com.vti.Repository.IGroupRepository;
import com.vti.enitity.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import static com.vti.utlis.HibernateUtlis.sessionFactory;

public class GroupRepository implements IGroupRepository {
    @Override
    public List<Group> findAll() {
        Session session = sessionFactory.openSession();
        List<Group> groups = new ArrayList<>();
        try {
            String hql="FROM `Group`";
            Query<Group> query= session.createQuery(hql, Group.class);
            groups = query.list();
        }finally {
            session.close();
        }

        return  groups;
    }

    @Override
    public void cretea(Group group) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            session.persist(group);
            session.getTransaction().commit();
        }finally {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void Update(Integer id, String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            com.vti.enitity.Group group = session.find(Group.class,id);
            group.setGroupName(name);
            session.getTransaction().commit();
        }finally {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        try{
            com.vti.enitity.Group group =  session.find(Group.class,id);
            session.remove(group);
            session.getTransaction().commit();
        }finally {
            session.getTransaction().rollback();
        }
    }
}
