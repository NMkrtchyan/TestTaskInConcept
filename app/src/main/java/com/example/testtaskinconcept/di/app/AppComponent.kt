package com.example.testtaskinconcept.di.app

import android.app.Application
import com.example.testtaskinconcept.ui.application.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@PerApplication
@Component(
    modules = [
        DataBaseModule::class,
        NetworkModule::class,
        AppModule::class,
        ViewModelsFactoryModule::class,
        AndroidInjectionModule::class,
        ActivityBuildersModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent


    }
}
