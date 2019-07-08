package com.paulmillerd.rickandmorty.di.module;

import android.content.Context;

import com.paulmillerd.rickandmorty.rickAndMortyApi.IRickAndMortyService;
import com.paulmillerd.rickandmorty.rickAndMortyApi.RickAndMortyService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RickAndMortyApiModule {

    private Context mContext;

    public RickAndMortyApiModule(Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    public IRickAndMortyService providesRickAndMortyService() {
        return new RickAndMortyService(mContext);
    }

}
