package com.paulmillerd.rickandmorty.ui.episodes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.paulmillerd.rickandmorty.R;
import com.paulmillerd.rickandmorty.model.IEpisode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class EpisodesViewHolder extends RecyclerView.ViewHolder {

    private TextView mEpisodeNameTextView, mEpisodeAirDateTextView, mEpisodeEpisodeTextView;
    private OnEpisodeClickedListener mOnEpisodeClickedListener;

    private EpisodesViewHolder(@NonNull View itemView, OnEpisodeClickedListener onEpisodeClickedListener) {
        super(itemView);
        mEpisodeNameTextView = itemView.findViewById(R.id.episode_name_text_view);
        mEpisodeAirDateTextView = itemView.findViewById(R.id.episode_air_date_text_view);
        mEpisodeEpisodeTextView = itemView.findViewById(R.id.episode_episode_text_view);
        mOnEpisodeClickedListener = onEpisodeClickedListener;
    }

    public static EpisodesViewHolder create(ViewGroup parent,
                                            OnEpisodeClickedListener onEpisodeClickedListener) {
        return new EpisodesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.episodes_view_holder_layout, parent, false),
                onEpisodeClickedListener);
    }

    void bindItem(@Nullable IEpisode episode) {
        if (episode != null) {
            mEpisodeNameTextView.setText(episode.getName());
            mEpisodeAirDateTextView.setText(String.format(itemView.getContext().getString(R.string.air_date),
                    episode.getAirDate()));
            mEpisodeEpisodeTextView.setText(episode.getEpisode());
            itemView.setOnClickListener(v -> mOnEpisodeClickedListener.onEpisodeClicked(episode));
        }
    }

}
