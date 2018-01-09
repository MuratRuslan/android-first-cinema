package com.example.user.myapplication.service.impl;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.example.user.myapplication.dao.FilmRepository;
import com.example.user.myapplication.dao.Repository;
import com.example.user.myapplication.dao.impl.FilmRepositoryImpl;
import com.example.user.myapplication.model.Film;
import com.example.user.myapplication.service.FilmService;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

/**
 * Created by User on 1/9/2018.
 */

public class FilmServiceImpl extends AbstractService<Film> implements FilmService {


    public FilmServiceImpl() {
        super(new FilmRepositoryImpl());
    }

    @Override
    public Collection<Film> getAll() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public Film getById(final Integer id) {
        try {
            return new AsyncTask<Void, Void, Film>() {
                @Override
                protected Film doInBackground(Void... voids) {
                    return repository.findById(id);
                }

            }.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new Film();
    }

    @Override
    public Collection<Film> getAllFilms(final Integer id) {
        try {
            return new AsyncTask<Void, Void, Collection<Film>>() {
                @Override
                protected Collection<Film> doInBackground(Void... voids) {
                    return ((FilmRepository)repository).findAllFilms(id);
                }
            }.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
