/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.service;

import com.mum.edu.domain.MyUser;

/**
 *
 * @author Sandy
 */
public interface LoginService {

    public MyUser getUser(String uname);

    public void addMyUser(MyUser myUser);

    public MyUser addMyUser(long id, String firstName, String lastName, String address, String phoneNo, String uname, String password, String usertype);

}
