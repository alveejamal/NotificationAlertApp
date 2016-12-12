package com.training.resources;

import org.springframework.stereotype.Component;

@Component("entry")
public class Entries {

  
  private String userName;
  private String subject;
  private String entry;
  private String date;
  private String pk;
  
  public Entries() {
    super();
  }  
  
  
  
  public Entries(String userName, String subject, String entry, String date) {
    super();
    this.userName = userName;
    this.subject = subject;
    this.entry = entry;
    this.date = date;
  }



  public String getSubject() {
    return subject;
  }



  public void setSubject(String subject) {
    this.subject = subject;
  }



  public String getEntry() {
    return entry;
  }



  public void setEntry(String entry) {
    this.entry = entry;
  }



  public String getDate() {
    return date;
  }



  public void setDate(String date) {
    this.date = date;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }



  public String getPk() {
    return pk;
  }


  public void setPk() {
    this.pk = this.date+this.subject+this.entry+this.userName;
  }

  public void setPk(String pk) {
    this.pk = pk;
  }

}