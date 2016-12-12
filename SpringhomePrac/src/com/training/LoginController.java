package com.training;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.training.DAOImplimentation.UserDAO;
import com.training.resources.User;

@Controller
public class LoginController {
  
  @Autowired
  private ModelAndView mdlView;
  

  @Autowired
  private UserDAO userDao;  
  
  @RequestMapping("/")
  public ModelAndView ActionPage(){
    mdlView.addObject("msg","");
    mdlView.setViewName("Login");
    return mdlView;
  }
 
  @RequestMapping(value="CreateNewAccount")
  public ModelAndView CreateAccountPage(){
    mdlView.setViewName("CreateAccount");
    return mdlView;
  }
  
  @RequestMapping(value="Login")
  public ModelAndView TryLogin(@ModelAttribute("user") User obj,
      HttpServletRequest request,
      HttpServletResponse response){
    
    String cookieVal= extractLoginCookie(request);
    
    if(cookieVal !=null){
      mdlView.setViewName("Action");
      return mdlView;
    }
    List<User> unverifiedUser = userDao.find(obj.getUserName());
    System.out.println(unverifiedUser.size());
    if(unverifiedUser.isEmpty()){
      mdlView.addObject("msg", "User does not exist!");
      mdlView.setViewName("Login");
      return mdlView;
    }
  
    else
    {
      String auxPassword = unverifiedUser.get(0).getPassword();
      
      if(auxPassword.equals(obj.getPassword())){
        mdlView.setViewName("Action");
        setCookie(response,obj.getUserName());
        
      }
      else{
        System.out.println("wrong pass");
        mdlView.setViewName("Login");
        mdlView.addObject("msg", "wrong username and password combination!");
      }
      return mdlView;
    }
  }
 
  @RequestMapping(value = "CreateAccount")
  public ModelAndView TryCreateAccount( @ModelAttribute("user") User obj,HttpServletResponse response){
    
    System.out.println(obj.getUserName());
    List<User> users = userDao.find(obj.getUserName());
    
    if(users.isEmpty())
    {
      userDao.add(obj);
      mdlView.setViewName("UserAdded");
      setCookie(response,obj.getUserName());
    }
    else 
    {
      mdlView.setViewName("CreateAccount");
      mdlView.addObject("command", obj.getUserName() + " already Exists!Try a different User Name");

    }
      
    return mdlView;
  }
  
  @RequestMapping(value="logout")
  public ModelAndView Logout(HttpServletRequest req,HttpServletResponse response){
    for (Cookie c : req.getCookies()) {
      if (c.getName().equals("loginUNCookie"))
        c.setMaxAge(0);
        c.setValue(null);
        response.addCookie(c);
      }
    
    mdlView.setViewName("Login");
    return mdlView;
      
  }
  
  
  public void setCookie(HttpServletResponse response,String name){
    Cookie cook = new Cookie("loginUNCookie",name);
    System.out.println(name);
    cook.setMaxAge(300);
    response.addCookie(cook);
    System.out.println("logincookval : " + cook.getValue());
  }

  private String extractLoginCookie(HttpServletRequest req) {
    for (Cookie c : req.getCookies()) {
       if (c.getName().equals("loginUNCookie"))
           return c.getValue();
       }
    return null;
}
}
