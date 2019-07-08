package com.paulmillerd.rickandmorty.ui.episodes;

import android.view.ViewGroup;

import com.paulmillerd.rickandmorty.model.IEpisode;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

public class EpisodesAdapter extends PagedListAdapter<IEpisode, EpisodesViewHolder> {

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

    private static class EpisodesDiffer extends DiffUtil.ItemCallback<IEpisode> {

        @Override
        public boolean areItemsTheSame(@NonNull IEpisode oldItem, @NonNull IEpisode newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull IEpisode oldItem, @NonNull IEpisode newItem) {
            return oldItem.getAirDate().equals(newItem.getAirDate())
                    && oldItem.getName().equals(newItem.getName())
                    && oldItem.getEpisode().equals(newItem.getEpisode());
        }

    }

}
