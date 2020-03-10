package com.example.testtaskinconcept.data.repository

import com.example.testtaskinconcept.data.entity.PersonResponse
import com.example.testtaskinconcept.data.local.dao.PersonDao
import com.example.testtaskinconcept.data.remote.PersonApi
import com.example.testtaskinconcept.di.app.PerApplication
import io.reactivex.Maybe
import javax.inject.Inject

@PerApplication
class PersonRepository @Inject constructor(private val client: PersonApi,
                                           private val personDao: PersonDao) {

    fun getPersonList(): Maybe<List<PersonResponse>> = client.getPersonList("comments")

    fun insertPersonsInDB(dataItems: List<PersonResponse>) = personDao.insertAll(dataItems)

    fun getAllPerson() = personDao.getAllPerson()

    fun insertFavValue(model: PersonResponse) = personDao.insert(model)

    fun getFavPersons() = personDao.getFavoritePersons()
}