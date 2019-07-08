package com.paulmillerd.rickandmorty.repository;

import android.util.Log;

import com.paulmillerd.rickandmorty.model.Character;
import com.paulmillerd.rickandmorty.model.ICharacter;
import com.paulmillerd.rickandmorty.rickAndMortyApi.IRickAndMortyService;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class CharacterDetailRepository implements ICharacterDetailRepository {

    private IRickAndMortyService mRickAndMortyService;

    public CharacterDetailRepository(IRickAndMortyService rickAndMortyService) {
        mRickAndMortyService = rickAndMortyService;
    }

    @Override
    public LiveData<ICharacter> getCharacterDetail(int id) {
        MutableLiveData<ICharacter> characterLiveData = new MutableLiveData<>();

        mRickAndMortyService.getCharacterDetail(id, new IRickAndMortyService.CharacterDetailCallback() {
            @Override
            public void onDetailLoaded(ICharacter character) {
                characterLiveData.postValue(character);
            }

            @Override
            public void onFailure() {
                // fail gracefully
            }
        });

        return characterLiveData;
    }

    @Override
    public LiveData<List<ICharacter>> getCharacterDetailList(List<Integer> ids) {
        MutableLiveData<List<ICharacter>> liveData = new MutableLiveData<>();

        ArrayList<ICharacter> tempList = new ArrayList<>();
        for (Integer id : ids) {
            tempList.add(new Character(id, "", "", "", "", "", ""));
        }
        liveData.postValue(tempList);

        final int[] counter = {0};

        Log.d("CharacterDetailLogs", "Requesting detail for " + ids.size() + " characters");
        for (Integer id : ids) {
            mRickAndMortyService.getCharacterDetail(id, new IRickAndMortyService.CharacterDetailCallback() {
                @Override
                public void onDetailLoaded(ICharacter character) {
                    synchronized (liveData) {
                        if (liveData.getValue() != null) {
                            ArrayList<ICharacter> newTempList = new ArrayList<>(liveData.getValue());

                            int index = -1;

                            for (int i = 0; i < newTempList.size(); i++) {
                                if (tempList.get(i).getId() == id) {
                                    Log.d("CharacterDetailLogs", "Received detail for " + ++counter[0] + " characters");
                                    index = i;
                                }
                            }

                            if (index != -1) {
                                newTempList.set(index, character);
                            }

                            liveData.setValue(newTempList);
                        }
                    }
                }

                @Override
                public void onFailure() {

                }
            });
        }

        return liveData;
    }

}
