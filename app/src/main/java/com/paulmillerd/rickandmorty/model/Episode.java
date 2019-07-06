package com.paulmillerd.rickandmorty.model;

public class Episode {

    private String mId, mName, mAirDate, mEpisode;

    public Episode(String id, String name, String airDate, String episode) {
        mId = id;
        mName = name;
        mAirDate = airDate;
        mEpisode = episode;
    }

    public String getId() {
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
}
