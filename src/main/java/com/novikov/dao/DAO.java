package com.novikov.dao;


import com.novikov.dao.exceptions.DAOException;

import java.util.List;


public interface DAO <T> {
    void add (T obj)throws DAOException;
    void addAll(List<T> obj);
    void update()throws DAOException;
    void remove(T obj);
    void remove (long id);
    T get(long id) throws DAOException;
    List<T> query(Specification specification);

}
