package com.prelimprojectdc.dupamidterm.api;

import com.prelimprojectdc.dupamidterm.pojos.Login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RequestPlaceholder {

    @POST("login")
    Call<Login> login(@Body Login login);

}
