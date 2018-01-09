package com.example.user.myapplication.dao;



import com.example.user.myapplication.model.Film;

import java.util.Collection;

public interface FilmRepository extends Repository<Film> {

    Collection<Film> findAllFilms(Integer id);
}
