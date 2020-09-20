package com.menu.assignment.retrofitdemo.network;

import com.menu.assignment.retrofitdemo.model.Image;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    //define base url
    public static String  BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Image>> getImages();
}
