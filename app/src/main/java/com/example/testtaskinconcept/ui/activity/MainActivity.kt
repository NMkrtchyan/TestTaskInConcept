package com.example.testtaskinconcept.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testtaskinconcept.R
import com.example.testtaskinconcept.ui.constants.FAVORITE_LIST_FRAGMENT_COMMAND
import com.example.testtaskinconcept.ui.constants.LIST_FRAGMENT_COMMAND
import com.example.testtaskinconcept.databinding.ActivityMainBinding
import com.example.testtaskinconcept.ui.fragment.favorite.FavoriteListFragment
import com.example.testtaskinconcept.ui.fragment.list.ListFragment
import com.example.testtaskinconcept.ui.viewModelsFactory.ViewModelsProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    lateinit var viewModel: MainViewModel


    @Inject
    lateinit var viewModelsProviderFactory: ViewModelsProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(this, viewModelsProviderFactory).get(MainViewModel::class.java)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        observeLiveData()
        addListFragment()

    }

    fun observeLiveData() {

        viewModel.commandLiveData.observe(this, Observer {
            when (it.command) {
                LIST_FRAGMENT_COMMAND -> addListFragment()
                FAVORITE_LIST_FRAGMENT_COMMAND -> {
                    if (!it.isFirst) {
                        addFavoriteListFragment()
                        it.isFirst = true
                    }
                }
            }

        })
    }


    fun addFavoriteListFragment() {
        val fragment = supportFragmentManager.findFragmentByTag(FavoriteListFragment.TAG) ?:
            FavoriteListFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment, FavoriteListFragment.TAG)
            .commit()


    }

    fun addListFragment() {
        val fragment = supportFragmentManager.findFragmentByTag(ListFragment.TAG) ?:
            ListFragment.newInstance()

                supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment, ListFragment.TAG)
                .commit()

    }

}
