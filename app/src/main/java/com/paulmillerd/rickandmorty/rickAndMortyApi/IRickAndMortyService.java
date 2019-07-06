package com.paulmillerd.rickandmorty.rickAndMortyApi;

import com.paulmillerd.rickandmorty.model.Episode;

import java.util.List;

public interface IRickAndMortyService {
    public void getEpisodesPage(int page, EpisodePageCallback callback);

    public interface EpisodePageCallback {
        public void onPageLoaded(List<Episode> episodeList, int totalPageCount);

        public void onFailure();
    }
}
