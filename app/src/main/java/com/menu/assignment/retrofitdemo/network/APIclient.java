package com.menu.assignment.retrofitdemo.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIclient {

    //define base url
    public static String  BASE_URL = "https://simplifiedcoding.net/demos/";

    //retrofit
    public static Retrofit getClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static APIinterface apIinterface(){
        return getClient().create(APIinterface.class);
    }
}
