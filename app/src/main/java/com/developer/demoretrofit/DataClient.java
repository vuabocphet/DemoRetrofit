package com.developer.demoretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataClient {

    @GET("/api/users")
    Call<Question> getAll() ;


    @POST("/api/users")
    Call<User> createUser(@Body User user);


    @FormUrlEncoded
    @POST("/api/login")
    Call<LoginUser> login(@Field("email")String email,@Field("password")String password);



}
