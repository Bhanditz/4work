package com.forwork.app.helpers

import android.content.Context

import com.forwork.app.App

class LocalStorageManager {
    private val context = App.context

    private fun addItem(key: String, value: String) {
        context.openFileOutput(key, Context.MODE_PRIVATE).use { it.write(value.toByteArray()) }
    }

    private fun getItem(key: String): String? {
        return context.openFileInput(key).bufferedReader().use { it.readText() }
    }

    private fun removeItem(key: String) {
        context.deleteFile(key)
    }
}