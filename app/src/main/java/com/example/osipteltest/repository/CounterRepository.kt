package com.example.osipteltest.repository

import com.example.osipteltest.data.model.Counter

interface CounterRepository {
    suspend fun getCounters(): ArrayList<Counter>

    suspend fun postCounter(title: String): ArrayList<Counter>
}