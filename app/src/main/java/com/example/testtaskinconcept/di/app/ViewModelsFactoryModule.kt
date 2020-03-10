package com.example.testtaskinconcept.di.app

import androidx.lifecycle.ViewModelProvider
import com.example.testtaskinconcept.ui.viewModelsFactory.ViewModelsProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelsFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelProvider: ViewModelsProviderFactory): ViewModelProvider.Factory
}