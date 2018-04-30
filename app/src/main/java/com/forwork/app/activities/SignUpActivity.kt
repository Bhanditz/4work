package com.forwork.app.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.forwork.app.R

import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        configure()
    }

    private fun configure() {
        val email = intent.getStringExtra("email")
        if (!email.isNullOrEmpty()) {
            tie_email.setText(email)
        }
    }
}