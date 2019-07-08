package com.paulmillerd.rickandmorty.rickAndMortyApi.responseModels.episodeList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultsItem {

    @SerializedName("air_date")
    private String airDate;

    @SerializedName("characters")
    private List<String> characters;

    @SerializedName("created")
    private String created;

    @SerializedName("name")
    private String name;

    @SerializedName("episode")
    private String episode;

    @SerializedName("id")
    private int id;

    @SerializedName("url")
    private String url;

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return
                "ResultsItem{" +
                        "air_date = '" + airDate + '\'' +
                        ",characters = '" + characters + '\'' +
                        ",created = '" + created + '\'' +
                        ",name = '" + name + '\'' +
                        ",episode = '" + episode + '\'' +
                        ",id = '" + id + '\'' +
                        ",url = '" + url + '\'' +
                        "}";
    }
}