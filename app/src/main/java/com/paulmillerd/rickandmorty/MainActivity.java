package com.paulmillerd.rickandmorty;

import android.os.Bundle;

import com.paulmillerd.rickandmorty.model.ICharacter;
import com.paulmillerd.rickandmorty.model.IEpisode;
import com.paulmillerd.rickandmorty.ui.CharacterDisplayer;
import com.paulmillerd.rickandmorty.ui.EpisodeDisplayer;
import com.paulmillerd.rickandmorty.ui.characterDetail.CharacterDetailFragment;
import com.paulmillerd.rickandmorty.ui.episodeDetail.EpisodeDetailFragment;
import com.paulmillerd.rickandmorty.ui.episodes.EpisodesFragment;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements EpisodeDisplayer, CharacterDisplayer {

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
        episodeDetailFragment.setCharacterDisplayer(this);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.content_frame, episodeDetailFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void displayCharacter(ICharacter character) {
        CharacterDetailFragment characterDetailFragment = CharacterDetailFragment.newInstance(character);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.content_frame, characterDetailFragment)
                .addToBackStack(null)
                .commit();
    }
}
