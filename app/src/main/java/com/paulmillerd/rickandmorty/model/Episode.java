package com.paulmillerd.rickandmorty.model;

import java.util.List;

public class Episode implements IEpisode {

    private int mId;
    private String mName, mAirDate, mEpisode;
    private List<Integer> mCharacterIds;

    public Episode(int id, String name, String airDate, String episode, List<Integer> characterIds) {
        mId = id;
        mName = name;
        mAirDate = airDate;
        mEpisode = episode;
        mCharacterIds = characterIds;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getAirDate() {
        return mAirDate;
    }

    public String getEpisode() {
        return mEpisode;
    }

    @Override
    public List<Integer> getCharacterIds() {
        return mCharacterIds;
    }
}
