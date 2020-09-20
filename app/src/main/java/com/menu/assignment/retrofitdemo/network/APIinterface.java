package com.menu.assignment.retrofitdemo.network;

import com.menu.assignment.retrofitdemo.model.Image;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {
    @GET("marvel")
    Call<List<Image>> getImages();
}
