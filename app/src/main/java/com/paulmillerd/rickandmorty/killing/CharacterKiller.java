package com.paulmillerd.rickandmorty.killing;

import android.content.SharedPreferences;

import com.paulmillerd.rickandmorty.model.ICharacter;

public class CharacterKiller implements ICharacterKiller {

    public static final String DEAD = "Dead";

    private SharedPreferences mSharedPreferences;

    public CharacterKiller(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    @Override
    public void killCharacter(ICharacter character) {
        mSharedPreferences.edit()
                .putBoolean("" + character.getId(), true)
                .apply();
    }

    @Override
    public boolean wasCharacterKilled(ICharacter character) {
        return mSharedPreferences.getBoolean("" + character.getId(), false);
    }

}
