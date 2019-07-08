package com.paulmillerd.rickandmorty.repository;

import com.paulmillerd.rickandmorty.model.IEpisode;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

public interface IEpisodeRepository {
    LiveData<PagedList<IEpisode>> getAllEpisodes();

    LiveData<IEpisode> getEpisodeDetail(int id);
}
