package com.example.osipteltest.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.osipteltest.data.model.Counter

//@Dao
//interface CounterDao {
//
//    @Query("SELECT * FROM counterentity")
//    suspend fun getAllCounters(): List<CounterEntity>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun saveCounter(counter: CounterEntity)
//}