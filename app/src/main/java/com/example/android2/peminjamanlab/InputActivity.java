package com.example.android2.peminjamanlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InputActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    private ApiClient apiClient;
    private EditText txtnamaP,txtjabatan, txtkd, txtnamaB, txtruang;
    private Button btnsave, btncancel;
    private PeminjamanLab datanya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        txtnamaP=(EditText)findViewById(R.id.edit_namapeminjam_input);
        txtjabatan=(EditText)findViewById(R.id.edit_jabatan_input);
        txtkd=(EditText)findViewById(R.id.edit_kode_input);
        txtnamaB=(EditText)findViewById(R.id.edit_namaBarang_input);
        txtruang=(EditText)findViewById(R.id.edit_ruang_input);
        btnsave=(Button)findViewById(R.id.btn_save);
        btncancel=(Button)findViewById(R.id.btn_cancel);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaPnya=txtnamaP.getText().toString().trim();
                String jabatannya=txtjabatan.getText().toString().trim();
                String kdnya=txtkd.getText().toString().trim();
                String namaBnya=txtnamaB.getText().toString().trim();
                String ruangnya=txtruang.getText().toString().trim();

                datanya=new PeminjamanLab(namaPnya,jabatannya,kdnya,namaBnya,ruangnya);
                apiInterface=ApiClient.getApiClient().create(ApiInterface.class);

                Call<PeminjamanLab> call=apiInterface.savePeminjamanLab(datanya);
                call.enqueue(new Callback<PeminjamanLab>() {
                    @Override
                    public void onResponse(Call<PeminjamanLab> call, Response<PeminjamanLab> response) {
                        MainActivity.utama.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PeminjamanLab> call, Throwable t) {

                    }
                });
            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
