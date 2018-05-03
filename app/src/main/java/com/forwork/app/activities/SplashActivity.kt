package com.forwork.app.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.forwork.app.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        configure()
    }

    fun configure() {
        val intent = Intent(this, TimeSheetActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}