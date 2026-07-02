package com.vti.Repository.impl;

import com.vti.Repository.IPositionRepository;
import com.vti.enitity.Department;
import com.vti.enitity.Position;
import com.vti.enitity.position_name;
import com.vti.utlis.HibernateUtlis;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PositionRepository implements IPositionRepository {
    private final SessionFactory sessionFactory = HibernateUtlis.sessionFactory;
    @Override
    public List<Position> findAll() {
        Session session = sessionFactory.openSession();
        List<Position> positions=new ArrayList<>();
       try {
           String hql="FROM Position";
           Query<Position> query= session.createQuery(hql, Position.class);
           positions =query.list();
       }finally {
           session.close();
       }

        return positions;
    }

    @Override
    public Position findId(Integer id) {
        Session session = sessionFactory.openSession();
        String hql="From Position where id=:idParam";
        Query<Position> query = session.createQuery(hql, Position.class);
        query.setParameter("idParam",id);
        Position position =query.uniqueResult();
        return position;
    }

    @Override
    public void createPosition(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            Position position = new Position();
            position.setName(position_name.valueOf(name));
            session.persist(position);
            session.getTransaction().commit();
        }finally {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void updatePosition(String name, Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            Position position = session.find(Position.class,id);
            position.setName(position_name.valueOf(name));
            session.getTransaction().commit();
        }finally {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void deletePosition(Integer id) {
        Session session = sessionFactory.openSession();
        try{
            com.vti.enitity.Position position =  session.find(Position.class,id);
            session.remove(position);
            session.getTransaction().commit();
        }finally {
            session.getTransaction().rollback();
        }
    }

}
