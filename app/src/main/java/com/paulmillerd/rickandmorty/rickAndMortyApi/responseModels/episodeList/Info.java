package com.paulmillerd.rickandmorty.rickAndMortyApi.responseModels.episodeList;

import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("next")
    private String next;

    @SerializedName("pages")
    private int pages;

    @SerializedName("prev")
    private String prev;

    @SerializedName("count")
    private int count;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return
                "Info{" +
                        "next = '" + next + '\'' +
                        ",pages = '" + pages + '\'' +
                        ",prev = '" + prev + '\'' +
                        ",count = '" + count + '\'' +
                        "}";
    }
}