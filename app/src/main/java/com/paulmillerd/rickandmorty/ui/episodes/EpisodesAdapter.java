package com.paulmillerd.rickandmorty.ui.episodes;

import android.view.ViewGroup;

import com.paulmillerd.rickandmorty.model.Episode;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

public class EpisodesAdapter extends PagedListAdapter<Episode, EpisodesViewHolder> {

    private OnEpisodeClickedListener mOnEpisodeClickedListener;

    EpisodesAdapter(OnEpisodeClickedListener onEpisodeClickedListener) {
        super(new EpisodesDiffer());
        mOnEpisodeClickedListener = onEpisodeClickedListener;
    }

    @NonNull
    @Override
    public EpisodesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return EpisodesViewHolder.create(parent, mOnEpisodeClickedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodesViewHolder holder, int position) {
        holder.bindItem(getItem(position));
    }

    private static class EpisodesDiffer extends DiffUtil.ItemCallback<Episode> {

        @Override
        public boolean areItemsTheSame(@NonNull Episode oldItem, @NonNull Episode newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Episode oldItem, @NonNull Episode newItem) {
            return oldItem.getAirDate().equals(newItem.getAirDate())
                    && oldItem.getName().equals(newItem.getName())
                    && oldItem.getEpisode().equals(newItem.getEpisode());
        }

    }

}
