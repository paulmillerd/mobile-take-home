package com.paulmillerd.rickandmorty.rickAndMortyApi.responseModels.characterDetail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterDetailResponse {

    @SerializedName("image")
    private String image;

    @SerializedName("gender")
    private String gender;

    @SerializedName("species")
    private String species;

    @SerializedName("created")
    private String created;

    @SerializedName("origin")
    private Location origin;

    @SerializedName("name")
    private String name;

    @SerializedName("location")
    private Location location;

    @SerializedName("episode")
    private List<String> episode;

    @SerializedName("id")
    private int id;

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    @SerializedName("status")
    private String status;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Location getOrigin() {
        return origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<String> getEpisode() {
        return episode;
    }

    public void setEpisode(List<String> episode) {
        this.episode = episode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "CharacterDetailResponse{" +
                        "image = '" + image + '\'' +
                        ",gender = '" + gender + '\'' +
                        ",species = '" + species + '\'' +
                        ",created = '" + created + '\'' +
                        ",origin = '" + origin + '\'' +
                        ",name = '" + name + '\'' +
                        ",location = '" + location + '\'' +
                        ",episode = '" + episode + '\'' +
                        ",id = '" + id + '\'' +
                        ",type = '" + type + '\'' +
                        ",url = '" + url + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}