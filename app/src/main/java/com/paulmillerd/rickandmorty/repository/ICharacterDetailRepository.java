package com.paulmillerd.rickandmorty.repository;

import com.paulmillerd.rickandmorty.model.ICharacter;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface ICharacterDetailRepository {
    LiveData<ICharacter> getCharacterDetail(int id);

    LiveData<List<ICharacter>> getCharacterDetailList(List<Integer> ids);
}
