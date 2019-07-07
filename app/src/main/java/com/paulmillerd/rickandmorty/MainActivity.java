package com.paulmillerd.rickandmorty;

import android.os.Bundle;

import com.paulmillerd.rickandmorty.ui.episodes.EpisodesFragment;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.content_frame, new EpisodesFragment())
                .commit();
    }
}
