package com.example.ahmedpc.marvelwalltask.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmedpc.marvelwalltask.R;
import com.example.ahmedpc.marvelwalltask.model.User;

import java.util.ArrayList;

/**
 * Created by ahmedpc on 24/4/2018.
 */

public class UsersAdapter  extends RecyclerView.Adapter<UsersAdapter.ViewHolder>   {

    Context context;
    ArrayList<User> users;
    LayoutInflater inflater;


    public UsersAdapter (Context context,ArrayList<User> users){
        this.context = context;
        this.users = users;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public UsersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.user_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(UsersAdapter.ViewHolder holder, int position) {
        User user = users.get(position);
        holder.id.setText(user.getUserId()+"");
        holder.userId.setText(user.getId()+"");
        holder.userBody.setText(user.getBody());
        holder.userTitle.setText(user.getTitle());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView id,userId,userTitle,userBody;

        public ViewHolder(View itemView) {

            super(itemView);
            id =  itemView.findViewById(R.id._id);
            userId =  itemView.findViewById(R.id.user_id);
            userTitle =  itemView.findViewById(R.id.user_title);
            userBody =  itemView.findViewById(R.id.user_body);

            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {


        }
    }


}