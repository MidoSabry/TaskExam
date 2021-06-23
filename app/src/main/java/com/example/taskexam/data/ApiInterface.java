package com.example.taskexam.data;

import com.example.taskexam.Pojos.Car;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("cars")
    public Call<List<Car>> getCars(@Query("page")String page);


}
