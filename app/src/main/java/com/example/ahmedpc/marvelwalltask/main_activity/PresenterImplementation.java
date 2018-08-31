package com.example.ahmedpc.marvelwalltask.main_activity;

import com.example.ahmedpc.marvelwalltask.model.User;

import java.util.ArrayList;

/**
 * Created by ahmedpc on 24/4/2018.
 */

public class PresenterImplementation implements MainPresenter,GetUsersIntractor.OnFinishedListener {
    private MainView mainView ;;
    private GetUsersIntractor usersIntractor;

    public PresenterImplementation(MainView mainView,GetUsersIntractor usersIntractor){
        this.mainView = mainView;
        this.usersIntractor = usersIntractor;
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void requestDataFromServer() {
        mainView.showProgress();
        usersIntractor.getNoticeArrayList(this);
    }

    @Override
    public void onFinished(ArrayList<User> usersArrayList) {
        if(mainView != null){
            mainView.setDataToRecyclerView(usersArrayList);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}
