package com.paulmillerd.rickandmorty.di.module;

import com.paulmillerd.rickandmorty.repository.EpisodeRepository;
import com.paulmillerd.rickandmorty.repository.IEpisodeRepository;
import com.paulmillerd.rickandmorty.rickAndMortyApi.IRickAndMortyService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    public IEpisodeRepository providesEpisodeRepository(IRickAndMortyService rickAndMortyService) {
        return new EpisodeRepository(rickAndMortyService);
    }

}
