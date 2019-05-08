package com.novikov.dao;


import com.novikov.dao.exceptions.DAOException;

import java.util.List;


public interface DAO <T> {
    void add (T obj)throws DAOException;
    void resetDAO() throws DAOException;
    void addAll(List<T> obj);
    void update()throws DAOException;
    void remove(T obj)throws DAOException;
    void remove (long id) throws  DAOException;
    T get(long id) throws DAOException;
    List<T> getAll();
    List query(Specification specification) throws DAOException;

}
