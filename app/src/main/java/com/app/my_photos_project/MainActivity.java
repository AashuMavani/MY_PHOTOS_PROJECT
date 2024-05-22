package com.app.my_photos_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Api_Interface retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        retrofit = Instance_Class.getRetrofit().create(Api_Interface.class);
        retrofit.callinterface().enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response.body().size()>0) {
                    List<Model> classList = response.body();
                    Log.d("AAAAAAAA", "onResponse: "+response.body());
                    Re_Adapter adapter = new Re_Adapter(MainActivity.this, classList);
                    recyclerView.setAdapter(adapter);
//             Toast.makeText(MainActivity.this, "Sucsses", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}