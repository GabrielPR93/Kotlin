package com.openwebinars.mydatabase

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        setupRealm()
    }

    fun setupRealm() {
        Realm.init(this)

        val config = RealmConfiguration.Builder()
                .name("openwebinars.realm")
                .build()
        Realm.setDefaultConfiguration(config)
    }
}

