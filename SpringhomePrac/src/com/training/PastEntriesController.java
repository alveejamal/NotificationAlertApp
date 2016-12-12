package com.training;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.DAOImplimentation.EntriesDAO;
import com.training.resources.Entries;

@Controller
@Scope("session")

public class PastEntriesController {

  @Autowired
  private ModelAndView mdlView;
  
  @Autowired
  private EntriesDAO dao;
  
  
  @RequestMapping(value="ReadEntry",method=RequestMethod.POST)
  public ModelAndView ReadEntryPage(String obj, HttpServletRequest req){

    
    String cookieVal= extractLoginCookie(req);
    
    if(cookieVal == null){
      mdlView.setViewName("Login");
      return mdlView;
    }
    
    System.out.println(req.getParameter("pk"));
    
    Entries editEntry = dao.findUsingPk(req.getParameter("pk"));
    mdlView.setViewName("ViewEntry");
    mdlView.addObject("command",editEntry);
    System.out.println(editEntry.getEntry());
    return mdlView;
    
  }

  private String extractLoginCookie(HttpServletRequest req) {
    for (Cookie c : req.getCookies()) {
       if (c.getName().equals("loginUNCookie"))
       {
         System.out.println("FirstControllerActioncookval : " + c.getValue() +" age:" +c.getMaxAge());
         c.setMaxAge(300);
       return c.getValue();
     }
       }
    return null;
}
  
  
}
