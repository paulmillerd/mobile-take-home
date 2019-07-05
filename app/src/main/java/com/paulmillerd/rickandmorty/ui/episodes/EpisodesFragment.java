package com.paulmillerd.rickandmorty.ui.episodes;

import com.paulmillerd.rickandmorty.R;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class EpisodesFragment extends Fragment {

    @BindView(R.id.episodes_recycler_view)
    RecyclerView mRecyclerView;

}
