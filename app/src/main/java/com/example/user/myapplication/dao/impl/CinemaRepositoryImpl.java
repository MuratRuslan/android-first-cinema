package com.example.user.myapplication.dao.impl;



import com.example.user.myapplication.dao.CinemaRepository;
import com.example.user.myapplication.model.Cinema;

import java.util.Collection;

public class CinemaRepositoryImpl extends AbstractRepository<Cinema> implements CinemaRepository {
    public CinemaRepositoryImpl() {
        super(Config.PATH_CINEMAS);
    }


    @Override
    public Cinema findById(Integer id) {
        Collection<Cinema> all = findAll();
        for (Cinema cinema : all) {
            if(cinema.getId().equals(id)) {
                return cinema;
            }
        }
        return null;
    }

    @Override
    protected Class<Cinema> getClassType() {
        return Cinema.class;
    }

    @Override
    protected Class getArrayClassType() {
        return Cinema[].class;
    }
}
