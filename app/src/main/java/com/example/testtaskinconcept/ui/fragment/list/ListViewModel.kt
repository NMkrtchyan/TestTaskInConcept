package com.example.testtaskinconcept.ui.fragment.list

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtaskinconcept.domain.DataUseCase
import com.example.testtaskinconcept.ui.adapter.PersonListAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ListViewModel @Inject constructor(
    application: Application,
    private val compositeDisposable: CompositeDisposable,
    private val dataUseCase: DataUseCase
) : ViewModel() {

    init {

        addPersonInRV()
    }

    var personListLayoutManager =
        LinearLayoutManager(application.applicationContext, LinearLayoutManager.VERTICAL, false)
    val personListAdapter = PersonListAdapter()
        .apply {

            favoriteClick = { model ->
                dataUseCase.insertFavValue(model)

            }
        }

    fun addPersonInRV() {
        dataUseCase.getData()
            .flatMap {dataUseCase.addPersonsInDB(it)}

            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                personListAdapter.submitList(it)
            }
            .let { compositeDisposable.add(it) }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}






