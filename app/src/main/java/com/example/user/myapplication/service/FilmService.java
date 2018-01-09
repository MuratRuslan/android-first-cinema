package com.example.user.myapplication.service;

import com.example.user.myapplication.model.Film;

import java.util.Collection;

/**
 * Created by User on 1/9/2018.
 */

public interface FilmService extends Service<Film> {

    Collection<Film> getAllFilms(Integer id);
}
