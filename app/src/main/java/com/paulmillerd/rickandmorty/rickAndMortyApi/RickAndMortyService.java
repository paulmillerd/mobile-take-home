package com.paulmillerd.rickandmorty.rickAndMortyApi;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.paulmillerd.rickandmorty.EpisodesQuery;
import com.paulmillerd.rickandmorty.model.Episode;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class RickAndMortyService implements IRickAndMortyService {

    private ApolloClient mApolloClient;

    @Inject
    public RickAndMortyService(ApolloClient apolloClient) {
        mApolloClient = apolloClient;
    }

    @Override
    public void getEpisodesPage(int page, EpisodePageCallback callback) {
        mApolloClient.query(EpisodesQuery.builder()
                .page(page)
                .build())
                .enqueue(new ApolloCall.Callback<EpisodesQuery.Data>() {
                    @Override
                    public void onResponse(@NotNull Response<EpisodesQuery.Data> response) {
                        List<Episode> episodeList;
                        int totalEpisodeCount;

                        try {
                            EpisodesQuery.Episodes episodes = response.data().episodes();
                            episodeList = buildEpisodeList(episodes.results());
                            totalEpisodeCount = episodes.info().count();
                        } catch (NullPointerException e) {
                            callback.onFailure();
                            return;
                        }

                        callback.onPageLoaded(episodeList, totalEpisodeCount);
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        callback.onFailure();
                    }
                });
    }

    private List<Episode> buildEpisodeList(List<EpisodesQuery.Result> results) {
        ArrayList<Episode> episodeList = new ArrayList<>();
        for (EpisodesQuery.Result result : results) {
            episodeList.add(resultToEpisode(result));
        }
        return episodeList;
    }

    private Episode resultToEpisode(EpisodesQuery.Result result) {
        return new Episode(result.id(), result.name(), result.air_date(), result.episode());
    }

}
