package com.paulmillerd.rickandmorty.ui.episodes;

import com.paulmillerd.rickandmorty.model.IEpisode;
import com.paulmillerd.rickandmorty.repository.IEpisodeRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

public class EpisodesViewModel extends ViewModel implements IEpisodesViewModel {

    private IEpisodeRepository mEpisodeRepository;

    public void initialize(IEpisodeRepository episodeRepository) {
        mEpisodeRepository = episodeRepository;
    }

    @Override
    public LiveData<PagedList<IEpisode>> getAllEpisodes() {
        return mEpisodeRepository.getAllEpisodes();
    }

}
