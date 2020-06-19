package com.example.geomob.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.geomob.data.entity.*


@Dao
interface CountryDao {
    @Transaction
    @Query("SELECT * FROM country_table ORDER BY name DESC")
    fun getAllCountries(): LiveData<List<CountryWithAllAttributes?>?>?//so we can observe the changes

    @Transaction
    @Query("SELECT * FROM country_table WHERE name = :name ")
    fun getCountryByName(name: String):LiveData<CountryWithAllAttributes?>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCountry(country: Country)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addResource(resource: Resource)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addHistory(history: History)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addPersonality(personality: Personality)

   /* @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addVideo(video: Video)*/

}