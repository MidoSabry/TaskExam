package com.example.taskexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.taskexam.Pojos.Car;
import com.example.taskexam.ui.CarAdapter;
import com.example.taskexam.ui.CarViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    CarViewModel carViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carViewModel = ViewModelProviders.of(this).get(CarViewModel.class);

        carViewModel.getCars();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        CarAdapter adapter = new CarAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        carViewModel.carMutableLiveData.observe(this, new Observer<List<Car>>() {
            @Override
            public void onChanged(List<Car> cars) {
                adapter.setList(cars);
            }
        });




    }
}