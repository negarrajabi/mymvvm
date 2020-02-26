package com.testapp.test.view;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.testapp.test.R;
import com.testapp.test.databinding.ActivityMainBinding;
import com.testapp.viewModel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main,null);
        UserViewModel userViewModel=new UserViewModel(this);
        activityMainBinding.setUser(userViewModel);


    }

}