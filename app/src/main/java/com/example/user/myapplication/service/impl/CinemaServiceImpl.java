package com.example.user.myapplication.service.impl;

import android.os.AsyncTask;

import com.example.user.myapplication.dao.CinemaRepository;
import com.example.user.myapplication.dao.Repository;
import com.example.user.myapplication.dao.impl.CinemaRepositoryImpl;
import com.example.user.myapplication.model.Cinema;
import com.example.user.myapplication.service.CinemaService;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

/**
 * Created by User on 1/9/2018.
 */

public class CinemaServiceImpl extends AbstractService<Cinema> implements CinemaService {
    public CinemaServiceImpl() {
        super(new CinemaRepositoryImpl());
    }

    @Override
    public Collection<Cinema> getAll() {
        try {
            return new AsyncTask<Void, Void, Collection<Cinema>>() {
                @Override
                protected Collection<Cinema> doInBackground(Void... voids) {
                    return repository.findAll();
                }

            }.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public Cinema getById(final Integer id) {
        try {
            return new AsyncTask<Void, Void, Cinema>() {
                @Override
                protected Cinema doInBackground(Void... voids) {
                    return repository.findById(id);
                }

            }.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new Cinema();
    }

}
