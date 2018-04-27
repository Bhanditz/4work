package com.forwork.app.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.forwork.app.R;
import com.forwork.app.helpers.ValidationHelper;

public class SignInActivity extends AppCompatActivity {
    private TextInputLayout emailTextInputLayout;
    private TextInputEditText emailTextInputEditText;
    private TextInputLayout passwordTextInputLayout;
    private TextInputEditText passwordTextInputEditText;
    private ImageView enterImageView;
    private Button signUpButton;

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
        signUpButton = findViewById(R.id.btn_sign_up);
    }

    private void configure() {
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                String email = emailTextInputEditText.getText().toString();
                if (!TextUtils.isEmpty(email)) {
                    intent.putExtra("email", email);
                }
                startActivity(intent);
            }
        });

        enterImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    //TODO
                }
            }
        });
    }

    private boolean validate() {
        emailTextInputLayout.setError(null);
        passwordTextInputLayout.setError(null);

        if (TextUtils.isEmpty(emailTextInputEditText.getText())) {
            emailTextInputLayout.setError(getString(R.string.msg_empty_field));
            emailTextInputEditText.requestFocus();
            return false;
        }

        if (!ValidationHelper.isEmailValid(emailTextInputEditText.getText())) {
            emailTextInputLayout.setError(getString(R.string.msg_invalid_email));
            emailTextInputEditText.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(passwordTextInputEditText.getText())) {
            passwordTextInputLayout.setError(getString(R.string.msg_empty_field));
            passwordTextInputEditText.requestFocus();
            return false;
        }

        return true;
    }
}