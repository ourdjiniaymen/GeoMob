package com.example.geomob.data.repository

import android.app.Application
import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.geomob.data.dao.CountryDao
import com.example.geomob.data.database.CountryDatabase
import com.example.geomob.data.entity.*

class CountryRepository (application: Application?) {


    private val countryDao: CountryDao?
    private val allCountries: LiveData<List<CountryWithAllAttributes?>?>?

    init {
        val database: CountryDatabase? = CountryDatabase.getInstance(application as Context)
        countryDao = database?.countryDao()
        allCountries = countryDao?.getAllCountries()
    }
    fun getCountryByName(country : String) : LiveData<CountryWithAllAttributes?>?{
        return countryDao?.getCountryByName(country)
    }

    fun getAllCountry(): LiveData<List<CountryWithAllAttributes?>?>? {
        return allCountries
    }

    fun addCountry(country: Country) {
        countryDao?.let { InsertCountryAsyncTask(it).execute(country) }
    }

    fun addResource(resource: Resource) {
        countryDao?.let { InsertResourceAsyncTask(it).execute(resource) }
    }

    fun addHistory(history: History) {
        countryDao?.let { InsertHistoryAsyncTask(it).execute(history) }
    }

    fun addPersonality(personality: Personality) {
        countryDao?.let { InsertPersonalityAsyncTask(it).execute(personality) }
    }




    class InsertCountryAsyncTask(private val countryDao: CountryDao) : AsyncTask<Country?, Void?, Void?>() {
        override fun doInBackground(vararg countries: Country?): Void? {
            countries[0]?.let { countryDao.addCountry(it) }
            return null
        }

    }

    class InsertResourceAsyncTask(private val countryDao: CountryDao) : AsyncTask<Resource?, Void?, Void?>() {
        override fun doInBackground(vararg resources: Resource?): Void? {
            resources[0]?.let { countryDao.addResource(it) }
            return null
        }
    }

    class InsertHistoryAsyncTask(private val countryDao: CountryDao) : AsyncTask<History?, Void?, Void?>() {
        override fun doInBackground(vararg histories: History?): Void? {
            histories[0]?.let { countryDao.addHistory(it) }
            return null
        }
    }

    class InsertPersonalityAsyncTask(private val countryDao: CountryDao) : AsyncTask<Personality?, Void?, Void?>() {
        override fun doInBackground(vararg personalities: Personality?): Void? {
            personalities[0]?.let { countryDao.addPersonality(it) }
            return null
        }
    }
}

