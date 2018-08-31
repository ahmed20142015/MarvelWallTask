package com.example.ahmedpc.marvelwalltask.main_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.ahmedpc.marvelwalltask.R;
import com.example.ahmedpc.marvelwalltask.adapter.UsersAdapter;
import com.example.ahmedpc.marvelwalltask.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView {
    private ProgressBar progressBar;
    private MainPresenter presenter;
    private RecyclerView usersRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usersRecyclerView = findViewById(R.id.recycler_view_users_list);
        progressBar = findViewById(R.id.progress_lood_users);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        usersRecyclerView.setLayoutManager(layoutManager);

        presenter = new PresenterImplementation(this,new GetUsersInteractorImplement());
        presenter.requestDataFromServer();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setDataToRecyclerView(ArrayList<User> usersArrayList) {
        UsersAdapter adapter = new UsersAdapter(this,usersArrayList);
        usersRecyclerView.setAdapter(adapter);
     }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(MainActivity.this,
                "Something went wrong...Error message: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }

}
