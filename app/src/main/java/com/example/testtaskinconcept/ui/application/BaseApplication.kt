package com.example.testtaskinconcept.ui.application

import com.example.testtaskinconcept.di.app.DaggerAppComponent
import com.example.testtaskinconcept.domain.DataUseCase
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject


class BaseApplication : DaggerApplication() {

    @Inject
    lateinit var useCase: DataUseCase

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {

        return DaggerAppComponent
            .builder()
            .application(this)
            .build()
    }

}