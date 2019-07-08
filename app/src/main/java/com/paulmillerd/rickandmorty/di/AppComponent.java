package com.paulmillerd.rickandmorty.di;

import com.paulmillerd.rickandmorty.di.module.AppModule;
import com.paulmillerd.rickandmorty.di.module.RickAndMortyApiModule;
import com.paulmillerd.rickandmorty.ui.characterDetail.CharacterDetailFragment;
import com.paulmillerd.rickandmorty.ui.episodeDetail.EpisodeDetailFragment;
import com.paulmillerd.rickandmorty.ui.episodes.EpisodesFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RickAndMortyApiModule.class, AppModule.class})
public interface AppComponent {
    void inject(EpisodesFragment episodesFragment);

    void inject(EpisodeDetailFragment episodeDetailFragment);

    void inject(CharacterDetailFragment characterDetailFragment);
}
