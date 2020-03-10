package com.example.testtaskinconcept.di.main

import androidx.lifecycle.ViewModel
import com.example.testtaskinconcept.di.app.ViewModelKey
import com.example.testtaskinconcept.ui.activity.MainViewModel
import com.example.testtaskinconcept.ui.fragment.favorite.FavoriteListViewModel
import com.example.testtaskinconcept.ui.fragment.list.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule{

    @Binds
    @IntoMap
    @ViewModelKey(value = MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(value = ListViewModel::class)
    abstract fun bindListViewModel(mainFragmentViewModel: ListViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(value = FavoriteListViewModel::class)
    abstract fun bindFavoriteListViewModel(favoriteViewModel: FavoriteListViewModel) : ViewModel

}

