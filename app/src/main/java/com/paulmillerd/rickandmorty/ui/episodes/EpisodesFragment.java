package com.paulmillerd.rickandmorty.ui.episodes;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paulmillerd.rickandmorty.R;
import com.paulmillerd.rickandmorty.RickAndMortyApp;
import com.paulmillerd.rickandmorty.repository.IEpisodeRepository;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class EpisodesFragment extends Fragment {

    @Inject
    IEpisodeRepository mEpisodeRepository;

    @BindView(R.id.episodes_recycler_view)
    RecyclerView mRecyclerView;

    private IEpisodesViewModel mViewModel;
    private EpisodesAdapter mEpisodesAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.episodes_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            RickAndMortyApp.getAppComponent(getActivity()).inject(this);

            mViewModel = ViewModelProviders.of(this).get(EpisodesViewModel.class);
            mViewModel.initialize(mEpisodeRepository);

            mEpisodesAdapter = new EpisodesAdapter(mViewModel);
            mRecyclerView.setAdapter(mEpisodesAdapter);

            mViewModel.getAllEpisodes().observe(this,
                    episodes -> mEpisodesAdapter.submitList(episodes));

            mViewModel.getClickedEpisode().observe(this,
                    clickedEpisode -> Log.d("EpisodeClickLogs", "clicked on: " + clickedEpisode.getName()));
        }
    }

}
