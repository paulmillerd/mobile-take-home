package com.paulmillerd.rickandmorty.ui.episodeDetail;

import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;
import com.paulmillerd.rickandmorty.killing.ICharacterKiller;
import com.paulmillerd.rickandmorty.model.ICharacter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class CharacterListAdapter extends ListAdapter<ICharacter, CharacterListViewHolder> {

    private ImageLoader mImageLoader;
    private OnCharacterClickedListener mOnCharacterClickedListener;
    private ICharacterKiller mCharacterKiller;

    CharacterListAdapter(ImageLoader imageLoader, OnCharacterClickedListener onCharacterClickedListener,
                         ICharacterKiller characterKiller) {
        super(new CharacterDiffer());
        mImageLoader = imageLoader;
        mOnCharacterClickedListener = onCharacterClickedListener;
        mCharacterKiller = characterKiller;
    }

    @NonNull
    @Override
    public CharacterListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return CharacterListViewHolder.create(parent, mImageLoader, mOnCharacterClickedListener, mCharacterKiller);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterListViewHolder holder, int position) {
        holder.bindView(getItem(position));
    }

    private static class CharacterDiffer extends DiffUtil.ItemCallback<ICharacter> {

        @Override
        public boolean areItemsTheSame(@NonNull ICharacter oldItem, @NonNull ICharacter newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull ICharacter oldItem, @NonNull ICharacter newItem) {
            return oldItem.getId() == newItem.getId()
                    && oldItem.getName().equals(newItem.getName())
                    && oldItem.getImage().equals(newItem.getImage())
                    && oldItem.getStatus().equals(newItem.getStatus());
        }

    }

}
