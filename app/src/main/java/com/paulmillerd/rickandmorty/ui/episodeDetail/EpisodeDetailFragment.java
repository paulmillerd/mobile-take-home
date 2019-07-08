package com.paulmillerd.rickandmorty.ui.episodeDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.paulmillerd.rickandmorty.R;
import com.paulmillerd.rickandmorty.RickAndMortyApp;
import com.paulmillerd.rickandmorty.model.IEpisode;
import com.paulmillerd.rickandmorty.repository.ICharacterDetailRepository;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EpisodeDetailFragment extends Fragment {

    private final static String EPISODE = "EPISODE";
    @Inject
    ICharacterDetailRepository mCharacterDetailRepository;
    @Inject
    ImageLoader mImageLoader;
    private TextView mEpisodeNameTextView, mEpisodeEpisodeTextView, mEpisodeAirDateTextView;
    private RecyclerView mCharactersRecyclerView;
    private IEpisodeDetailViewModel mViewModel;
    private CharacterListAdapter mCharacterListAdapter = new CharacterListAdapter(mImageLoader);
    private Toolbar mToolbar;

    public static EpisodeDetailFragment newInstance(IEpisode episode) {
        Bundle args = new Bundle();
        args.putSerializable(EPISODE, episode);

        EpisodeDetailFragment fragment = new EpisodeDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.episode_detail_layout, container, false);

        mEpisodeNameTextView = view.findViewById(R.id.episode_name_text_view);
        mEpisodeAirDateTextView = view.findViewById(R.id.episode_air_date_text_view);
        mEpisodeEpisodeTextView = view.findViewById(R.id.episode_episode_text_view);
        mCharactersRecyclerView = view.findViewById(R.id.characters_recycler_view);
        mToolbar = view.findViewById(R.id.toolbar);

        mCharactersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mCharactersRecyclerView.addItemDecoration(new DividerItemDecoration(
                mCharactersRecyclerView.getContext(),
                DividerItemDecoration.VERTICAL
        ));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            RickAndMortyApp.getAppComponent(getActivity()).inject(this);

            mToolbar.setNavigationOnClickListener(v -> {
                getActivity().onBackPressed();
            });

            mCharacterListAdapter = new CharacterListAdapter(mImageLoader);
            mCharactersRecyclerView.setAdapter(mCharacterListAdapter);

            mViewModel = ViewModelProviders.of(this).get(EpisodeDetailViewModel.class);
            if (getArguments() != null) {
                mViewModel.initialize((IEpisode) getArguments().getSerializable(EPISODE),
                        mCharacterDetailRepository);
            }

            mViewModel.getCharacters().observe(this, iCharacters -> {
                mCharacterListAdapter.submitList(iCharacters);
            });

            mViewModel.getEpisode().observe(this, episode -> {
                mEpisodeNameTextView.setText(episode.getName());
                mEpisodeEpisodeTextView.setText(episode.getEpisode());
                mEpisodeAirDateTextView.setText(String.format(
                        getActivity().getString(R.string.air_date),
                        episode.getAirDate()
                ));
            });
        }
    }

}
