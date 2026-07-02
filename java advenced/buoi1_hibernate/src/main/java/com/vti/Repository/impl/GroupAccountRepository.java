package com.vti.Repository.impl;

import com.vti.Repository.IGroupAccountRepository;
import com.vti.Repository.IGroupRepository;
import com.vti.enitity.Group;
import com.vti.enitity.GroupAccount;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import static com.vti.utlis.HibernateUtlis.sessionFactory;

public class GroupAccountRepository implements IGroupAccountRepository {
    @Override
    public List<GroupAccount> findAll() {
        Session session = sessionFactory.openSession();
        List<GroupAccount> groupAccounts = new ArrayList<>();
        try {
            String hql="FROM `Group`";
            Query<GroupAccount> query= session.createQuery(hql, GroupAccount.class);
            groupAccounts = query.list();
        }finally {
            session.close();
        }
        return groupAccounts;
    }

    @Override
    public void cretea(GroupAccount groupAccount) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            session.persist(groupAccount);
            session.getTransaction().commit();
        }finally {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void Update(Integer id, Group group) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            GroupAccount groupAccount = session.find(GroupAccount.class,id);
            groupAccount.setGroup(group);
            session.getTransaction().commit();
        }finally {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        try{
           GroupAccount groupAccount= session.find(GroupAccount.class,id);
            session.remove(groupAccount);
            session.getTransaction().commit();
        }finally {
            session.getTransaction().rollback();
        }
    }
}
