package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.training.DAOImplimentation.EntriesDAO;
import com.training.resources.AuxillaryEntry;

@Controller
public class EditController {

  
  @Autowired
  public AuxillaryEntry auxillaryEntry;
  
  @Autowired
  public ModelAndView mdlView;
  
  @Autowired
  public EntriesDAO dao;
  
  @RequestMapping("submitEdit")
  public ModelAndView EditEntry(@ModelAttribute("auxillaryEntry") 
  AuxillaryEntry auxEntry){
    System.out.println(auxEntry.getEntry());
    System.out.println(auxEntry.getPk());
    dao.update(auxEntry);
    mdlView.setViewName("EditEntry");
    return mdlView;
  }
}
