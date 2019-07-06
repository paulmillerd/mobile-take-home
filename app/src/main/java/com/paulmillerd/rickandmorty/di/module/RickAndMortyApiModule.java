package com.paulmillerd.rickandmorty.di.module;

import com.apollographql.apollo.ApolloClient;
import com.paulmillerd.rickandmorty.rickAndMortyApi.IRickAndMortyService;
import com.paulmillerd.rickandmorty.rickAndMortyApi.RickAndMortyService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public class RickAndMortyApiModule {

    private static final String BASE_URL = "https://rickandmortyapi.com/graphql";

    @Provides
    @Singleton
    public IRickAndMortyService providesRickAndMortyService() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        ApolloClient apolloClient = ApolloClient.builder()
                .okHttpClient(okHttpClient)
                .serverUrl(BASE_URL)
                .build();

        return new RickAndMortyService(apolloClient);
    }

}
