package com.training.DAOImplimentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.training.resources.AuxillaryEntry;
import com.training.resources.Entries;
import com.training.utils.EntriesRowMapper;
@Component("dao")
public class EntriesDAO implements com.training.Ifaces.MyDAO<Entries> {

  @Autowired
  private JdbcTemplate template;
  
  
  public int add(Entries obj){
   
    String sql = "Insert into Entry values(?,?,?,?,?)";
    
    int rowsInserted = template.update(sql,obj.getDate(),
        obj.getSubject(),
       obj.getEntry(),
       obj.getUserName(),
       "");
    
    return rowsInserted;
  }

  @Override
  public List<Entries> find(String userName) {
    
    String sql="select * from ENTRY where USERNAME='" + userName + "'";  
    List<Entries> inv=template.query(sql,
               new EntriesRowMapper());
    System.out.println(inv.size());
    return inv;
  }

  public Entries findUsingPk(Object primaryKey) {
    
    String pk = (String) primaryKey;
    String sql="select * from ENTRY where ID='" + pk + "'";  
    Entries inv=template.queryForObject(sql, new EntriesRowMapper());
    return inv;
  }
  
  public boolean update(AuxillaryEntry auxEntry){

    String sql="UPDATE ENTRY SET SUBJECT='" + auxEntry.getSubject() +
        "',ENTRY='"+auxEntry.getEntry() + "' WHERE ID="+auxEntry.getPk();
         
    int affectedRowNumber = template.update(sql);
    if(affectedRowNumber == 1)
     return true;
   return false;
  }
  
}
