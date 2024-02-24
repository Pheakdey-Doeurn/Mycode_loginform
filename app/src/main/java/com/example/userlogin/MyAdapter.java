package com.example.userlogin;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    ArrayList<User> userList;
    Activity myContent;
    public MyAdapter(ArrayList<User> userList,Activity myContent){
        this.userList = userList;
        this.myContent = myContent;
    }
    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v==null){
            LayoutInflater layoutInflater=myContent.getLayoutInflater();
            v=layoutInflater.inflate(R.layout.single_row,null);
        }
        TextView txtUsername = v.findViewById(R.id.txtUsername);
        TextView txtpass = v.findViewById(R.id.txtpass);

        User U = userList.get(i);

        txtUsername.setText(U.getUsername());
        txtpass.setText(U.getPassword());

        return v;
    }
}
