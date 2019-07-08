package com.paulmillerd.rickandmorty.killing;

import com.paulmillerd.rickandmorty.model.ICharacter;

public interface ICharacterKiller {
    void killCharacter(ICharacter character);

    boolean wasCharacterKilled(ICharacter character);
}
