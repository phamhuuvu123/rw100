package com.vti.utlis;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtlis {
    public static  SessionFactory sessionFactory ;
    static {
        Configuration cfg= new Configuration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
        Session session =sessionFactory.openSession();
    }
}
