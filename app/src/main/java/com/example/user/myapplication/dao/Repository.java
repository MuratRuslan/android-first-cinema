package com.example.user.myapplication.dao;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> findAll();

    T findById(Integer id);
}
