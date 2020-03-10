package com.example.testtaskinconcept.di.app

import com.example.testtaskinconcept.ui.activity.MainActivity
import com.example.testtaskinconcept.ui.fragment.favorite.FavoriteListFragment
import com.example.testtaskinconcept.di.main.PerActivity
import com.example.testtaskinconcept.di.main.PerFragment
import com.example.testtaskinconcept.di.main.ViewModelModule
import com.example.testtaskinconcept.ui.fragment.list.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeMainActivity(): MainActivity


    @PerFragment
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeListFragment(): ListFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeFavoriteListFragment(): FavoriteListFragment
}