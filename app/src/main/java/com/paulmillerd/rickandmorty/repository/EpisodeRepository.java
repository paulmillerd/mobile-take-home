package com.paulmillerd.rickandmorty.repository;

import com.paulmillerd.rickandmorty.model.IEpisode;
import com.paulmillerd.rickandmorty.rickAndMortyApi.IRickAndMortyService;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
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
    public LiveData<PagedList<IEpisode>> getAllEpisodes() {
        return new LivePagedListBuilder<>(
                new DataSource.Factory<Integer, IEpisode>() {
                    @NonNull
                    @Override
                    public DataSource<Integer, IEpisode> create() {
                        return new PageKeyedDataSource<Integer, IEpisode>() {

                            @Override
                            public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, IEpisode> callback) {
                                fetchPage(1, callback, null);
                            }

                            @Override
                            public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, IEpisode> callback) {
                                fetchPage(params.key, null, callback);
                            }

                            @Override
                            public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, IEpisode> callback) {
                                fetchPage(params.key, null, callback);
                            }

                        };
                    }
                },
                10
        ).build();
    }

    @Override
    public LiveData<IEpisode> getEpisodeDetail(int id) {
        MutableLiveData<IEpisode> episodeLiveData = new MutableLiveData<>();

        mRickAndMortyService.getEpisodeDetail(id, new IRickAndMortyService.EpisodeDetailCallback() {
            @Override
            public void onDetailLoaded(IEpisode episode) {
                episodeLiveData.postValue(episode);
            }

            @Override
            public void onFailure() {
                // Fail gracefully
            }
        });

        return episodeLiveData;
    }

    private void fetchPage(int page, @Nullable PageKeyedDataSource.LoadInitialCallback<Integer, IEpisode> initialCallback, @Nullable PageKeyedDataSource.LoadCallback<Integer, IEpisode> callback) {
        mRickAndMortyService.getEpisodesPage(page, new IRickAndMortyService.EpisodePageCallback() {
            @Override
            public void onPageLoaded(List<IEpisode> episodeList, int totalEpisodeCount) {
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
