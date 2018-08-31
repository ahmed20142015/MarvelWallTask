package com.example.ahmedpc.marvelwalltask.main_activity;

import com.example.ahmedpc.marvelwalltask.model.User;

import java.util.ArrayList;

/**
 * Created by ahmedpc on 24/4/2018.
 */

public interface MainView {
    void showProgress();

    void hideProgress();

    void setDataToRecyclerView(ArrayList<User> usersArrayList);

    void onResponseFailure(Throwable throwable);
}
