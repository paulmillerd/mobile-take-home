package com.paulmillerd.rickandmorty.ui.episodeDetail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.paulmillerd.rickandmorty.R;
import com.paulmillerd.rickandmorty.model.ICharacter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class CharacterListViewHolder extends RecyclerView.ViewHolder {

    private TextView mCharacterNameTextView;
    private NetworkImageView mCharacterImageView;
    private ImageLoader mImageLoader;

    private CharacterListViewHolder(@NonNull View itemView, ImageLoader imageLoader) {
        super(itemView);
        mCharacterNameTextView = itemView.findViewById(R.id.character_name_text_view);
        mCharacterImageView = itemView.findViewById(R.id.character_image_view);
        mImageLoader = imageLoader;
    }

    public static CharacterListViewHolder create(ViewGroup parent, ImageLoader imageLoader) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_list_view_holder_layout, parent, false);
        return new CharacterListViewHolder(view, imageLoader);
    }

    void bindView(ICharacter character) {
        mCharacterImageView.setDefaultImageResId(android.R.drawable.gallery_thumb);
        mCharacterImageView.setImageUrl(character.getImage(), mImageLoader);
        mCharacterNameTextView.setText(character.getName());
    }

}