package com.example.user.myapplication.service;

import java.util.Collection;

/**
 * Created by User on 1/9/2018.
 */

public interface Service<T> {
    Collection<T> getAll();

    T getById(Integer id);
}
