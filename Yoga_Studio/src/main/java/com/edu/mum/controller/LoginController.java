/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.controller;

import com.edu.mum.service.LoginService;
import com.mum.edu.domain.MyUser;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Sandy
 */
@Controller
public class LoginController {

    public String userName;

    @Autowired
    private LoginService loginService;
    // please spring doesn't work injection with concrete class!! please ferasa!!!                         

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/manageAccount", method = RequestMethod.GET)
    public String getUserByName(Model model) {
        model.addAttribute("user", loginService.getUser(userName));
        return "manageCustomerAccount";
    }

    @RequestMapping(value = "/loginform", method = RequestMethod.GET)
    public String loginform() {
        return "myLogin";
    }

    @RequestMapping(value = "/myLogin", method = RequestMethod.POST)
    public String myLogin(@RequestParam("uname") String uname, @RequestParam("pwd") String pwd) {
        if (uname.equals("") || pwd.equals("")) {
            return "failure";
        } else {
            MyUser user = loginService.getUser(uname);
            String password = user.getPassword();
            String userType = user.getUsertype();
            userName = user.getUname();
            if (pwd.equals(password)) {
                if (userType.equals("admin")) {
                    return "adminSucessLogin";
                } else if (userType.equals("faculty")) {
                    return "facultySucessLogin";
                } else {
                    return "customerSucessLogin";
                }

            } else {
                return "failedLogin";
            }

        }

    }

    @RequestMapping(value = "/addMyUser", method = RequestMethod.GET)
    public String addMyUser(@ModelAttribute("myuser") MyUser myuser) {
        return "addMyUser";
    }

    @RequestMapping(value = "/addMyUser", method = RequestMethod.POST)
    public String addMyUser(@Valid MyUser myuser, BindingResult result, RedirectAttributes re) {
        if (!result.hasErrors()) {
            loginService.addMyUser(myuser);
        }
        return "sucess";
    }

}
