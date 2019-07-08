package com.paulmillerd.rickandmorty.rickAndMortyApi.responseModels.episodeList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

    @SerializedName("results")
    private List<ResultsItem> results;

    @SerializedName("info")
    private Info info;

    public List<ResultsItem> getResults() {
        return results;
    }

    public void setResults(List<ResultsItem> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return
                "Response{" +
                        "results = '" + results + '\'' +
                        ",info = '" + info + '\'' +
                        "}";
    }
}