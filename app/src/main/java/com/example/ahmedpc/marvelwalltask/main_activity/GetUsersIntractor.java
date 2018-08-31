package com.example.ahmedpc.marvelwalltask.main_activity;

import com.example.ahmedpc.marvelwalltask.model.User;

import java.util.ArrayList;

/**
 * Created by ahmedpc on 24/4/2018.
 */

public interface GetUsersIntractor {
    interface OnFinishedListener {
        void onFinished(ArrayList<User> usersArrayList);
        void onFailure(Throwable t);
    }

    void getNoticeArrayList(OnFinishedListener onFinishedListener);
}
