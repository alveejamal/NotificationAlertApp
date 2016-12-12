package com.training.Ifaces;

import java.util.List;

public interface MyDAO<T> {

public int add(T obj);

public List<T> find(String userName);
  
}
