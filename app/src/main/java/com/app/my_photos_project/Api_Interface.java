package com.app.my_photos_project;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Interface {
    @GET("photos")
    Call<List<Model>> callinterface();
}
