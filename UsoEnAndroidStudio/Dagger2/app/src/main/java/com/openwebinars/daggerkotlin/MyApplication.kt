package com.openwebinars.daggerkotlin

import android.app.Application

class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(MyApplication()))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    fun appComponent() : AppComponent = appComponent
}