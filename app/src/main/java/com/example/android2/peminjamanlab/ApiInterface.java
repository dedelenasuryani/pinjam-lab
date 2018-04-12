package com.example.android2.peminjamanlab;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by android2 on 07/03/18.
 */

public interface ApiInterface {

    @GET("api/peminjamanlab2")
    Call<List<PeminjamanLab>> getPeminjamanLab();

    @GET("api/peminjamanlab2/{id}")
    Call<PeminjamanLab> getPeminjamanLabById(@Path("id") long id);

    @POST("api/peminjamanlab2")
    Call<PeminjamanLab> savePeminjamanLab(@Body PeminjamanLab peminjamanLab);

    @PUT("api/peminjamanlab2/{id}")
    Call<PeminjamanLab>  updatePeminjamanLab(@Path("id") long id,@Body PeminjamanLab peminjamanLab);

    @DELETE("api/peminjamanlab2/{id}")
    Call<PeminjamanLab> deletePeminjamanLab(@Path("id") long id);
}
