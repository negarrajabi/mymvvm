package com.testapp.test.view;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.testapp.model.User;
import com.testapp.test.R;
import com.testapp.test.databinding.ActivityMain2Binding;
import com.testapp.viewModel.UserViewModel;

public class Main2Activity extends Activity {
    User user;
    String s1, s2, s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //set clicked user info
        user = new User(getIntent().getStringExtra("name"), getIntent().getStringExtra("phone"), getIntent().getStringExtra("address"));
        ActivityMain2Binding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main2, null);
        UserViewModel userViewModel = new UserViewModel(user);
        activityMainBinding.setUser(userViewModel);

    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("username", s1);
        intent.putExtra("address", s2);
        intent.putExtra("phone", s3);
        setResult(RESULT_OK, intent);
        super.finish();
    }
}
