package com.example.testtaskinconcept.ui.fragment.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.testtaskinconcept.databinding.FavoriteListFragmentBinding
import com.example.testtaskinconcept.ui.activity.MainViewModel
import com.example.testtaskinconcept.ui.viewModelsFactory.ViewModelsProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class FavoriteListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelsProviderFactory: ViewModelsProviderFactory

    companion object {
        fun newInstance() = FavoriteListFragment()
        val TAG = "FavoriteListFragment"
    }

    private lateinit var viewModel: FavoriteListViewModel
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this,viewModelsProviderFactory).get(FavoriteListViewModel::class.java)
        mainViewModel = ViewModelProvider(activity!!,viewModelsProviderFactory).get(MainViewModel::class.java)
        val binding = FavoriteListFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        val view = binding.root



        return view
    }

}
