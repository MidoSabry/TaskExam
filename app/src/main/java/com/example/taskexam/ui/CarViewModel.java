package com.example.taskexam.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taskexam.Pojos.Car;
import com.example.taskexam.data.CarApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarViewModel extends ViewModel {
    public MutableLiveData<List<Car>>carMutableLiveData = new MutableLiveData<>();

    public void getCars(){
        CarApiClient.getINSTANCE().getCars().enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                carMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {

            }
        });
    }
}
