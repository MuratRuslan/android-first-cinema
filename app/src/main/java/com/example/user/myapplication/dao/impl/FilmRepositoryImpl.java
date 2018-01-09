package com.example.user.myapplication.dao.impl;



import com.example.user.myapplication.dao.FilmRepository;
import com.example.user.myapplication.model.Film;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

public class FilmRepositoryImpl extends AbstractRepository<Film> implements FilmRepository {

    public FilmRepositoryImpl() {
        super(Config.PATH_FILMS);
    }

    @Override
    public Collection<Film> findAll() {
        return null;
    }

    @Override
    public Collection<Film> findAllFilms(Integer id) {
        URL temp = url;
        Collection<Film> films = new ArrayList<>();

        try {
            url = new URL(serviceUrl + servicePath + "/" + id);
            films = super.findAll();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        url = temp;
        return films;
    }

    @Override
    public Film findById(Integer id) {
        URL temp = url;
        Film film = null;
        try {
            url = new URL(serviceUrl + Config.PATH_FILM + "/" + id);
            film = super.findById(id);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        url = temp;
        return film;
    }

    @Override
    protected Class getClassType() {
        return Film.class;
    }

    @Override
    protected Class getArrayClassType() {
        return Film[].class;
    }
}
