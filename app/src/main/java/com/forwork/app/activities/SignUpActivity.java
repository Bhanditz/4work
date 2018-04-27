package com.forwork.app.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.forwork.app.R;

public class SignUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        configure();
    }

    private void configure() {
        String email = getIntent().getStringExtra("email");
        if (!TextUtils.isEmpty(email)) {

        }
    }
}