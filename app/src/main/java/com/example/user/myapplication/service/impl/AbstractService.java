package com.example.user.myapplication.service.impl;

import android.os.AsyncTask;

import com.example.user.myapplication.dao.CinemaRepository;
import com.example.user.myapplication.dao.Repository;
import com.example.user.myapplication.dao.impl.CinemaRepositoryImpl;
import com.example.user.myapplication.service.Service;

/**
 * Created by User on 1/9/2018.
 */

public abstract class AbstractService<T> implements Service<T> {

    protected Repository<T> repository;

    public AbstractService(Repository<T> repository) {
        this.repository = repository;
    }

}
