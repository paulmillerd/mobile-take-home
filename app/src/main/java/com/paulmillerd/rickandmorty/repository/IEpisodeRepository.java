package com.paulmillerd.rickandmorty.repository;

import com.paulmillerd.rickandmorty.model.Episode;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

public interface IEpisodeRepository {
    public LiveData<PagedList<Episode>> getAllEpisodes();
}
