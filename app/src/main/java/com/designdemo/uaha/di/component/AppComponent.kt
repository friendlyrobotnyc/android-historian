package com.designdemo.uaha.di.component

import com.designdemo.uaha.HistorianApplication
import com.designdemo.uaha.di.module.ApplicationModule
import com.designdemo.uaha.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class, ViewModelModule::class])
interface AppComponent : AndroidInjector<HistorianApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<HistorianApplication>()
}