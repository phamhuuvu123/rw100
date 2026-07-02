package com.vti.Repository.impl;

import com.vti.Repository.IAccountRepository;
import com.vti.enitity.Account;
import com.vti.enitity.Department;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import static com.vti.utlis.HibernateUtlis.sessionFactory;

public class AccountReoository implements IAccountRepository {

    @Override
    public List<Account> findAll() {
        Session session = sessionFactory.openSession();
        List<Account> Acc= new ArrayList<>();
        try {
            String hql="FROM Account";
            Query<Account> query= session.createQuery(hql, Account.class);
            Acc= query.list();
        }finally {
            session.close();
        }

        return Acc;
    }

    @Override
    public void cretea(Account account) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            session.persist(account);
            session.getTransaction().commit();
        }finally {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void Update(Integer id, String fullname) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try{

        Account account =  session.find(Account.class,id);
        account.setFullName(fullname);
        session.beginTransaction().commit();
        }finally {
            session.getTransaction().rollback();
        }

    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        try{
            Account account =  session.find(Account.class,id);
            session.remove(account);
            session.getTransaction().commit();
        }finally {
            session.getTransaction().rollback();
        }
    }
}
