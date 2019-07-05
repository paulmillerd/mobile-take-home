package com.paulmillerd.rickandmorty.di;

import com.paulmillerd.rickandmorty.MainActivity;
import com.paulmillerd.rickandmorty.di.module.RickAndMortyApiModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RickAndMortyApiModule.class})
public interface AppComponent {
    public void inject(MainActivity mainActivity);
}
