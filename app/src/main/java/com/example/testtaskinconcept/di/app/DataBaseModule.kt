package com.example.testtaskinconcept.di.app

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.room.Room
import com.example.testtaskinconcept.data.local.database.PersonDataBase
import dagger.Module
import dagger.Provides

@Module
class DataBaseModule {

    @Module
    companion object{

        @Provides
        @JvmStatic
        @PerApplication
        fun provideDataBase(application: Application):PersonDataBase{

           return Room.databaseBuilder(
                application,
                PersonDataBase::class.java,
                "PersonDataBase"
            ).fallbackToDestructiveMigration()
               .build()
        }

        @Provides
        @JvmStatic
        @PerApplication
        fun providePersonDao(personDao: PersonDataBase) = personDao.personDao

    }
}