package com.example.batikapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("all")
    Call<Hasil>GetBatik();
}
