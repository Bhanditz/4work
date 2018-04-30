package com.forwork.app.helpers

object ValidationHelper {
    fun isEmailValid(email: CharSequence): Boolean {
        return email.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}