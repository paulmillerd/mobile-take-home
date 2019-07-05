package com.paulmillerd.rickandmorty.di.module;

import com.apollographql.apollo.ApolloClient;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public class RickAndMortyApiModule {

    private static final String BASE_URL = "https://rickandmortyapi.com/graphql";
    public static final String RICK_AND_MORTY_CLIENT_NAME = "rickAndMortyClient";

    @Provides
    @Singleton
    public OkHttpClient providesOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    @Provides
    @Singleton
    @Named(RICK_AND_MORTY_CLIENT_NAME)
    public ApolloClient providesRickAndMortyClient(OkHttpClient okHttpClient) {
        return ApolloClient.builder()
                .okHttpClient(okHttpClient)
                .serverUrl(BASE_URL)
                .build();
    }

}
