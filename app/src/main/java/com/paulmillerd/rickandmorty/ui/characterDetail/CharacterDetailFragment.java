package com.paulmillerd.rickandmorty.ui.characterDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.paulmillerd.rickandmorty.R;
import com.paulmillerd.rickandmorty.RickAndMortyApp;
import com.paulmillerd.rickandmorty.model.ICharacter;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class CharacterDetailFragment extends Fragment {

    private static final String CHARACTER = "CHARACTER";

    @Inject
    ImageLoader mImageLoader;

    private NetworkImageView mNetworkImageView;
    private TextView mCharacterNameView, mCharacterStatusView, mCharacterSpeciesView, mCharacterLocationView, mCharacterOriginView;
    private Toolbar mToolbar;

    public static CharacterDetailFragment newInstance(ICharacter character) {
        Bundle args = new Bundle();
        args.putSerializable(CHARACTER, character);

        CharacterDetailFragment fragment = new CharacterDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.character_detail_layout, container, false);

        mNetworkImageView = view.findViewById(R.id.character_image_view);
        mCharacterNameView = view.findViewById(R.id.character_name_text_view);
        mCharacterStatusView = view.findViewById(R.id.character_status_text_view);
        mCharacterSpeciesView = view.findViewById(R.id.character_species_text_view);
        mCharacterLocationView = view.findViewById(R.id.character_location_text_view);
        mCharacterOriginView = view.findViewById(R.id.character_origin_text_view);
        mToolbar = view.findViewById(R.id.toolbar);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            RickAndMortyApp.getAppComponent(getActivity()).inject(this);

            mToolbar.setNavigationOnClickListener(v -> getActivity().onBackPressed());

            Bundle args = getArguments();
            if (args != null) {
                ICharacter character = (ICharacter) args.getSerializable(CHARACTER);
                if (character != null) {
                    mNetworkImageView.setImageUrl(character.getImage(), mImageLoader);
                    mCharacterNameView.setText(character.getName());
                    mCharacterStatusView.setText(String.format(
                            getActivity().getString(R.string.status),
                            character.getStatus()
                    ));
                    mCharacterSpeciesView.setText(String.format(
                            getActivity().getString(R.string.species),
                            character.getSpecies()
                    ));
                    mCharacterLocationView.setText(String.format(
                            getActivity().getString(R.string.location),
                            character.getLocationName()
                    ));
                    mCharacterOriginView.setText(String.format(
                            getActivity().getString(R.string.origin),
                            character.getOriginName()
                    ));
                }
            }
        }
    }
}
