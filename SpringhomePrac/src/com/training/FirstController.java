package com.training;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.DAOImplimentation.EntriesDAO;
import com.training.resources.Entries;

@Controller
public class FirstController {

  @Autowired
  private EntriesDAO dao;
  
  @RequestMapping(value="submit",method=RequestMethod.POST)
  public String submitted( @ModelAttribute("entry") Entries obj,HttpServletRequest request){
    
    String cookieVal= extractLoginCookie(request);
    
    if(cookieVal == null){
      return "Login";
    }
    
    obj.setUserName(cookieVal);
    dao.add(obj);
    return "submit";
  }

  private String extractLoginCookie(HttpServletRequest req) {
    for (Cookie c : req.getCookies()) {
       if (c.getName().equals("loginUNCookie"))
       {
         
       c.setMaxAge(300);
       return c.getValue();
     }
       }
    return null;
}
  
 
}
