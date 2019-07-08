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

    private TextView mCharacterNameTextView, mCharacterStatusTextView;
    private NetworkImageView mCharacterImageView;
    private ImageLoader mImageLoader;
    private OnCharacterClickedListener mOnCharacterClickedListener;

    private CharacterListViewHolder(@NonNull View itemView, ImageLoader imageLoader,
                                    OnCharacterClickedListener onCharacterClickedListener) {
        super(itemView);
        mCharacterNameTextView = itemView.findViewById(R.id.character_name_text_view);
        mCharacterImageView = itemView.findViewById(R.id.character_image_view);
        mCharacterImageView.setDefaultImageResId(android.R.drawable.gallery_thumb);
        mCharacterStatusTextView = itemView.findViewById(R.id.character_status_text_view);
        mImageLoader = imageLoader;
        mOnCharacterClickedListener = onCharacterClickedListener;
    }

    public static CharacterListViewHolder create(ViewGroup parent, ImageLoader imageLoader,
                                                 OnCharacterClickedListener onCharacterClickedListener) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_list_view_holder_layout, parent, false);
        return new CharacterListViewHolder(view, imageLoader, onCharacterClickedListener);
    }

    void bindView(ICharacter character) {
        itemView.setOnClickListener(v -> mOnCharacterClickedListener.onCharacterClicked(character));
        mCharacterImageView.setImageUrl(character.getImage(), mImageLoader);
        mCharacterNameTextView.setText(character.getName());
        mCharacterStatusTextView.setText(String.format(
                itemView.getContext().getString(R.string.status),
                character.getStatus()
        ));
    }

}
