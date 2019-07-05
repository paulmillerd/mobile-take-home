package com.paulmillerd.rickandmorty;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.OkHttpClient;

import android.os.Bundle;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Named;

import static com.paulmillerd.rickandmorty.di.module.RickAndMortyApiModule.RICK_AND_MORTY_CLIENT_NAME;

public class MainActivity extends AppCompatActivity {

    @Inject
    @Named(RICK_AND_MORTY_CLIENT_NAME)
    ApolloClient rickAndMortyClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RickAndMortyApp.getAppComponent(this).inject(this);

        rickAndMortyClient.query(
                EpisodesQuery.builder()
                        .build()
        ).enqueue(new ApolloCall.Callback<EpisodesQuery.Data>() {
            @Override
            public void onResponse(@NotNull Response<EpisodesQuery.Data> response) {
                for (EpisodesQuery.Result result : response.data().episodes.results) {
                    Log.d("EpisodeLog", result.name);
                }
            }

            @Override
            public void onFailure(@NotNull ApolloException e) {

            }
        });
    }
}
