package com.example.android2.peminjamanlab;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by android2 on 07/03/18.
 */

public class ApiClient {

    public static final String BASE_URL="http://192.168.0.19:8080" ;
    public static Retrofit retrofit;

    public static Retrofit getApiClient(){
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }
}
