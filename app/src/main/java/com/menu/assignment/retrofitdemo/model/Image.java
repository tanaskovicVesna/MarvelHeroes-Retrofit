package com.menu.assignment.retrofitdemo.model;

import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;


public class Image {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("realname")
    @Expose
    private String realname;
    @SerializedName("team")
    @Expose
    private String team;
    @SerializedName("firstappearance")
    @Expose
    private String firstappearance;
    @SerializedName("createdby")
    @Expose
    private String createdby;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("imageurl")
    @Expose
    private String link;
    @SerializedName("bio")
    @Expose
    private String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public void setFirstappearance(String firstappearance) {
        this.firstappearance = firstappearance;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

}
