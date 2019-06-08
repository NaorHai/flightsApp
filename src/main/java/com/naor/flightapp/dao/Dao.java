package com.naor.flightapp.dao;

public interface Dao<T,S> {
    T saveOrUpdate(T t);
    T get(S id);
}
