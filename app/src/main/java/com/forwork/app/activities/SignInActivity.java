package com.forwork.app.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.forwork.app.R;
import com.forwork.app.helpers.ValidationHelper;

public class SignInActivity extends AppCompatActivity {
    private TextInputLayout emailTextInputLayout;
    private TextInputEditText emailTextInputEditText;
    private TextInputLayout passwordTextInputLayout;
    private TextInputEditText passwordTextInputEditText;
    private ImageView enterImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        initializeFields();
        configure();
    }

    private void initializeFields() {
        emailTextInputLayout = findViewById(R.id.til_email);
        emailTextInputEditText = findViewById(R.id.tie_email);
        passwordTextInputLayout = findViewById(R.id.til_password);
        passwordTextInputEditText = findViewById(R.id.tie_password);
        enterImageView = findViewById(R.id.ivw_enter);
    }

    private void configure() {
        enterImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validate() {
        if (TextUtils.isEmpty(emailTextInputEditText.getText())) {
            emailTextInputLayout.setError(getString(R.string.msg_empty_field));
            emailTextInputEditText.requestFocus();
            return false;
        } else {
            emailTextInputLayout.setError(null);
        }

        if (!ValidationHelper.isEmailValid(emailTextInputEditText.getText())) {
            emailTextInputLayout.setError(getString(R.string.msg_invalid_email));
            emailTextInputEditText.requestFocus();
            return false;
        } else {
            emailTextInputLayout.setError(null);
        }

        if (TextUtils.isEmpty(passwordTextInputEditText.getText())) {
            passwordTextInputLayout.setError(getString(R.string.msg_empty_field));
            passwordTextInputEditText.requestFocus();
            return false;
        } else {
            passwordTextInputLayout.setError(null);
        }

        return true;
    }
}