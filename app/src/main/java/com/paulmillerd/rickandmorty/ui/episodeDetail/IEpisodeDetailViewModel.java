package com.paulmillerd.rickandmorty.ui.episodeDetail;

import com.paulmillerd.rickandmorty.model.ICharacter;
import com.paulmillerd.rickandmorty.model.IEpisode;
import com.paulmillerd.rickandmorty.repository.ICharacterDetailRepository;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface IEpisodeDetailViewModel {
    void initialize(IEpisode episode, ICharacterDetailRepository characterDetailRepository);

    LiveData<List<ICharacter>> getCharacters();

    LiveData<IEpisode> getEpisode();
}
