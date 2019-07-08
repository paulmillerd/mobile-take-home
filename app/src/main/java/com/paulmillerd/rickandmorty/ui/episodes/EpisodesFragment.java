package com.paulmillerd.rickandmorty.ui.episodes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paulmillerd.rickandmorty.R;
import com.paulmillerd.rickandmorty.RickAndMortyApp;
import com.paulmillerd.rickandmorty.model.IEpisode;
import com.paulmillerd.rickandmorty.repository.IEpisodeRepository;
import com.paulmillerd.rickandmorty.ui.EpisodeDisplayer;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EpisodesFragment extends Fragment implements OnEpisodeClickedListener {

    @Inject
    IEpisodeRepository mEpisodeRepository;

    private RecyclerView mRecyclerView;
    private EpisodesAdapter mEpisodesAdapter;
    private EpisodeDisplayer mEpisodeDisplayer;

    public void setEpisodeDisplayer(EpisodeDisplayer episodeDisplayer) {
        mEpisodeDisplayer = episodeDisplayer;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.episodes_fragment_layout, container, false);
        mRecyclerView = view.findViewById(R.id.episodes_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            RickAndMortyApp.getAppComponent(getActivity()).inject(this);

            IEpisodesViewModel viewModel = ViewModelProviders.of(this).get(EpisodesViewModel.class);
            viewModel.initialize(mEpisodeRepository);

            mEpisodesAdapter = new EpisodesAdapter(this);
            mRecyclerView.setAdapter(mEpisodesAdapter);

            viewModel.getAllEpisodes().observe(this,
                    episodes -> mEpisodesAdapter.submitList(episodes));
        }
    }

    @Override
    public void onEpisodeClicked(IEpisode episode) {
        if (mEpisodeDisplayer != null) {
            mEpisodeDisplayer.displayEpisode(episode);
        }
    }

}
