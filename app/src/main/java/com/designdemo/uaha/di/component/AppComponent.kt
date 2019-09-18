package com.designdemo.uaha.di.component

import android.app.Application
import com.designdemo.uaha.HistorianApplication
import com.designdemo.uaha.di.module.ApplicationModule
import com.designdemo.uaha.di.module.ExampleActivityModule
import com.designdemo.uaha.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule


@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    ExampleActivityModule::class,
    ViewModelModule::class])

interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build() : AppComponent

        @BindsInstance
        fun application(appContext: Application) : Builder
    }

   fun inject(historianApplication: HistorianApplication)
}
