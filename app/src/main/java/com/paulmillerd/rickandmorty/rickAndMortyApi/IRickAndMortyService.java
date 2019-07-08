package com.paulmillerd.rickandmorty.rickAndMortyApi;

import com.paulmillerd.rickandmorty.model.ICharacter;
import com.paulmillerd.rickandmorty.model.IEpisode;

import java.util.List;

public interface IRickAndMortyService {
    void getEpisodesPage(int page, EpisodePageCallback callback);

    void getEpisodeDetail(int id, EpisodeDetailCallback callback);

    void getCharacterDetail(String url, CharacterDetailCallback callback);

    void getCharacterDetail(int id, CharacterDetailCallback callback);

    interface EpisodePageCallback {
        void onPageLoaded(List<IEpisode> episodeList, int totalEpisodeCount);

        void onFailure();
    }

    interface EpisodeDetailCallback {
        void onDetailLoaded(IEpisode episode);

        void onFailure();
    }

    interface CharacterDetailCallback {
        void onDetailLoaded(ICharacter character);

        void onFailure();
    }
}
