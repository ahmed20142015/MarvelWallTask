package com.example.ahmedpc.marvelwalltask.network;

import com.example.ahmedpc.marvelwalltask.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ahmedpc on 24/4/2018.
 */

public interface GetDataService {
    @GET("posts")
    Call<List<User>> getUsers();

}
