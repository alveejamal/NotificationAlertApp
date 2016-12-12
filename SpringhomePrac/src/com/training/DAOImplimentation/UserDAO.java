package com.training.DAOImplimentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.training.resources.User;
import com.training.utils.UserRowMapper;

@Component("userDao")
public class UserDAO  implements com.training.Ifaces.MyDAO<User>{

  @Autowired
  private JdbcTemplate template;
  
  @Override
  public int add(User obj) {

    String sql = "Insert into USERINFO values(?,?)";
    
    int rowsInserted = template.update(sql,obj.getUserName(),
        obj.getPassword());
    
    return rowsInserted;
  }

  @Override
  public List<User> find(String userName) {
    String sql="select * from USERINFO where USERNAME='" + userName + "'";  
    List<User> inv=template.query(sql,
               new UserRowMapper());
    return inv;
  }

  
}
