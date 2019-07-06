package com.paulmillerd.rickandmorty;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RickAndMortyApp.getAppComponent(this).inject(this);

//        rickAndMortyClient.query(
//                EpisodesQuery.builder()
//                        .build()
//        ).enqueue(new ApolloCall.Callback<EpisodesQuery.Data>() {
//            @Override
//            public void onResponse(@NotNull Response<EpisodesQuery.Data> response) {
//                for (EpisodesQuery.Result result : response.data().episodes.results) {
//                    Log.d("EpisodeLog", result.name);
//                }
//            }
//
//            @Override
//            public void onFailure(@NotNull ApolloException e) {
//
//            }
//        });
    }
}
