package com.example.android2.peminjamanlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private  PeminjamAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<PeminjamanLab> peminjamnya;
    private ApiInterface apiInterface;
    private Button tombol;
    public static MainActivity utama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.rv);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        utama=this;
        refresh();

    }

    public void refresh() {
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<PeminjamanLab>> call=apiInterface.getPeminjamanLab();
        call.enqueue(new Callback<List<PeminjamanLab>>() {
            @Override
            public void onResponse(Call<List<PeminjamanLab>> call, Response<List<PeminjamanLab>> response) {
               peminjamnya=response.body();
                adapter=new PeminjamAdapter(peminjamnya);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<PeminjamanLab>> call, Throwable t) {

            }
        });
        tombol=(Button)findViewById(R.id.btn_add);
        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,InputActivity.class);
                startActivity(intent);
            }
        });
    }
}
