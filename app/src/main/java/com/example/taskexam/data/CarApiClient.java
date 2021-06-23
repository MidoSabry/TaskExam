package com.example.taskexam.data;

import com.example.taskexam.Pojos.Car;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarApiClient {
    private static final String BASE_URL="https://demo1585915.mockable.io/api/v1/";
    private ApiInterface apiInterface;
    private static CarApiClient INSTANCE;

    public  CarApiClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);

    }

    public static CarApiClient getINSTANCE() {
        if(null == INSTANCE){
            INSTANCE = new CarApiClient();
        }
        return INSTANCE;
    }

    public Call<List<Car>> getCars(){
        return apiInterface.getCars("1");
    }
}
