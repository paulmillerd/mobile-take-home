package com.paulmillerd.rickandmorty.ui.episodeDetail;

import com.paulmillerd.rickandmorty.model.ICharacter;
import com.paulmillerd.rickandmorty.model.IEpisode;
import com.paulmillerd.rickandmorty.repository.ICharacterDetailRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class EpisodeDetailViewModel extends ViewModel implements IEpisodeDetailViewModel {

    private ICharacterDetailRepository mCharacterDetailRepository;
    private MutableLiveData<IEpisode> mEpisode = new MutableLiveData<>();
    private LiveData<List<ICharacter>> mCharacters = Transformations.switchMap(mEpisode,
            input -> mCharacterDetailRepository.getCharacterDetailList(input.getCharacterIds()));

    @Override
    public void initialize(IEpisode episode, ICharacterDetailRepository characterDetailRepository) {
        mCharacterDetailRepository = characterDetailRepository;
        mEpisode.postValue(episode);
    }

    @Override
    public MutableLiveData<IEpisode> getEpisode() {
        return mEpisode;
    }

    @Override
    public LiveData<List<ICharacter>> getCharacters() {
        return mCharacters;
    }

}
