package com.novikov.dao;

public interface Specification<T> {
    boolean match(T bean);
}
