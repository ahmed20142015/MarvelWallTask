package com.example.ahmedpc.marvelwalltask.main_activity;

import com.example.ahmedpc.marvelwalltask.model.User;
import com.example.ahmedpc.marvelwalltask.network.GetDataService;
import com.example.ahmedpc.marvelwalltask.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ahmedpc on 24/4/2018.
 */

public class GetUsersInteractorImplement implements GetUsersIntractor {
    ArrayList<User> users = new ArrayList<>();

    @Override
    public void getNoticeArrayList(final OnFinishedListener onFinishedListener) {
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<User>> call = service.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                users.addAll(response.body());
                onFinishedListener.onFinished(users );
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}


