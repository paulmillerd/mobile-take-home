package com.paulmillerd.rickandmorty;

import android.os.Bundle;

import com.paulmillerd.rickandmorty.model.IEpisode;
import com.paulmillerd.rickandmorty.ui.EpisodeDisplayer;
import com.paulmillerd.rickandmorty.ui.episodeDetail.EpisodeDetailFragment;
import com.paulmillerd.rickandmorty.ui.episodes.EpisodesFragment;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements EpisodeDisplayer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EpisodesFragment episodesFragment = new EpisodesFragment();
        episodesFragment.setEpisodeDisplayer(this);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.content_frame, episodesFragment)
                .commit();
    }

    @Override
    public void displayEpisode(IEpisode episode) {
        EpisodeDetailFragment episodeDetailFragment = EpisodeDetailFragment.newInstance(episode);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.content_frame, episodeDetailFragment)
                .addToBackStack(null)
                .commit();
    }

}
