package com.paulmillerd.rickandmorty.ui.episodes;

import com.paulmillerd.rickandmorty.model.Episode;
import com.paulmillerd.rickandmorty.repository.IEpisodeRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

public class EpisodesViewModel extends ViewModel implements IEpisodesViewModel {

    private IEpisodeRepository mEpisodeRepository;

    private MutableLiveData<Episode> mClickedEpisode = new MutableLiveData<>();

    public void initialize(IEpisodeRepository episodeRepository) {
        mEpisodeRepository = episodeRepository;
    }

    @Override
    public LiveData<PagedList<Episode>> getAllEpisodes() {
        return mEpisodeRepository.getAllEpisodes();
    }

    @Override
    public void onEpisodeClicked(Episode episode) {
        mClickedEpisode.postValue(episode);
    }

    @Override
    public LiveData<Episode> getClickedEpisode() {
        return mClickedEpisode;
    }

}
