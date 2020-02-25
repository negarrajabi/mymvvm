package com.testapp.test;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends Activity {
        String s1,s2,s3;
        int i;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            final TextView address = findViewById(R.id.addressTextView);
            address.setText(getIntent().getStringExtra("address"));
            final TextView name = findViewById(R.id.nameTextView);
            name.setText(getIntent().getStringExtra("id"));
            final TextView id = findViewById(R.id.idTextView);
            id.setText(getIntent().getStringExtra("username"));
        }

        @Override
        public void finish() {
            Intent intent=new Intent();
            intent.putExtra("username",s1);
            intent.putExtra("address",s2);
            intent.putExtra("id",s3);
            setResult(RESULT_OK,intent);
            super.finish();
        }
    }
