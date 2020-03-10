package com.example.testtaskinconcept.ui.fragment.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.testtaskinconcept.databinding.ListFragmentBinding
import com.example.testtaskinconcept.ui.activity.MainViewModel
import com.example.testtaskinconcept.ui.viewModelsFactory.ViewModelsProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class ListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelsProviderFactory: ViewModelsProviderFactory

    companion object {
        fun newInstance() = ListFragment()
        val TAG = "ListFragment"
    }

    private lateinit var viewModel: ListViewModel
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this,viewModelsProviderFactory).get(ListViewModel::class.java)
        mainViewModel = ViewModelProvider(activity!!,viewModelsProviderFactory).get(MainViewModel::class.java)
        val binding = ListFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        val view = binding.root



        return view
    }
}
