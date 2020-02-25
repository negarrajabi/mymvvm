package com.testapp.test;



import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private addressModel addresses;
    onItemInterface mListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<addressModel> address = new ArrayList<>();

        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);


        addressModel add;
        for (int i = 0; i < 20; i++) {
            add=new addressModel();
            add.setId("user id "+ i);
            add.setAddress("user address="+i);
            add.setName("username="+i);
            address.add(add);


        }
        // define an adapter
        mAdapter = new MyAdapter(this,address);
        mAdapter.setItemClickListener(mListener);
        recyclerView.setAdapter(mAdapter);




    }

}