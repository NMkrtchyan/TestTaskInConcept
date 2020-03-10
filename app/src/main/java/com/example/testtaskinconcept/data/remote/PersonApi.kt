package com.example.testtaskinconcept.data.remote

import com.example.testtaskinconcept.data.entity.PersonResponse
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Path

interface PersonApi {
    @GET("{comments}")
    fun getPersonList(@Path("comments") brands: String): Maybe<List<PersonResponse>>
}