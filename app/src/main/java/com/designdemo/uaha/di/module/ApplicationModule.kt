package com.designdemo.uaha.di.module

import android.content.Context
import com.designdemo.uaha.HistorianApplication
import com.designdemo.uaha.view.detail.DetailActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun provideApplicationContext(application: HistorianApplication): Context =
            application.applicationContext


    @Provides
    fun provideWolfson() : Wolfson {
        return object : Wolfson {
            override fun foo() {
            }
        }
    }

    interface Wolfson {
        fun foo()
    }
}

@Module
abstract class ExampleActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): DetailActivity
}