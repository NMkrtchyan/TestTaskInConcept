package com.example.testtaskinconcept.ui.activity

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testtaskinconcept.ui.model.Command
import com.example.testtaskinconcept.ui.constants.FAVORITE_LIST_FRAGMENT_COMMAND
import com.example.testtaskinconcept.ui.constants.LIST_FRAGMENT_COMMAND
import com.example.testtaskinconcept.domain.DataUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(private val dataUseCase: DataUseCase) : ViewModel() {

    val commandLiveData: MutableLiveData<Command> = MutableLiveData()

    fun listClick(vieww: View){
        commandLiveData.value =
            Command(LIST_FRAGMENT_COMMAND)
    }

    fun favoriteListClick(vieww: View){
        commandLiveData.value = Command(
            FAVORITE_LIST_FRAGMENT_COMMAND
        )
    }
}