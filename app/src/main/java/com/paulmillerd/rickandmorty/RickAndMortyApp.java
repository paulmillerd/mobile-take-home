package com.paulmillerd.rickandmorty;

import android.app.Application;
import android.content.Context;

import com.paulmillerd.rickandmorty.di.AppComponent;
import com.paulmillerd.rickandmorty.di.DaggerAppComponent;
import com.paulmillerd.rickandmorty.di.module.RickAndMortyApiModule;

public class RickAndMortyApp extends Application {

    private AppComponent mAppComponent;

    public static AppComponent getAppComponent(Context context) {
        return ((RickAndMortyApp) context.getApplicationContext()).mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .rickAndMortyApiModule(new RickAndMortyApiModule())
                .build();
    }

}
