/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.dao;

import com.mum.edu.domain.MyUser;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sandy
 */
@Transactional
public class LoginDaoImpl implements LoginDao {

    private SessionFactory sf;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sf = sessionFactory;
    }

    @Override
    public void addMYUser(MyUser user) {
        sf.getCurrentSession().persist(user);
    }

    public MyUser getUser(String uname) {
        Query query = sf.getCurrentSession().createQuery("Select u from MyUser u where u.uname=:uname");
        query.setParameter("uname", uname);
        return (MyUser) query.list().get(0);
    }
}
