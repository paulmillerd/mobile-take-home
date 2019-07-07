package com.paulmillerd.rickandmorty.ui.episodes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.paulmillerd.rickandmorty.R;
import com.paulmillerd.rickandmorty.model.Episode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class EpisodesViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.episode_name_text_view)
    TextView episodeNameTextView;

    @BindView(R.id.episode_air_date_text_view)
    TextView episodeAirDateTextView;

    @BindView(R.id.episode_episode_text_view)
    TextView episodeEpisodeTextView;

    private OnEpisodeClickedListener mOnEpisodeClickedListener;

    private EpisodesViewHolder(@NonNull View itemView, OnEpisodeClickedListener onEpisodeClickedListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mOnEpisodeClickedListener = onEpisodeClickedListener;
    }

    public static EpisodesViewHolder create(ViewGroup parent, OnEpisodeClickedListener onEpisodeClickedListener) {
        return new EpisodesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.episodes_view_holder_layout, parent, false),
                onEpisodeClickedListener);
    }

    void bindItem(@Nullable Episode episode) {
        if (episode != null) {
            episodeNameTextView.setText(episode.getName());
            episodeAirDateTextView.setText(episode.getAirDate());
            episodeEpisodeTextView.setText(episode.getEpisode());
            itemView.setOnClickListener(v -> mOnEpisodeClickedListener.onEpisodeClicked(episode));
        }
    }

}
