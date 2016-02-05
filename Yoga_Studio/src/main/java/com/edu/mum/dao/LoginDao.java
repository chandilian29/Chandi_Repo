/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edu.mum.dao;

import com.mum.edu.domain.MyUser;

/**
 *
 * @author Sandy
 */
public interface LoginDao {
    public void addMYUser(MyUser user);
    public MyUser getUser(String uname);
}
