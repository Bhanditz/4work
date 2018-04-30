package com.forwork.app

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDexApplication
import android.support.multidex.MultiDex

class App : MultiDexApplication() {
    init {
        instance = this
    }

    override fun attachBaseContext(base: Context) {
        MultiDex.install(base)
        super.attachBaseContext(base)
    }

    companion object {
        private var instance: App? = null

        val context: Context
            get() = instance!!.applicationContext
    }
}