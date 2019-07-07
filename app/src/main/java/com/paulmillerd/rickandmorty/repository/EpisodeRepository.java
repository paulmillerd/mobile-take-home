package com.paulmillerd.rickandmorty.repository;

import com.paulmillerd.rickandmorty.model.Episode;
import com.paulmillerd.rickandmorty.rickAndMortyApi.IRickAndMortyService;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

public class EpisodeRepository implements IEpisodeRepository {

    private IRickAndMortyService mRickAndMortyService;

    public EpisodeRepository(IRickAndMortyService rickAndMortyService) {
        mRickAndMortyService = rickAndMortyService;
    }

    @Override
    public LiveData<PagedList<Episode>> getAllEpisodes() {
        return new LivePagedListBuilder<>(
                new DataSource.Factory<Integer, Episode>() {
                    @NonNull
                    @Override
                    public DataSource<Integer, Episode> create() {
                        return new PageKeyedDataSource<Integer, Episode>() {

                            @Override
                            public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Episode> callback) {
                                fetchPage(1, callback, null);
                            }

                            @Override
                            public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Episode> callback) {
                                fetchPage(params.key, null, callback);
                            }

                            @Override
                            public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Episode> callback) {
                                fetchPage(params.key, null, callback);
                            }

                        };
                    }
                },
                10
        ).build();
    }

    private void fetchPage(int page, @Nullable PageKeyedDataSource.LoadInitialCallback<Integer, Episode> initialCallback, @Nullable PageKeyedDataSource.LoadCallback<Integer, Episode> callback) {
        mRickAndMortyService.getEpisodesPage(page, new IRickAndMortyService.EpisodePageCallback() {
            @Override
            public void onPageLoaded(List<Episode> episodeList, int totalEpisodeCount) {
                if (initialCallback != null) {
                    initialCallback.onResult(episodeList, 0, totalEpisodeCount, null, page + 1);
                } else if (callback != null) {
                    callback.onResult(episodeList, page + 1);
                }
            }

            @Override
            public void onFailure() {
                // TODO fail gracefully
            }
        });
    }

}
