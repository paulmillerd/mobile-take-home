package com.paulmillerd.rickandmorty.persistence.dao;

import com.paulmillerd.rickandmorty.persistence.entities.EpisodeEntity;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface EpisodeDao {

    @Insert(onConflict = REPLACE)
    public void save(EpisodeEntity episode);

    @Query("SELECT * FROM episodes WHERE id = :episodeId")
    public LiveData<EpisodeEntity> load(String episodeId);

}
