package com.example.testtaskinconcept.data.local.dao

import androidx.annotation.NonNull
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testtaskinconcept.data.entity.PersonResponse
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface PersonDao {

    @NonNull
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(list: List<PersonResponse>)

    @Query("SELECT * FROM Person")
    fun getAllPerson() : Single<List<PersonResponse>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(model: PersonResponse)

    @Query("SELECT * FROM  Person WHERE favorite = 1")
    fun getFavoritePersons(): Observable<List<PersonResponse>>
}