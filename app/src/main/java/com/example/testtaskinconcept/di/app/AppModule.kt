package com.example.testtaskinconcept.di.app

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module
abstract class AppModule {

    @Module
    companion object{
        @JvmStatic
        @Provides
        fun provideCompositeDisposable() = CompositeDisposable()
    }
}