package com.paulmillerd.rickandmorty.ui.episodes;

import com.paulmillerd.rickandmorty.model.Episode;
import com.paulmillerd.rickandmorty.repository.IEpisodeRepository;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

public interface IEpisodesViewModel extends OnEpisodeClickedListener {
    public void initialize(IEpisodeRepository episodeRepository);

    public LiveData<PagedList<Episode>> getAllEpisodes();

    public LiveData<Episode> getClickedEpisode();
}
