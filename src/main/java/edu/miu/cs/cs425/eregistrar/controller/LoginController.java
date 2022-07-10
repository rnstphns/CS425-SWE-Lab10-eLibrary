package edu.miu.cs.cs425.eregistrar.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController {

    @GetMapping (value = {"/login" , "/eregistrar/login"})
    public String displayLoginPage(){
        return "login/login";
    }
    @PostMapping(value = {"/logout", "eregistrar/logout"})
    public String doLogout(HttpServletRequest request, HttpServletResponse response,
                           Authentication authentication) throws ServletException{
        request.logout();
        return "redirect:/eregistrar/login?logout";
    }

}
