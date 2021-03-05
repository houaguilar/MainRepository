package com.example.osipteltest.repository

import com.example.osipteltest.data.model.Counter

interface CounterRepository {
    suspend fun getCounters(): ArrayList<Counter>

    suspend fun postCounter(title: String): ArrayList<Counter>

    suspend fun postIncCounter(id: String): ArrayList<Counter>

    suspend fun postDecCounter(id: String): ArrayList<Counter>

    suspend fun deleteCounter(id: String): ArrayList<Counter>

}