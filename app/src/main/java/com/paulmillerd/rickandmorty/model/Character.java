package com.paulmillerd.rickandmorty.model;

public class Character implements ICharacter {

    private int mId;
    private String mName;
    private String mImage;
    private String mStatus;
    private String mSpecies;
    private String mLocationName;
    private String mOriginName;

    public Character(int id, String name, String image, String status, String species,
                     String locationName, String originName) {
        mId = id;
        mName = name;
        mImage = image;
        mStatus = status;
        mSpecies = species;
        mLocationName = locationName;
        mOriginName = originName;
    }

    @Override
    public int getId() {
        return mId;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public String getImage() {
        return mImage;
    }

    @Override
    public String getStatus() {
        return mStatus;
    }

    @Override
    public String getSpecies() {
        return mSpecies;
    }

    @Override
    public String getLocationName() {
        return mLocationName;
    }

    @Override
    public String getOriginName() {
        return mOriginName;
    }
}
