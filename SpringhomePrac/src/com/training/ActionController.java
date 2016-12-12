package com.training;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.training.DAOImplimentation.EntriesDAO;
import com.training.resources.Entries;

@Controller
public class ActionController {

  @Autowired
  private ModelAndView mdlView;
  
  @Autowired 
  private Entries entries;
  @Autowired
  private EntriesDAO dao;
  
  @RequestMapping(value="NewEntry")
 public ModelAndView NewEntryPage(HttpServletRequest req){
    
    String cookieVal= extractLoginCookie(req);
    
    if(cookieVal == null){
      mdlView.setViewName("Login");
      return mdlView;
    }
    
    System.out.println("asdasdsa");
    mdlView.setViewName("NewEntry");
    mdlView.addObject("command",entries);
    return mdlView;
    
  }
  
  @RequestMapping(value="OldEntry")
  public ModelAndView OldEntryPage(HttpServletRequest req){
    
    String cookieVal= extractLoginCookie(req);
    
    if(cookieVal == null){
      mdlView.setViewName("Login");
      return mdlView;
    }
    
    List<Entries> listOfEntries  = dao.find(cookieVal);
    System.out.println(cookieVal);
    System.out.println("Old entry");
    mdlView.setViewName("OldEntry");
    mdlView.addObject("command",listOfEntries);
    System.out.println(listOfEntries.size());
    System.out.println(listOfEntries.get(0).getPk());

    return mdlView;
    
  }
 
  private String extractLoginCookie(HttpServletRequest req) {
      
    for (Cookie c : req.getCookies()) {
       if (c.getName().equals("loginUNCookie"))
           {
           System.out.println("Actioncookval : " + c.getValue() +" age:" +c.getMaxAge());
           c.setMaxAge(300);
             return c.getValue();
           }
       }
    return null;
}
  
  
  
}
