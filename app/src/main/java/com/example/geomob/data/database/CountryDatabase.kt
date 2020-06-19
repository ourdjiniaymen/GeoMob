package com.example.geomob.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.geomob.data.dao.CountryDao
import com.example.geomob.data.entity.Country
import com.example.geomob.data.entity.History
import com.example.geomob.data.entity.Personality
import com.example.geomob.data.entity.Resource

@Database(
    entities = [Country::class, History::class, Personality::class, Resource::class],
    version = 1,
    exportSchema = false
)
abstract class CountryDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDao?

    companion object {
        private var instance: CountryDatabase? = null
        @Synchronized
        fun getInstance(context: Context): CountryDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    CountryDatabase::class.java, "countries_database"
                )
                    .fallbackToDestructiveMigration()
                    // .addCallback(roomCallback)
                    .build()
            }
            return instance
        }
        /*private val roomCallback: Callback = object : Callback() {
              override fun onCreate(@NonNull db: SupportSQLiteDatabase) {
                  super.onCreate(db)
                  instance?.let { PopulateDbAsyncTask(it).execute() }
              }
          }

          private open class PopulateDbAsyncTask(db: CountryDatabase) :
              AsyncTask<Void?, Void?, Void?>() {
              private val countryDao : CountryDao = db.countryDao()!!
              protected override fun doInBackground(vararg params: Void?): Void? {
                  countryDao.addCountry(Country())
                  return null
              }

          }*/
    }

}