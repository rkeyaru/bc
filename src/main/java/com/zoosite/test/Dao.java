package com.zoosite.test;

import java.util.List;

public interface Dao<T> {
    
    T get(long id);
    
    List<T> getAll();
    
    Boolean save(T t);
    
    void update(T t );
    
    T delete(int t);
}