package com.example.taskexam.data;

import com.example.taskexam.Pojos.Car;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("cars?page=1")
    public Call<List<Car>> getCars();
}
