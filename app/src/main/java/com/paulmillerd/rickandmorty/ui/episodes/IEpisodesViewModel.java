package com.paulmillerd.rickandmorty.ui.episodes;

import com.paulmillerd.rickandmorty.model.IEpisode;
import com.paulmillerd.rickandmorty.repository.IEpisodeRepository;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

public interface IEpisodesViewModel {
    void initialize(IEpisodeRepository episodeRepository);

    LiveData<PagedList<IEpisode>> getAllEpisodes();
}
