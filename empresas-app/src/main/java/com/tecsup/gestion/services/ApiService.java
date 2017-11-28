package com.tecsup.gestion.services;

import java.util.List;

import com.tecsup.gestion.model.Usuario;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
	
	String API_BASE_URL = "https://empresas-app-mrpapita.c9users.io/";

    @GET("api/v1/loginUsers")
    Call<List<Usuario>> getUsers();

    @FormUrlEncoded
    @POST("api/v1/login")
    Call<Usuario> loginUser
            (@Field("username")String username,
             @Field("password") String password
            );

    @FormUrlEncoded
    @POST("api/v1/register")
    Call<Usuario> createUsuario(@Field("username") String username,
                                        @Field("password") String password,
                                        @Field("fullname") String fullname,
                                        @Field("email") String email);


}
