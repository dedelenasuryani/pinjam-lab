package com.example.android2.peminjamanlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UbahActivity extends AppCompatActivity {


    private ApiClient apiClient;
    private ApiInterface apiInterface;
    private PeminjamanLab peminjamanLab;
    private Button save, del,cancel;
    private EditText namaP, jabatan, kd,namaB,ruang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah);

        namaP= (EditText) findViewById(R.id.edit_namapeminjam_ubah);
        jabatan = (EditText) findViewById(R.id.edit_jabatan_ubah);
        kd = (EditText) findViewById(R.id.edit_kode_ubah);
        namaB= (EditText) findViewById(R.id.edit_namaBarang_ubah);
        ruang= (EditText) findViewById(R.id.edit_ruang_ubah);


        Intent koper = getIntent();
        String ids = koper.getStringExtra("id");
        final long id = Long.parseLong(ids);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        final Call<PeminjamanLab> call = apiInterface.getPeminjamanLabById(id);
        call.enqueue(new Callback<PeminjamanLab>() {
            @Override
            public void onResponse(Call<PeminjamanLab> call, Response<PeminjamanLab> response) {
                peminjamanLab = response.body();
                namaP.setText(peminjamanLab.getNamaPeminjam());
                jabatan.setText(peminjamanLab.getJabatan());
                kd.setText(peminjamanLab.getKodeBarang());
                namaB.setText(peminjamanLab.getNamaBarang());
                ruang.setText(peminjamanLab.getRuangLab());

            }

            @Override
            public void onFailure(Call<PeminjamanLab> call, Throwable t) {

            }
        });
        save = (Button) findViewById(R.id.btn_save_ubah);
      save.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String namaPnya=namaP.getText().toString().trim();
              String jabatannya=jabatan.getText().toString().trim();
              String kdnya=kd.getText().toString().trim();
              String namaBnya=namaB.getText().toString().trim();
              String ruangnya=ruang.getText().toString().trim();

              peminjamanLab=new PeminjamanLab(namaPnya,jabatannya,kdnya,namaBnya,ruangnya);
              Call<PeminjamanLab>call1=apiInterface.updatePeminjamanLab(id,peminjamanLab);
              call1.enqueue(new Callback<PeminjamanLab>() {
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
      del = (Button) findViewById(R.id.btn_delete_ubah);
      del.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Call<PeminjamanLab>call1=apiInterface.deletePeminjamanLab(id);
              call1.enqueue(new Callback<PeminjamanLab>() {
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
      cancel = (Button) findViewById(R.id.btn_cancel_ubah);
      cancel.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              finish();
          }
      });
    }
}
