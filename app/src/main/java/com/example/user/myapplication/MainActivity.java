package com.example.user.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.user.myapplication.model.Cinema;
import com.example.user.myapplication.model.Film;
import com.example.user.myapplication.service.CinemaService;
import com.example.user.myapplication.service.FilmService;
import com.example.user.myapplication.service.impl.CinemaServiceImpl;
import com.example.user.myapplication.service.impl.FilmServiceImpl;

import java.util.Collection;


public class MainActivity extends AppCompatActivity {

    TextView myLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLabel = findViewById(R.id.mylabel);
        CinemaService cinemaService = new CinemaServiceImpl();
        Collection<Cinema> all = cinemaService.getAll();
        String res = "";
        for(Cinema cinema : all) {
            res += cinema.getName() + "\n";
        }
        myLabel.setText(res);
    }


}
