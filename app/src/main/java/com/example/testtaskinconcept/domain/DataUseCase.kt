package com.example.testtaskinconcept.domain

import com.example.testtaskinconcept.data.entity.PersonResponse
import com.example.testtaskinconcept.data.repository.PersonRepository
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DataUseCase @Inject constructor(
    private val repository: PersonRepository,
    private val compositeDisposable: CompositeDisposable,
    private val networkManager: NetworkManager
) {

    fun getData(): Observable<List<PersonResponse>> =

        if (networkManager.isInternetAvailable()){
            getListFRomServer().toObservable()
        }else{
            getAllPerson().toObservable()
                .subscribeOn(Schedulers.io())
        }

    fun getListFRomServer() = repository.getPersonList()
        .subscribeOn(Schedulers.io())

    fun getAllPerson() = repository.getAllPerson()

    fun addPersonsInDB(list: List<PersonResponse>) : Observable<List<PersonResponse>> {
        return Observable.just(list)
            .subscribeOn(Schedulers.single())
            .doOnNext{repository.insertPersonsInDB(it)}
            .flatMap { repository.getAllPerson().toObservable() }

    }

    fun insertFavValue(model: PersonResponse) {
        Observable.just(model)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe{
                repository.insertFavValue(it)
            }
            .let { compositeDisposable.add(it) }
    }

    fun getFavPersons() = repository.getFavPersons()
        .subscribeOn(Schedulers.io())
}