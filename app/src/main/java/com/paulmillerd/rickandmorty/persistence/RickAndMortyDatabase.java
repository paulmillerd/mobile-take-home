package com.paulmillerd.rickandmorty.persistence;

import com.paulmillerd.rickandmorty.persistence.dao.EpisodeDao;
import com.paulmillerd.rickandmorty.persistence.entities.EpisodeEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {EpisodeEntity.class}, version = 1, exportSchema = false)
public abstract class RickAndMortyDatabase extends RoomDatabase {
    abstract EpisodeDao episodeDao();
}
