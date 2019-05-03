package com.novikov.dao;


import java.util.List;

public interface DAO <T> {
    void add (T obj);
    void addAll(List<T> obj);
    void update(T obj);
    void remove(T obj);
    void remove (long id);
    T get(long id);
    List<T> query(Specification specification);
}
