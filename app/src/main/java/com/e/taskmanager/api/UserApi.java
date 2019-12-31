package com.e.taskmanager.api;

import com.e.taskmanager.Modern.Users;
import com.e.taskmanager.serverresponse.ImageResponse;
import com.e.taskmanager.serverresponse.SignUpResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UserApi {

    @POST("users/signup")
    Call<SignUpResponse> registerUser(@Body Users users);

    @FormUrlEncoded
    @POST("users/login")
    Call<SignUpResponse>checkUser(@Field("username") String username, @Field("password")String password);

    @Multipart
    @POST("upload")
    Call<ImageResponse>uploadImage(@Part MultipartBody.Part img);
}