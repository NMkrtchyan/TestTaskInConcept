package com.example.testtaskinconcept.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testtaskinconcept.data.entity.PersonResponse
import com.example.testtaskinconcept.data.local.dao.PersonDao

@Database(entities = [PersonResponse::class], version = 1)
abstract class PersonDataBase : RoomDatabase() {
    abstract val personDao: PersonDao
}