package com.example.simplenodejsapiwithnativeandroidapp.di;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Users {

    @GET("users")
    Call<List<String>> getCall();

}
