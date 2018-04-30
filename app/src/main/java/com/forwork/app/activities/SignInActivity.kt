package com.forwork.app.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.forwork.app.R
import com.forwork.app.helpers.ValidationHelper

import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        configure()
    }

    private fun configure() {
        btn_sign_up!!.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            val email = tie_email!!.text.toString()
            if (email.isNotEmpty()) {
                intent.putExtra("email", email)
            }
            startActivity(intent)
        }

        ivw_enter!!.setOnClickListener {
            if (validate()) {
                //TODO
            }
        }
    }

    private fun validate(): Boolean {
        til_email!!.error = null
        til_password!!.error = null

        if (tie_email!!.text.isNullOrEmpty()) {
            til_email!!.error = getString(R.string.msg_empty_field)
            tie_email!!.requestFocus()
            return false
        }

        if (!ValidationHelper.isEmailValid(tie_email!!.text)) {
            til_email!!.error = getString(R.string.msg_invalid_email)
            tie_email!!.requestFocus()
            return false
        }

        if (tie_password!!.text.isNullOrEmpty()) {
            til_password!!.error = getString(R.string.msg_empty_field)
            tie_password!!.requestFocus()
            return false
        }

        return true
    }
}