package com.paulmillerd.rickandmorty.rickAndMortyApi;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.paulmillerd.rickandmorty.model.Character;
import com.paulmillerd.rickandmorty.model.Episode;
import com.paulmillerd.rickandmorty.model.ICharacter;
import com.paulmillerd.rickandmorty.model.IEpisode;
import com.paulmillerd.rickandmorty.rickAndMortyApi.responseModels.characterDetail.CharacterDetailResponse;
import com.paulmillerd.rickandmorty.rickAndMortyApi.responseModels.episodeList.Response;
import com.paulmillerd.rickandmorty.rickAndMortyApi.responseModels.episodeList.ResultsItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.android.volley.Request.Method.GET;

public class RickAndMortyService implements IRickAndMortyService {

    private static final String BASE_URL = "https://rickandmortyapi.com/api";

    private RequestQueue mRequestQueue;
    private Gson mGson = new Gson();

    @Inject
    public RickAndMortyService(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    @Override
    public void getEpisodesPage(int page, EpisodePageCallback callback) {
        JsonObjectRequest request = new JsonObjectRequest(GET, BASE_URL + "/episode/?page=" + page, null,
                response -> {
                    Response episodeListResponse = mGson.fromJson(response.toString(), Response.class);
                    List<IEpisode> episodeList = buildEpisodeList(episodeListResponse.getResults());
                    int totalEpisodeCount = episodeListResponse.getInfo().getCount();
                    callback.onPageLoaded(episodeList, totalEpisodeCount);
                },
                error -> {
                    callback.onFailure();
                });
        mRequestQueue.add(request);
    }

    @Override
    public void getEpisodeDetail(int id, EpisodeDetailCallback callback) {
        JsonObjectRequest request = new JsonObjectRequest(GET, BASE_URL + "/episode/" + id, null,
                response -> {
                    ResultsItem episodeDetailResponse = mGson.fromJson(response.toString(), ResultsItem.class);
                    IEpisode episode = resultToEpisode(episodeDetailResponse);
                    callback.onDetailLoaded(episode);
                },
                error -> {
                    callback.onFailure();
                });
        mRequestQueue.add(request);
    }

    @Override
    public void getCharacterDetail(String url, CharacterDetailCallback callback) {
        JsonObjectRequest request = new JsonObjectRequest(GET, url, null,
                response -> {
                    CharacterDetailResponse characterDetailResponse = mGson.fromJson(response.toString(), CharacterDetailResponse.class);
                    ICharacter character = characterFromResponse(characterDetailResponse);
                    callback.onDetailLoaded(character);
                },
                error -> {
                    callback.onFailure();
                });
        mRequestQueue.add(request);
    }

    @Override
    public void getCharacterDetail(int id, CharacterDetailCallback callback) {
        getCharacterDetail(BASE_URL + "/character/" + id, callback);
    }

    private List<IEpisode> buildEpisodeList(List<ResultsItem> results) {
        ArrayList<IEpisode> episodeList = new ArrayList<>();
        for (ResultsItem result : results) {
            episodeList.add(resultToEpisode(result));
        }
        return episodeList;
    }

    private IEpisode resultToEpisode(ResultsItem result) {
        ArrayList<Integer> characterIds = new ArrayList<>();

        for (String characterUrl : result.getCharacters()) {
            int indexOfLastSlash = characterUrl.lastIndexOf('/');
            try {
                Integer characterId = Integer.parseInt(characterUrl.substring(indexOfLastSlash + 1));
                characterIds.add(characterId);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return new Episode(result.getId(), result.getName(), result.getAirDate(),
                result.getEpisode(), characterIds);
    }

    private ICharacter characterFromResponse(CharacterDetailResponse response) {
        return new Character(
                response.getId(),
                response.getName(),
                response.getImage(),
                response.getStatus(),
                response.getSpecies(),
                response.getLocation().getName(),
                response.getOrigin().getName()
        );
    }

}
