package com.paulmillerd.rickandmorty.model;

import java.io.Serializable;

public interface ICharacter extends Serializable {
    int getId();

    String getName();

    String getImage();

    String getStatus();

    String getSpecies();

    String getLocationName();

    String getOriginName();
}
