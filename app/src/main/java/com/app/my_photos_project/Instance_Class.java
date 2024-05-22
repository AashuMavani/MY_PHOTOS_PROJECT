package com.app.my_photos_project;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Instance_Class {
    public static Retrofit retrofit;
    public static final String BASEURL="https://jsonplaceholder.typicode.com/";

    public static Retrofit getRetrofit() {
       if (retrofit==null){
           retrofit=new Retrofit.Builder()
                   .baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create())
                   .build();
       }
        return retrofit;
    }
}
