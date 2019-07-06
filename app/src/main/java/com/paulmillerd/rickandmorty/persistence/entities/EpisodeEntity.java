package com.paulmillerd.rickandmorty.persistence.entities;

import com.paulmillerd.rickandmorty.model.Episode;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "episodes")
public class EpisodeEntity {

    @PrimaryKey
    @NonNull
    private String id = "";

    private String name, airDate, episode;

    public Episode toEpisode() {
        return new Episode(id, name, airDate, episode);
    }

    @NotNull
    public String getId() {
        return id;
    }

    public void setId(@NotNull String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

}
