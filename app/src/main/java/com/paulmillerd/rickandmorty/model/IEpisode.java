package com.paulmillerd.rickandmorty.model;

import java.io.Serializable;
import java.util.List;

public interface IEpisode extends Serializable {
    int getId();

    String getName();

    String getEpisode();

    String getAirDate();

    List<Integer> getCharacterIds();
}
