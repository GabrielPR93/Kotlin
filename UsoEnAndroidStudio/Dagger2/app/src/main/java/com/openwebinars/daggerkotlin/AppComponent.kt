package com.openwebinars.daggerkotlin

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: MyApplication)
    fun inject(mainModule: MainModule): MainComponent
}